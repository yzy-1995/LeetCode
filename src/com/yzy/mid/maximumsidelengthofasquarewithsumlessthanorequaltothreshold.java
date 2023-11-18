package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/18 00:24
 * @Description
 * 给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。
 *
 * 请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0 。
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
 * 输出：2
 * 解释：总和小于或等于 4 的正方形的最大边长为 2，如图所示。
 * 示例 2：
 *
 * 输入：mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1
 * @Version 1.0
 */
public class maximumsidelengthofasquarewithsumlessthanorequaltothreshold {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int res = 0;
        int[][] sum = new int[m + 1][n + 1];

        // 根据容斥原理计算前缀和
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = mat[i - 1][j - 1] + sum[i][j - 1]
                        + sum[i - 1][j] - sum[i - 1][j - 1];
            }
        }

        // 根据所求出前缀和求解
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= i && k <= j; k++) {
                    // 从边长为1开始扩展正方形大小
                    int ans = sum[i][j] - sum[i - k][j] - sum[i][j - k] + sum[i - k][j - k];
                    if (ans > threshold) {
                        break;
                    }
                    res = Math.max(res, k);
                }
            }
        }
        return res;
    }
}