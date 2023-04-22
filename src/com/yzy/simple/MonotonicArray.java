package com.yzy.simple;

/**
 * Description: leetcode896
 * 如果数组是单调递增或单调递减的，那么它是 单调 的。
 * 如果对于所有 i <= j，nums[i] <= nums[j]，那么数组 nums 是单调递增的。 如果对于所有 i <= j，nums[i]> = nums[j]，那么数组 nums 是单调递减的。
 * 当给定的数组 nums 是单调数组时返回 true，否则返回 false。
 * 示例 1：
 * 输入：nums = [1,2,2,3]
 * 输出：true
 * 示例 2：
 * 输入：nums = [6,5,4,4]
 * 输出：true
 * 示例 3：
 * 输入：nums = [1,3,2]
 * 输出：false
 * @author yzy15
 * @date 2023/04/22 12:25
 **/
public class MonotonicArray {
    public static void main(String[] args) {

    }

    public boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                increasing = false;
            }
            if (nums[i] < nums[i + 1]) {
                decreasing = false;
            }
        }

        return increasing || decreasing;
    }
}
