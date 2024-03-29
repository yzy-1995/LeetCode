package com.yzy.mid;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/30 22:12
 * @Description
 * 给你一个大小为 m x n 的整数矩阵 isWater ，它代表了一个由 陆地 和 水域 单元格组成的地图。
 *
 * 如果 isWater[i][j] == 0 ，格子 (i, j) 是一个 陆地 格子。
 * 如果 isWater[i][j] == 1 ，格子 (i, j) 是一个 水域 格子。
 * 你需要按照如下规则给每个单元格安排高度：
 *
 * 每个格子的高度都必须是非负的。
 * 如果一个格子是 水域 ，那么它的高度必须为 0 。
 * 任意相邻的格子高度差 至多 为 1 。当两个格子在正东、南、西、北方向上相互紧挨着，就称它们为相邻的格子。（也就是说它们有一条公共边）
 * 找到一种安排高度的方案，使得矩阵中的最高高度值 最大 。
 *
 * 请你返回一个大小为 m x n 的整数矩阵 height ，其中 height[i][j] 是格子 (i, j) 的高度。如果有多种解法，请返回 任意一个 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：isWater = [[0,1],[0,0]]
 * 输出：[[1,0],[2,1]]
 * 解释：上图展示了给各个格子安排的高度。
 * 蓝色格子是水域格，绿色格子是陆地格。
 * 示例 2：
 *
 *
 *
 * 输入：isWater = [[0,0,1],[1,0,0],[0,0,0]]
 * 输出：[[1,1,0],[0,1,1],[1,2,2]]
 * 解释：所有安排方案中，最高可行高度为 2 。
 * 任意安排方案中，只要最高高度为 2 且符合上述规则的，都为可行方案。
 * @Version 1.0
 */
public class mapofhighestpeak {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int isHeight[][] = new int[m][n];
        //队列进行多源BFS
        Deque<int[]> deque = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //所有水域入队
                if(isWater[i][j] == 1){
                    deque.add(new int[]{i,j});
                    isHeight[i][j] = 0;
                }
            }
        }

        //遍历方向
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!deque.isEmpty()){
            int[] poll = deque.poll();
            int dx = poll[0];
            int dy = poll[1];
            int height = isHeight[dx][dy]; //获取当前高度
            for(int[] dir : dirs){
                //记录扩散遍历到的点的坐标
                int nx = dx + dir[0];
                int ny = dy + dir[1];
                //越界判断，跳出
                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                //该点已经到过，跳出，即isWater[][]不为0
                if(isWater[nx][ny] != 0) continue;
                //到达新陆地
                isHeight[nx][ny] = height + 1;
                isWater[nx][ny] = height + 1;
                deque.add(new int[]{nx,ny});
            }
        }
        return isHeight;
    }
}