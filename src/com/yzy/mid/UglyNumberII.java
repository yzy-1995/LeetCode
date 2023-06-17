package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/06/18 01:46
 * @Description 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * <p>
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 * @Version 1.0
 */
public class UglyNumberII {

    public int nthUglyNumber(int n) {
        int a2 = 0, a3 = 0, a5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(2 * dp[a2], Math.min(3 * dp[a3], 5 * dp[a5]));
            if (dp[i] == 2 * dp[a2]) a2++;
            if (dp[i] == 3 * dp[a3]) a3++;
            if (dp[i] == 5 * dp[a5]) a5++;
        }
        return dp[n - 1];
    }
}