package com.yzy.simple;

/**
 * Description: leetcode1863
 *
 * @author yzy15
 * @date 2023/05/02 13:49
 **/
public class SumofAllSubsetXORTotals {
    public static void main(String[] args) {

    }


    public int subsetXORSum(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += subsetXORSum(nums, i + 1, nums[i]);
        }
        return result;
    }

    private int subsetXORSum(int[] nums, int index, int sum) {
        if (index == nums.length) {
            return sum;
        }
        return subsetXORSum(nums, index + 1, sum) + subsetXORSum(nums, index + 1, sum ^ nums[index]);
    }
}
