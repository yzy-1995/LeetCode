package com.yzy.simple;

import java.util.Arrays;

/**
 * ClassName: FindGreatestCommonDivisorofArray
 * Description:
 * 给你一个整数数组 nums ，返回数组中最大数和最小数的 最大公约数 。
 * 两个数的 最大公约数 是能够被两个数整除的最大正整数。
 * 示例 1：
 * 输入：nums = [2,5,6,9,10]
 * 输出：2
 * 解释：
 * nums 中最小的数是 2
 * nums 中最大的数是 10
 * 2 和 10 的最大公约数是 2
 * 示例 2：
 * 输入：nums = [7,5,6,8,3]
 * 输出：1
 * 解释：
 * nums 中最小的数是 3
 * nums 中最大的数是 8
 * 3 和 8 的最大公约数是 1
 * 示例 3：
 * 输入：nums = [3,3]
 * 输出：3
 * 解释：
 * nums 中最小的数是 3
 * nums 中最大的数是 3
 * 3 和 3 的最大公约数是 3
 *
 * @author Administrator
 * @date 2023-5-4 9:07
 */
public class FindGreatestCommonDivisorofArray {
    public static void main(String[] args) {

    }

    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int min = nums[0];
        return gcd(min, max);
    }

    private int gcd(int min, int max) {
        if (max == 0) {
            return min;
        }
        return gcd(max, min % max);
    }
}
