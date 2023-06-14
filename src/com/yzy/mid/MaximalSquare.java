package com.yzy.mid;

/**
 * ClassName: MaximalSquare
 * Description:
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：matrix = [["0"]]
 * 输出：0
 *
 * @author Administrator
 * @date 2023-6-12 10:43
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i - 1][j - 1] != '0') {
                    if (dp[i][j - 1] != 0 && dp[i - 1][j] != 0 && dp[i - 1][j - 1] != 0) {
                        dp[i][j] = (1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])));
                    } else {
                        dp[i][j] = 1;
                    }
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res * res;
    }
}
