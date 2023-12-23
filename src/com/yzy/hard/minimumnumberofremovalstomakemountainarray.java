package com.yzy.hard;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.hard
 * @Date 2023/12/22 09:13
 * @Description
 * 我们定义 arr 是 山形数组 当且仅当它满足：
 *
 * arr.length >= 3
 * 存在某个下标 i （从 0 开始） 满足 0 < i < arr.length - 1 且：
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * 给你整数数组 nums​ ，请你返回将 nums 变成 山形状数组 的​ 最少 删除次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,1]
 * 输出：0
 * 解释：数组本身就是山形数组，所以我们不需要删除任何元素。
 * 示例 2：
 *
 * 输入：nums = [2,1,1,5,6,2,3,1]
 * 输出：3
 * 解释：一种方法是将下标为 0，1 和 5 的元素删除，剩余元素为 [1,5,6,3,1] ，是山形数组。
 * @Version 1.0
 */
public class minimumnumberofremovalstomakemountainarray {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++)
                if (nums[j] < nums[i])
                    max = Math.max(max, left[j]);
            left[i] = max + 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            int max = 0;
            for (int j = n - 1; j > i; j--)
                if (nums[j] < nums[i])
                    max = Math.max(max, right[j]);
            right[i] = max + 1;
        }
        int res = 0;
        for (int i = 0; i < n; i++)
            if (left[i] > 1 && right[i] > 1)
                res = Math.max(res, left[i] + right[i] - 1);
        return n - res;
    }
}