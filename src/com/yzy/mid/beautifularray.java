package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/09 22:16
 * @Description
 * 如果长度为 n 的数组 nums 满足下述条件，则认为该数组是一个 漂亮数组 ：
 *
 * nums 是由范围 [1, n] 的整数组成的一个排列。
 * 对于每个 0 <= i < j < n ，均不存在下标 k（i < k < j）使得 2 * nums[k] == nums[i] + nums[j] 。
 * 给你整数 n ，返回长度为 n 的任一 漂亮数组 。本题保证对于给定的 n 至少存在一个有效答案。
 *
 *
 *
 * 示例 1 ：
 *
 * 输入：n = 4
 * 输出：[2,1,4,3]
 * 示例 2 ：
 *
 * 输入：n = 5
 * 输出：[3,1,2,5,4]
 * @Version 1.0
 */
public class beautifularray {
    public int[] beautifulArray(int N) {
        if (N == 1) {
            return new int[]{1};
        }
        int[] odd = beautifulArray((N + 1) / 2);
        int[] even = beautifulArray(N / 2);
        int[] res = new int[N];
        for (int i = 0; i < odd.length; i++) {
            res[i] = odd[i] * 2 - 1;
        }
        for (int i = 0; i < even.length; i++) {
            res[i + odd.length] = even[i] * 2;
        }
        return res;
    }
}