package com.yzy.simple;

/**
 * Description: leetcode1351
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 请你统计并返回 grid 中 负数 的数目。
 * 示例 1：
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 * 示例 2：
 * 输入：grid = [[3,2],[1,0]]
 * 输出：0
 * @author yzy15
 * @date 2023/04/29 08:52
 **/
public class CountNegativeNumbersinaSortedMatrix {
    public static void main(String[] args) {

    }

    public int countNegatives(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
