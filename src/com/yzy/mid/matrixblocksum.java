package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/22 00:05
 * @Description
 * 给你一个 m x n 的矩阵 mat 和一个整数 k ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和：
 *
 * i - k <= r <= i + k,
 * j - k <= c <= j + k 且
 * (r, c) 在矩阵内。
 *
 *
 * 示例 1：
 *
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[12,21,16],[27,45,33],[24,39,28]]
 * 示例 2：
 *
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
 * 输出：[[45,45,45],[45,45,45],[45,45,45]]
 * @Version 1.0
 */
public class matrixblocksum {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int sum = 0;
                for (int r = Math.max(i - K, 0); r <= Math.min(i + K, mat.length - 1); r++) {
                    for (int c = Math.max(j - K, 0); c <= Math.min(j + K, mat[0].length - 1); c++) {
                        sum += mat[r][c];
                    }
                }
                res[i][j] = sum;
            }
        }
        return res;
    }
}