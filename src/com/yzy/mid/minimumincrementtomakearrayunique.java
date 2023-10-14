package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/11 08:17
 * @Description
 * 给你一个整数数组 nums 。每次 move 操作将会选择任意一个满足 0 <= i < nums.length 的下标 i，并将 nums[i] 递增 1。
 *
 * 返回使 nums 中的每个值都变成唯一的所需要的最少操作次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 * 示例 2：
 *
 * 输入：nums = [3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 * @Version 1.0
 */
public class minimumincrementtomakearrayunique {
    public int minIncrementForUnique(int[] A) {
        if (A.length == 0) return 0;
        Arrays.sort(A);
        int N = A[0], cnt = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] <= N)
                cnt += N - A[i];
            else
                N = A[i];
            N++;
        }
        return cnt;
    }
}