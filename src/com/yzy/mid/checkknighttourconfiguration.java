package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/13 00:02
 * @Description
 * 骑士在一张 n x n 的棋盘上巡视。在有效的巡视方案中，骑士会从棋盘的 左上角 出发，并且访问棋盘上的每个格子 恰好一次 。
 *
 * 给你一个 n x n 的整数矩阵 grid ，由范围 [0, n * n - 1] 内的不同整数组成，其中 grid[row][col] 表示单元格 (row, col) 是骑士访问的第 grid[row][col] 个单元格。骑士的行动是从下标 0 开始的。
 *
 * 如果 grid 表示了骑士的有效巡视方案，返回 true；否则返回 false。
 *
 * 注意，骑士行动时可以垂直移动两个格子且水平移动一个格子，或水平移动两个格子且垂直移动一个格子。下图展示了骑士从某个格子出发可能的八种行动路线。
 *
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[0,11,16,5,20],[17,4,19,10,15],[12,1,8,21,6],[3,18,23,14,9],[24,13,2,7,22]]
 * 输出：true
 * 解释：grid 如上图所示，可以证明这是一个有效的巡视方案。
 * 示例 2：
 *
 *
 * 输入：grid = [[0,3,6],[5,8,1],[2,7,4]]
 * 输出：false
 * 解释：grid 如上图所示，考虑到骑士第 7 次行动后的位置，第 8 次行动是无效的。
 * @Version 1.0
 */
public class checkknighttourconfiguration {
    int[][] dirs = new int[][]{{2, 1}, {2, -1}, {1, 2}, {1, -2}, {-2, 1}, {-2, -1}, {-1, 2}, {-1, -2}};

    public boolean checkValidGrid(int[][] grid) {
        return dfs(grid, 0, 0, 0);
    }

    boolean dfs(int[][] grid, int i, int j, int v) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != v) {
            return false;
        }
        if (v == grid.length * grid[0].length - 1) return true;
        boolean res = false;
        for (int[] dir : dirs) {
            res = res || dfs(grid, i + dir[0], j + dir[1], v + 1);
        }
        return res;
    }
}