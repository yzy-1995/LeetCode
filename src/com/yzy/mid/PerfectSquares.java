package com.yzy.mid;

import java.util.Arrays;

/**
 * ClassName: PerfectSquares
 * Description:
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 * <p>
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 *
 * @author Administrator
 * @date 2023-6-20 10:22
 */
public class PerfectSquares {

    public int numSquares(int n) {
        int max = (int) Math.sqrt(n);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i <= max; i++) {
            int square = i * i;
            for (int j = square; j <= n; j++) {
                if (dp[j - square] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - square] + 1);
                }
            }
        }
        return dp[n];
    }
}
