package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/02 00:03
 * @Description
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 *
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 *
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 *
 * 请你返回「表现良好时间段」的最大长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：hours = [9,9,6,0,6,6,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 * 示例 2：
 *
 * 输入：hours = [6,6,6]
 * 输出：0
 * @Version 1.0
 */
public class longestwellperforminginterval {
    public int longestWPI(int[] hours) {
        int n = hours.length, max = 0;
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) arr[i + 1] = arr[i] + (hours[i] > 8 ? 1 : -1);
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= i; j++)
                if (arr[i] > arr[j])  max = Math.max(max, i - j);
        return max;
    }
}