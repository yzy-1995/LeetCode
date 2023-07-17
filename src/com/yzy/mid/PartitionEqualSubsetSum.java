package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/15 19:58
 * @Description
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * @Version 1.0
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if(sum % 2 != 0) return false;
        int W = sum / 2;
        int [] dp = new int[W+1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = W; i >= num; i--) {
                dp[i] += dp[i-num];
            }
        }
        return dp[W] != 0;
    }
}