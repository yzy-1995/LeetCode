package com.yzy.simple;

import java.util.Arrays;

/**
 * ClassName: LargestPositiveIntegerThatExistsWithItsNegative
 * Description:
 * 给你一个 不包含 任何零的整数数组 nums ，找出自身与对应的负数都在数组中存在的最大正整数 k 。
 * 返回正整数 k ，如果不存在这样的整数，返回 -1 。
 * 示例 1：
 * 输入：nums = [-1,2,-3,3]
 * 输出：3
 * 解释：3 是数组中唯一一个满足题目要求的 k 。
 * 示例 2：
 * 输入：nums = [-1,10,6,7,-7,1]
 * 输出：7
 * 解释：数组中存在 1 和 7 对应的负数，7 的值更大。
 * 示例 3：
 * 输入：nums = [-10,8,6,7,-2,-3]
 * 输出：-1
 * 解释：不存在满足题目要求的 k ，返回 -1 。
 *
 * @author Administrator
 * @date 2023-5-10 16:01
 */
public class LargestPositiveIntegerThatExistsWithItsNegative {
    public static void main(String[] args) {

    }

    public int findMaxK(int[] nums) {
//        boolean[] note = new boolean[2001];
//        int res = 0;
//        for (int i = 0; i < nums.length; i++) {
//            note[nums[i] + 1000] = true;
//            if (note[1000 - nums[i]]) {
//                res = Math.max(res, Math.abs(nums[i]));
//            }
//        }
//        return res == 0 ? -1 : res;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == 0)
                return nums[right];
            if (nums[left] + nums[right] < 0)
                left++;
            if (nums[left] + nums[right] > 0)
                right--;

        }
        return -1;
    }
}
