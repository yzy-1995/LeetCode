package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/24 10:49
 * @Description
 * 给你一个二进制矩阵 matrix ，它的大小为 m x n ，你可以将 matrix 中的 列 按任意顺序重新排列。
 *
 * 请你返回最优方案下将 matrix 重新排列后，全是 1 的子矩阵面积。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：matrix = [[0,0,1],[1,1,1],[1,0,1]]
 * 输出：4
 * 解释：你可以按照上图方式重新排列矩阵的每一列。
 * 最大的全 1 子矩阵是上图中加粗的部分，面积为 4 。
 * 示例 2：
 *
 *
 *
 * 输入：matrix = [[1,0,1,0,1]]
 * 输出：3
 * 解释：你可以按照上图方式重新排列矩阵的每一列。
 * 最大的全 1 子矩阵是上图中加粗的部分，面积为 3 。
 * 示例 3：
 *
 * 输入：matrix = [[1,1,0],[1,0,1]]
 * 输出：2
 * 解释：由于你只能整列整列重新排布，所以没有比面积为 2 更大的全 1 子矩形。
 * 示例 4：
 *
 * 输入：matrix = [[0,0],[0,0]]
 * 输出：0
 * 解释：由于矩阵中没有 1 ，没有任何全 1 的子矩阵，所以面积为 0 。
 * @Version 1.0
 */
public class largestsubmatrixwithrearrangements {
    public int largestSubmatrix(int[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix[0].length; i++){
            for (int j = 0; j < matrix.length; j++){
                if (matrix[j][i] == 1) matrix[j][i] = j > 0 ? matrix[j-1][i] + 1 : 1;
            }
        }

        for (int i = matrix.length - 1; i >= 0; i--){
            Arrays.sort(matrix[i]);
            for (int j = matrix[0].length - 1; j > -1; j--){
                max = Math.max(max,(matrix[0].length - j) * matrix[i][j]);
            }
        }

        return max;
    }
}