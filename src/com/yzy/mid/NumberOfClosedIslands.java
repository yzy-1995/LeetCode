package com.yzy.mid;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/06/18 01:37
 * @Description 二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。
 * <p>
 * 请返回 封闭岛屿 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * 输出：2
 * 解释：
 * 灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,1,1,1,1,1],
 * [1,0,0,0,0,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,1,0,1,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,0,0,0,0,1],
 * [1,1,1,1,1,1,1]]
 * 输出：2
 * @Version 1.0
 */
public class NumberOfClosedIslands {
    int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && check(grid, m, n, i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean check(int[][] grid, int m, int n, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        grid[i][j] = 1;
        q.add(new int[]{i, j});
        boolean ans = true;
        while (!q.isEmpty()) {
            int[] a = q.poll();
            for (int[] mov : move) {
                int x = a[0] + mov[0];
                int y = a[1] + mov[1];
                if (x < 0 || x == m || y < 0 || y == n) {
                    ans = false;
                    continue;
                }
                if (grid[x][y] == 0) {
                    grid[x][y] = 1;
                    q.add(new int[]{x, y});
                }
            }
        }
        return ans;
    }
}