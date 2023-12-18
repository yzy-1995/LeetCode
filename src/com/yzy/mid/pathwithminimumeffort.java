package com.yzy.mid;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/11 00:06
 * @Description
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 *
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 *
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
 * 输出：2
 * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
 * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
 * 示例 2：
 *
 *
 *
 * 输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
 * 输出：1
 * 解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
 * 示例 3：
 *
 *
 * 输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * 输出：0
 * 解释：上图所示路径不需要消耗任何体力。
 * @Version 1.0
 */
public class pathwithminimumeffort {
    private static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] visited = new boolean[m][n];
        //优先队列保证每次出来的都是目前差值最小的  <[x, y, 到达heights[x][y]最大路径高度差值]>
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        //加入起点，起点就是终点的话差值就是0
        minHeap.add(new int[]{0, 0, 0});
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int x = cur[0], y = cur[1], maxValue = cur[2];
            //如果当前节点被访问过就不能继续，避免死循环
            if (visited[x][y]) continue;
            //优先队列根据最大路径差值进行poll，poll出来的如果是终点，就说明已经找到了最小体力消耗的路径，结果就是最小路径上的最大路径高度差值
            if (x == m - 1 && y == n - 1) return maxValue;
            visited[x][y] = true;
            for (int[] dir : dirs) {
                int x1 = x + dir[0], y1 = y + dir[1];
                //邻节点的边界处理
                if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n) continue;
                //到达邻接点的最大路径高度差值只依赖了当前节点和邻节点的高度差，也就是heights[x][y]-heights[x1][y1]，而maxValue为到达(x, y)的最大路径高度差值，
                //maxValue在到达(x1, y1)之前已经计算过。根据题目要求，每一个邻接点都需要更新到达邻接点的最大路径高度差值，取最大值
                minHeap.add(new int[]{x1, y1, Math.max(Math.abs(heights[x][y] - heights[x1][y1]), maxValue)});
            }
        }
        return 0;
    }
}