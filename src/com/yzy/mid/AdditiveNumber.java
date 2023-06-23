package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/06/23 16:58
 * @Description 累加数 是一个字符串，组成它的数字可以形成累加序列。
 * <p>
 * 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，序列中的每个后续数字必须是它之前两个数字之和。
 * <p>
 * 给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 说明：累加序列里的数，除数字 0 之外，不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："112358"
 * 输出：true
 * 解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 示例 2：
 * <p>
 * 输入："199100199"
 * 输出：true
 * 解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 * @Version 1.0
 */
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i < n; i++) {
            long k = 0;
            for (int j = 0; j < i; j++) {
                k = k * 10 + (num.charAt(j) - '0');
                long l = 0;
                if (j > 0 && num.charAt(0) == '0') break;
                if (i - j - 1 > 0 && num.charAt(j + 1) == '0') continue;
                for (int m = j+1; m <= i; m++) {
                    l = l * 10 + (num.charAt(m) - '0');
                }
                if (backTrack(num, k, l, i + 1)) return true;
            }
        }
        return false;
    }

    private boolean backTrack(String num, long k, long l, int i) {
        long n = 0;
        for (int j = i; j < num.length(); j++) {
            n = n * 10 + (num.charAt(j) - '0');
            if (k + l == n) {
                if ((j == num.length() - 1) || backTrack(num, l, n, j + 1)) return true;
            }
            if (num.charAt(i) == '0' || n >= k + l) break;
        }
        return false;
    }
}