package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/19 00:22
 * @Description
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 *
 * 火车票有 三种不同的销售方式 ：
 *
 * 一张 为期一天 的通行证售价为 costs[0] 美元；
 * 一张 为期七天 的通行证售价为 costs[1] 美元；
 * 一张 为期三十天 的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张 为期 7 天 的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 *
 * 返回 你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
 * 输出：11
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
 * 在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
 * 在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
 * 你总共花了 $11，并完成了你计划的每一天旅行。
 * 示例 2：
 *
 * 输入：days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * 输出：17
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[2] = $15 买了一张为期 30 天的通行证，它将在第 1, 2, ..., 30 天生效。
 * 在第 31 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 31 天生效。
 * 你总共花了 $17，并完成了你计划的每一天旅行。
 * @Version 1.0
 */
public class minimumcostfortickets {
    public int mincostTickets(int[] days, int[] costs) {

        int len = days.length;
        // dp[i] 表示满足days中下标从0-i的最小花费
        int[] dp = new int[len];
        dp[0] = Math.min(costs[0], Math.min(costs[1], costs[2]));

        for (int i = 1; i < len; i++) {
            // 买一天的票的最小值
            int cost1 = dp[i - 1] + costs[0];

            // 买七天的票的最小值
            int cost2 = dp[i - 1] + costs[1];
            int j = i - 1;
            while (j >= 0 && days[j] + 6 >= days[i]) {
                if(j == 0){
                    cost2 = Math.min(cost2, costs[1]);
                }else{
                    cost2 = Math.min(cost2, dp[j-1] + costs[1]);
                }
                j--;
            }

            // 买一个月的票
            int cost3 = dp[i - 1] + costs[2];
            int k = i - 1;
            while (k >= 0 && days[k] + 29 >= days[i]) {
                if(k == 0){
                    cost3 = Math.min(cost3, costs[2]);
                }else{
                    cost3 = Math.min(cost3, dp[k-1] + costs[2]);
                }
                k--;
            }

            dp[i] = Math.min(cost1, Math.min(cost2, cost3));
        }


        return dp[len - 1];


    }
}