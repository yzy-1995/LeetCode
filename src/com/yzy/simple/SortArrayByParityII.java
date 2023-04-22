package com.yzy.simple;

/**
 * Description: leetcode922
 * 给定一个非负整数数组 nums，  nums 中一半整数是 奇数 ，一半整数是 偶数 。
 * 对数组进行排序，以便当 nums[i] 为奇数时，i 也是 奇数 ；当 nums[i] 为偶数时， i 也是 偶数 。
 * 你可以返回 任何满足上述条件的数组作为答案 。
 * 示例 1：
 * 输入：nums = [4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * 示例 2：
 * 输入：nums = [2,3]
 * 输出：[2,3]
 * @author yzy15
 * @date 2023/04/22 12:59
 **/
public class SortArrayByParityII {
    public static void main(String[] args) {

    }

    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int evenIdx = 0;
        int oddIdx = 1;

        for (int num : nums) {
            if (num % 2 == 0) {
                result[evenIdx] = num;
                evenIdx += 2;
            } else {
                result[oddIdx] = num;
                oddIdx += 2;
            }
        }

        return result;
    }
}
