package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/19 00:17
 * @Description
 * 给你一个由 n 个数对组成的数对数组 pairs ，其中 pairs[i] = [lefti, righti] 且 lefti < righti 。
 *
 * 现在，我们定义一种 跟随 关系，当且仅当 b < c 时，数对 p2 = [c, d] 才可以跟在 p1 = [a, b] 后面。我们用这种形式来构造 数对链 。
 *
 * 找出并返回能够形成的 最长数对链的长度 。
 *
 * 你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 *
 *
 *
 * 示例 1：
 *
 * 输入：pairs = [[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4] 。
 * 示例 2：
 *
 * 输入：pairs = [[1,2],[7,8],[4,5]]
 * 输出：3
 * 解释：最长的数对链是 [1,2] -> [4,5] -> [7,8] 。
 * @Version 1.0
 */
public class maximumlengthofpairchain {
    public int findLongestChain(int[][] pairs) {
        int[] dp = new int[pairs.length];
        Arrays.sort(pairs, (a, b) -> {
            return a[1] - b[1];
        });
        int sum = 1;
        int pre = 0;
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[pre][1] < pairs[i][0]) {
                sum++;
                pre = i;
            }
        }
        return sum;
    }
}