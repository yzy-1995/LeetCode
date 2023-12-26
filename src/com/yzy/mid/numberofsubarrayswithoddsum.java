package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/27 00:03
 * @Description
 * 给你一个整数数组 arr 。请你返回和为 奇数 的子数组数目。
 *
 * 由于答案可能会很大，请你将结果对 10^9 + 7 取余后返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,3,5]
 * 输出：4
 * 解释：所有的子数组为 [[1],[1,3],[1,3,5],[3],[3,5],[5]] 。
 * 所有子数组的和为 [1,4,9,3,8,5].
 * 奇数和包括 [1,9,3,5] ，所以答案为 4 。
 * 示例 2 ：
 *
 * 输入：arr = [2,4,6]
 * 输出：0
 * 解释：所有子数组为 [[2],[2,4],[2,4,6],[4],[4,6],[6]] 。
 * 所有子数组和为 [2,6,12,4,10,6] 。
 * 所有子数组和都是偶数，所以答案为 0 。
 * 示例 3：
 *
 * 输入：arr = [1,2,3,4,5,6,7]
 * 输出：16
 * 示例 4：
 *
 * 输入：arr = [100,100,99,99]
 * 输出：4
 * 示例 5：
 *
 * 输入：arr = [7]
 * 输出：1
 * @Version 1.0
 */
public class numberofsubarrayswithoddsum {
    public int numOfSubarrays(int[] arr) {
        int mod = 1000000007;
        // dp[i]表示右边界为dp[i]的子数组中奇数和的数量
        int[] odd = new int[arr.length];
        int[] even = new int[arr.length];
        odd[0] = (arr[0] & 1) == 1 ? 1 : 0;
        even[0] = (arr[0] & 1) == 0 ? 1 : 0;
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] & 1) == 1) {
                // 奇
                // 单个数
                odd[i]++;
                odd[i] += even[i - 1];
                even[i] += odd[i - 1];
            } else {
                // 偶
                even[i]++;
                odd[i] += odd[i - 1];
                even[i] += even[i - 1];
            }
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count = (count + odd[i]) % mod;
        }
        return count;
    }
}