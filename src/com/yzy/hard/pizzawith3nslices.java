package com.yzy.hard;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.hard
 * @Date 2023/08/18 00:01
 * @Description
 * 给你一个披萨，它由 3n 块不同大小的部分组成，现在你和你的朋友们需要按照如下规则来分披萨：
 *
 * 你挑选 任意 一块披萨。
 * Alice 将会挑选你所选择的披萨逆时针方向的下一块披萨。
 * Bob 将会挑选你所选择的披萨顺时针方向的下一块披萨。
 * 重复上述过程直到没有披萨剩下。
 * 每一块披萨的大小按顺时针方向由循环数组 slices 表示。
 *
 * 请你返回你可以获得的披萨大小总和的最大值。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：slices = [1,2,3,4,5,6]
 * 输出：10
 * 解释：选择大小为 4 的披萨，Alice 和 Bob 分别挑选大小为 3 和 5 的披萨。然后你选择大小为 6 的披萨，Alice 和 Bob 分别挑选大小为 2 和 1 的披萨。你获得的披萨总大小为 4 + 6 = 10 。
 * 示例 2：
 *
 *
 *
 * 输入：slices = [8,9,8,6,1,1]
 * 输出：16
 * 解释：两轮都选大小为 8 的披萨。如果你选择大小为 9 的披萨，你的朋友们就会选择大小为 8 的披萨，这种情况下你的总和不是最大的。
 * @Version 1.0
 */
public class pizzawith3nslices {
    public int maxSizeSlices(int[] slices) {
        int length = slices.length;
        int picks = length / 3;
        // dp[i][j][s] 表示前i块披萨，拿了j块，最大值是多少，s表示第i块披萨是要还是不要
        int[][][] dp = new int[length][picks + 1][2];

        // 分第一块要和第一块不要两种情况
        int result = 0;
        // 第一块要
        dp[0][1][1] = slices[0];
        for (int i = 1; i < length; ++i) {
            if (i == length - 1) {
                // 对于最后一块pisa
                // 第一块要了，那么它必须不能要
                continue;
            }

            for (int j = 1; j <= picks; ++j) {
                // 对于第二块，只能选择不要
                if (i == 1) {
                    dp[i][j][0] = dp[i - 1][j][1];
                    continue;
                }
                // 对于第i块披萨，如果要，那么最大值为i-1不要，拿了j-1块
                dp[i][j][1] = dp[i - 1][j - 1][0] + slices[i];
                // 如果不要，那么最大值为i-1不要，拿了j块，或i-1要，拿了j块
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1]);
            }
            result = Math.max(result, Math.max(dp[i][picks][1], dp[i][picks][0]));
        }

        // 第一块不要
        dp[0][1][1] = 0;
        // 第二块可以要，也可以不要，所以不需要特殊处理
        for (int i = 1; i < length; ++i) {
            for (int j = 1; j <= picks; ++j) {
                // 对于第i块披萨，如果要，那么最大值为i-1不要，拿了j-1块
                dp[i][j][1] = dp[i - 1][j - 1][0] + slices[i];
                // 如果不要，那么最大值为i-1不要，拿了j块，或i-1要，拿了j块
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1]);
            }
            result = Math.max(result, Math.max(dp[i][picks][1], dp[i][picks][0]));
        }
        return result;
    }
}