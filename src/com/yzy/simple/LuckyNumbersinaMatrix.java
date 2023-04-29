package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: leetcode1380
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 *
 * 幸运数 是指矩阵中满足同时下列两个条件的元素：
 *
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * 输出：[15]
 * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 2：
 *
 * 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * 输出：[12]
 * 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 3：
 *
 * 输入：matrix = [[7,8],[1,2]]
 * 输出：[7]
 * 解释：7是唯一的幸运数字，因为它是行中的最小值，列中的最大值。
 * @author yzy15
 * @date 2023/04/29 13:10
 **/
public class LuckyNumbersinaMatrix {
    public static void main(String[] args) {

    }

    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rowMins = new int[m];
        int[] colMaxs = new int[n];

        // Find the minimum values in each row
        for (int i = 0; i < m; i++) {
            int rowMin = matrix[i][0];
            for (int j = 1; j < n; j++) {
                rowMin = Math.min(rowMin, matrix[i][j]);
            }
            rowMins[i] = rowMin;
        }

        // Find the maximum values in each column
        for (int j = 0; j < n; j++) {
            int colMax = matrix[0][j];
            for (int i = 1; i < m; i++) {
                colMax = Math.max(colMax, matrix[i][j]);
            }
            colMaxs[j] = colMax;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == rowMins[i] && matrix[i][j] == colMaxs[j]) {
                    result.add(matrix[i][j]);
                }
            }
        }

        return result;
    }
}
