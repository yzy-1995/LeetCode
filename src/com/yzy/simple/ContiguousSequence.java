package com.yzy.simple;

/**
 * Description: l
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 * <p>
 * 示例：
 * <p>
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶：
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * @author yzy15
 * @date 2023/05/20 16:27
 **/
public class ContiguousSequence {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, i = 0, sum = 0;
        while (i < nums.length) {
            if (sum + nums[i] < nums[i]) {
                sum = 0;
            }
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            i++;
        }
        return max;
    }
}
