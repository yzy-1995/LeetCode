package com.yzy.hard;

import java.util.Arrays;

/**
 * ClassName: ParallelCoursesII
 * Description:
 * 给你一个整数 n 表示某所大学里课程的数目，编号为 1 到 n ，数组 relations 中， relations[i] = [xi, yi]  表示一个先修课的关系，
 * 也就是课程 xi 必须在课程 yi 之前上。同时你还有一个整数 k 。
 * <p>
 * 在一个学期中，你 最多 可以同时上 k 门课，前提是这些课的先修课在之前的学期里已经上过了。
 * <p>
 * 请你返回上完所有课最少需要多少个学期。题目保证一定存在一种上完所有课的方式。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, relations = [[2,1],[3,1],[1,4]], k = 2
 * 输出：3
 * 解释：上图展示了题目输入的图。在第一个学期中，我们可以上课程 2 和课程 3 。然后第二个学期上课程 1 ，第三个学期上课程 4 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 5, relations = [[2,1],[3,1],[4,1],[1,5]], k = 2
 * 输出：4
 * 解释：上图展示了题目输入的图。一个最优方案是：第一学期上课程 2 和 3，第二学期上课程 4 ，第三学期上课程 1 ，第四学期上课程 5 。
 * 示例 3：
 * <p>
 * 输入：n = 11, relations = [], k = 2
 * 输出：6
 *
 * @author Administrator
 * @date 2023-6-16 13:32
 */
public class ParallelCoursesII {

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] pre = new int[n];
        int all = 1 << n;
        int[] dp = new int[all];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int[] relation : relations) pre[relation[1] - 1] |= 1 << (relation[0] - 1);
        for (int state = 0; state < all; state++) {
            int next = 0;
            for (int i = 0; i < n; i++) if ((state & pre[i]) == pre[i]) next |= 1 << i;
            next &= ~state;
            for (int sub = next; sub > 0; sub = (sub - 1) & next) {
                if (Integer.bitCount(sub) <= k) {
                    int nextTotal = state | sub;
                    dp[nextTotal] = Math.min(dp[nextTotal], dp[state] + 1);
                }
            }
        }
        return dp[all - 1];
    }
}
