package com.yzy.mid;

/**
 * ClassName: MaximumProductSubarray
 * Description:
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 测试用例的答案是一个 32-位 整数。
 * <p>
 * 子数组 是数组的连续子序列。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * @author Administrator
 * @date 2023-6-6 15:20
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int res = nums[0];
        int n = nums.length;
        if (n == 1) return nums[0];
        int temp1 = nums[0];
        int temp2 = nums[0];
        for (int i = 1; i < n; i++) {
            int a = Math.max(Math.max(temp1 * nums[i], temp2 * nums[i]), nums[i]);
            int b = Math.min(Math.min(temp1 * nums[i], temp2 * nums[i]), nums[i]);
            temp1 = a;
            temp2 = b;
            res = Math.max(res, a);
        }
        return res;
    }
}
