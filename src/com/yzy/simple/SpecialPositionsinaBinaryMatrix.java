package com.yzy.simple;

/**
 * Description: leetcode1582
 * 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵 mat 中特殊位置的数目 。
 * 特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
 * 示例 1：
 * 输入：mat = [[1,0,0],
 *             [0,0,1],
 *             [1,0,0]]
 * 输出：1
 * 解释：(1,2) 是一个特殊位置，因为 mat[1][2] == 1 且所处的行和列上所有其他元素都是 0
 * 示例 2：
 * 输入：mat = [[1,0,0],
 *             [0,1,0],
 *             [0,0,1]]
 * 输出：3
 * 解释：(0,0), (1,1) 和 (2,2) 都是特殊位置
 * 示例 3：
 * 输入：mat = [[0,0,0,1],
 *             [1,0,0,0],
 *             [0,1,1,0],
 *             [0,0,0,0]]
 * 输出：2
 * 示例 4：
 * 输入：mat = [[0,0,0,0,0],
 *             [1,0,0,0,0],
 *             [0,1,0,0,0],
 *             [0,0,1,0,0],
 *             [0,0,0,1,1]]
 * 输出：3
 * @author yzy15
 * @date 2023/04/30 17:09
 **/
public class SpecialPositionsinaBinaryMatrix {
    public static void main(String[] args) {

    }


    public int numSpecial(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int specialPositions = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    // Check if the current row and column contain only one 1
                    if (countOnesInRow(mat, i) == 1 && countOnesInColumn(mat, j) == 1) {
                        specialPositions++;
                    }
                }
            }
        }

        return specialPositions;
    }

    private int countOnesInRow(int[][] mat, int row) {
        int count = 0;
        for (int j = 0; j < mat[row].length; j++) {
            if (mat[row][j] == 1) {
                count++;
            }
        }
        return count;
    }

    private int countOnesInColumn(int[][] mat, int col) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] == 1) {
                count++;
            }
        }
        return count;
    }
}
