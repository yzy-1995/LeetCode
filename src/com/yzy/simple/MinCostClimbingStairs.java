package com.yzy.simple;

/**
 * ClassName: MinCostClimbingStairs
 * Description:leetcode746
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。
 * 一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 * 示例 1：
 * 输入：cost = [10,15,20]
 * 输出：15
 * 解释：你将从下标为 1 的台阶开始。
 * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
 * 总花费为 15 。
 * 示例 2：
 * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
 * 输出：6
 * 解释：你将从下标为 0 的台阶开始。
 * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
 * 总花费为 6 。
 *
 * @author Administrator
 * @date 2023-4-19 14:31
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {

    }

    /**
     * 1.定义一个长度为 n+1 的数组 dp，其中 dp[i] 表示达到第 i 个台阶的最低花费。
     * 2.初始化 dp[0] 和 dp[1] 为 0，因为从第 0 个台阶和第 1 个台阶出发不需要支付费用。
     * 3.对于 i>=2，根据题目要求，可以选择从第 i-1 个台阶向上爬一个台阶，或者从第 i-2 个台阶向上爬两个台阶，因此有以下状态转移方程：
     * dp[i] = min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2])
     * 其中 cost[i-1] 表示从第 i-1 个台阶向上爬一个台阶需要支付的费用，cost[i-2] 表示从第 i-2 个台阶向上爬两个台阶需要支付的费用。
     * 4.最终返回 dp[n]，表示达到楼梯顶部的最低花费。
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}
