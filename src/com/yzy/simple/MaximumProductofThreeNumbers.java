package com.yzy.simple;

import java.util.Arrays;

/**
 * Description: leetcode628.
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：6
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：24
 * 示例 3：
 * 输入：nums = [-1,-2,-3]
 * 输出：-6
 * @author yzy15
 * @date 2023/04/15 10:19
 **/
public class MaximumProductofThreeNumbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[nums.length-1] * nums[nums.length-2] * nums[nums.length-3],nums[0]*nums[1]*nums[nums.length-1]);
    }
}
