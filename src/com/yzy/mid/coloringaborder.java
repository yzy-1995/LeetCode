package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/26 00:15
 * @Description
 * 给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色。
 *
 * 如果两个方块在任意 4 个方向上相邻，则称它们 相邻 。
 *
 * 如果两个方块具有相同的颜色且相邻，它们则属于同一个 连通分量 。
 *
 * 连通分量的边界 是指连通分量中满足下述条件之一的所有网格块：
 *
 * 在上、下、左、右任意一个方向上与不属于同一连通分量的网格块相邻
 * 在网格的边界上（第一行/列或最后一行/列）
 * 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色。
 *
 * 并返回最终的网格 grid 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
 * 输出：[[3,3],[3,2]]
 * 示例 2：
 *
 * 输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
 * 输出：[[1,3,3],[2,3,3]]
 * 示例 3：
 *
 * 输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
 * 输出：[[2,2,2],[2,1,2],[2,2,2]]
 * @Version 1.0
 */
public class coloringaborder {
    public void dfs(int[][]grid, int x, int  y, int pre, int color, int[][]mask) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != pre) {
            return;
        }
        grid[x][y] = color;
        mask[x][y] = 1;
        dfs(grid, x - 1, y, pre ,color, mask);
        dfs(grid, x + 1, y, pre ,color, mask);
        dfs(grid, x, y - 1, pre ,color, mask);
        dfs(grid, x, y + 1, pre ,color, mask);
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        if (grid[row][col] == color) {
            return grid;
        }
        int pre = grid[row][col];
        int[][]mask = new int[grid.length][grid[0].length];
        dfs(grid, row, col, pre ,color, mask);
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (mask[i][j] == 1 && mask[i - 1][j] == 1 && mask[i + 1][j] == 1 && mask[i][j - 1] == 1 && mask[i][j + 1] == 1) {
                    grid[i][j] = pre;
                }
            }
        }
        return grid;
    }
}