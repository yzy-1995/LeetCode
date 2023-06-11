package com.yzy.mid;

/**
 * Description: leetcode209
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 * @author yzy15
 * @date 2023/06/10 23:32
 **/
public class MinimumSizeSubarraySum {
    // 滑动窗口
    public int minSubArrayLen(int target, int[] nums) {
        int slow = 0; // 滑动窗口起始位置
        int minLen = Integer.MAX_VALUE;
        int sum = 0; // 滑动窗口数值之和
        for (int fast = 0; fast < nums.length; fast++) {
            sum += nums[fast];
            // 注意这里使用while，每次更新 left（起始位置），并不断比较子序列是否符合条件
            while (sum >= target) {
                int len = fast - slow + 1; // 记录当前子序列长度
                minLen = minLen > len ? len : minLen;
                sum -= nums[slow++]; // 这里体现出滑动窗口的精髓之处，不断变更left（子序列的起始位置）
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
