package com.yzy.mid;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/09 10:46
 * @Description
 * 给你一个 m x n 的网格 grid。网格里的每个单元都代表一条街道。grid[i][j] 的街道可以是：
 *
 * 1 表示连接左单元格和右单元格的街道。
 * 2 表示连接上单元格和下单元格的街道。
 * 3 表示连接左单元格和下单元格的街道。
 * 4 表示连接右单元格和下单元格的街道。
 * 5 表示连接左单元格和上单元格的街道。
 * 6 表示连接右单元格和上单元格的街道。
 *
 *
 * 你最开始从左上角的单元格 (0,0) 开始出发，网格中的「有效路径」是指从左上方的单元格 (0,0) 开始、一直到右下方的 (m-1,n-1) 结束的路径。该路径必须只沿着街道走。
 *
 * 注意：你 不能 变更街道。
 *
 * 如果网格中存在有效的路径，则返回 true，否则返回 false 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[2,4,3],[6,5,2]]
 * 输出：true
 * 解释：如图所示，你可以从 (0, 0) 开始，访问网格中的所有单元格并到达 (m - 1, n - 1) 。
 * 示例 2：
 *
 *
 *
 * 输入：grid = [[1,2,1],[1,2,1]]
 * 输出：false
 * 解释：如图所示，单元格 (0, 0) 上的街道没有与任何其他单元格上的街道相连，你只会停在 (0, 0) 处。
 * 示例 3：
 *
 * 输入：grid = [[1,1,2]]
 * 输出：false
 * 解释：你会停在 (0, 1)，而且无法到达 (0, 2) 。
 * 示例 4：
 *
 * 输入：grid = [[1,1,1,1,1,1,3]]
 * 输出：true
 * 示例 5：
 *
 * 输入：grid = [[2],[2],[2],[2],[2],[2],[6]]
 * 输出：true
 * @Version 1.0
 */
public class checkifthereisavalidpathinagrid {
    public boolean hasValidPath(int[][] grid) {
        // 0: up, 1: down, 2: left, 3: right,
        int[][] direction = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int[][] conn = new int[][]{{2,3},{0,1},{1,2},{1,3},{0,2},{0,3}};
        int m = grid.length, n = grid[0].length;
        boolean[][] dp = new boolean[m][n];
        dp[m - 1][n - 1] = true;
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{m - 1, n - 1});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int neighbor : conn[grid[cur[0]][cur[1]] - 1]) { //遍历连接的两个邻居
                int x = cur[0] + direction[neighbor][0];
                int y = cur[1] + direction[neighbor][1]; //找到对应的坐标
                int target = neighbor < 2 ? 1 - neighbor : 5 - neighbor; //判断需要邻居坐标处是否有道路到达当前位置
                if(x >= 0 && x < m && y >= 0 && y < n && !dp[x][y]
                        && (conn[grid[x][y] - 1][0] == target || conn[grid[x][y] - 1][1] == target)) {
                    dp[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return dp[0][0];
    }
}