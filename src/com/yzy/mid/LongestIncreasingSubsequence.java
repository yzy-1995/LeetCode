package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/06/22 12:41
 * @Description 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * @Version 1.0
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int left = 0;
            int right = res;
            while (left <= right) {
                int mid = left + right >> 1;
                if (num > nums[mid]) left = mid + 1;
                else right = mid - 1;
            }
            nums[left] = num;
            res = Math.max(res, left);
        }
        return res + 1;
    }
}