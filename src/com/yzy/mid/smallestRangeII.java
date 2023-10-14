package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/06 03:55
 * @Description
 * 给你一个整数数组 nums，和一个整数 k 。
 *
 * 对于每个下标 i（0 <= i < nums.length），将 nums[i] 变成 nums[i] + k 或 nums[i] - k 。
 *
 * nums 的 分数 是 nums 中最大元素和最小元素的差值。
 *
 * 在更改每个下标对应的值之后，返回 nums 的最小 分数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1], k = 0
 * 输出：0
 * 解释：分数 = max(nums) - min(nums) = 1 - 1 = 0 。
 * 示例 2：
 *
 * 输入：nums = [0,10], k = 2
 * 输出：6
 * 解释：将数组变为 [2, 8] 。分数 = max(nums) - min(nums) = 8 - 2 = 6 。
 * 示例 3：
 *
 * 输入：nums = [1,3,6], k = 3
 * 输出：3
 * 解释：将数组变为 [4, 6, 3] 。分数 = max(nums) - min(nums) = 6 - 3 = 3 。
 * @Version 1.0
 */
public class smallestRangeII {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int n = A.length;
        int res = A[n-1] - A[0];
        for (int i=1;i<n;i++) {
            int min = Math.min(A[0]+K,A[i]-K);
            int max = Math.max(A[n-1]-K,A[i-1]+K);
            res = Math.min(max-min,res);
        }
        return res;
    }
}