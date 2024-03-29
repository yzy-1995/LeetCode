package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/17 20:51
 * @Description
 * 给定数组 nums 和一个整数 k 。我们将给定的数组 nums 分成 最多 k 个非空子数组，且数组内部是连续的 。 分数 由每个子数组内的平均值的总和构成。
 *
 * 注意我们必须使用 nums 数组中的每一个数进行分组，并且分数不一定需要是整数。
 *
 * 返回我们所能得到的最大 分数 是多少。答案误差在 10-6 内被视为是正确的。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [9,1,2,3,9], k = 3
 * 输出: 20.00000
 * 解释:
 * nums 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20.
 * 我们也可以把 nums 分成[9, 1], [2], [3, 9].
 * 这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
 * 示例 2:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 4
 * 输出: 20.50000
 * @Version 1.0
 */
public class largestsumofaverages {
    public double largestSumOfAverages(int[] A, int K) {

        double[][] dp = new double[A.length+1][K+1];
        double[] sum = new double[A.length+1];

        for(int i = 1; i <= A.length; ++i) {
            sum[i] = sum[i-1] + A[i-1];
            dp[i][1] = sum[i] / i;
        }
        for(int i = 1; i <= A.length; ++i) {
            for(int k = 2; k <= K; ++k) {
                for(int j = 0; j < i; ++j) {
                    dp[i][k] = Math.max(dp[i][k], dp[j][k-1] + (sum[i]-sum[j]) / (i-j));
                }
            }
        }

        return dp[A.length][K];
    }
}