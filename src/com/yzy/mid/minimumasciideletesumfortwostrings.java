package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/31 00:06
 * @Description
 * 给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s1 = "sea", s2 = "eat"
 * 输出: 231
 * 解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
 * 在 "eat" 中删除 "t" 并将 116 加入总和。
 * 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
 * 示例 2:
 *
 * 输入: s1 = "delete", s2 = "leet"
 * 输出: 403
 * 解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
 * 将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
 * 结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
 * 如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
 * @Version 1.0
 */
public class minimumasciideletesumfortwostrings {
    public int minimumDeleteSum(String s1, String s2) {
        int M = s1.length();
        int N = s2.length();
        int total_sum = 0;
        for (int i = 0; i < M; ++i) {
            total_sum += s1.charAt(i);
        }
        for (int j = 0; j < N; ++j) {
            total_sum += s2.charAt(j);
        }
        if (M == 0 || N == 0) {
            return total_sum;
        }

        int[][] common_sum = new int[M + 1][N + 1];
        for (int i = 0; i < M + 1; ++i) {
            Arrays.fill(common_sum[i], 0);
        }

        int max_common_sum = 0;
        for (int i = 1; i <= M; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    common_sum[i][j] = common_sum[i-1][j-1] + s1.charAt(i - 1);
                } else {
                    common_sum[i][j] = Math.max(common_sum[i-1][j], common_sum[i][j-1]);
                }
                max_common_sum = Math.max(max_common_sum, common_sum[i][j]);
            }
        }
        return total_sum - 2*max_common_sum;
    }
}