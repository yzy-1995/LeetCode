package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/25 13:34
 * @Description
 * 给你一个数组 nums ，它包含 n 个正整数。你需要计算所有非空连续子数组的和，并将它们按升序排序，得到一个新的包含 n * (n + 1) / 2 个数字的数组。
 *
 * 请你返回在新数组中下标为 left 到 right （下标从 1 开始）的所有数字和（包括左右端点）。由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4], n = 4, left = 1, right = 5
 * 输出：13
 * 解释：所有的子数组和为 1, 3, 6, 10, 2, 5, 9, 3, 7, 4 。将它们升序排序后，我们得到新的数组 [1, 2, 3, 3, 4, 5, 6, 7, 9, 10] 。下标从 le = 1 到 ri = 5 的和为 1 + 2 + 3 + 3 + 4 = 13 。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4], n = 4, left = 3, right = 4
 * 输出：6
 * 解释：给定数组与示例 1 一样，所以新数组为 [1, 2, 3, 3, 4, 5, 6, 7, 9, 10] 。下标从 le = 3 到 ri = 4 的和为 3 + 3 = 6 。
 * 示例 3：
 *
 * 输入：nums = [1,2,3,4], n = 4, left = 1, right = 10
 * 输出：50
 * @Version 1.0
 */
public class rangesumofsortedsubarraysums {
    public int rangeSum(int[] nums, int n, int left, int right) {

        int[] sum = new int[n * (n + 1) / 2];
        int index = 0;
        final int MOD = (int) 1e9 + 7;

        for(int i = 0 ; i < nums.length;i++) {
            int s = 0;
            for (int j = i; j < nums.length; j++) {

                s += nums[j];
                sum[index++] = s;
            }
        }

        Arrays.sort(sum);

        int res = 0;
        for(int i = left-1; i < right; i++){
            res = (res + sum[i]) % MOD;
        }
        return res ;
    }
}