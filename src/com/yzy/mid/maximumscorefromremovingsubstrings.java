package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/23 00:04
 * @Description
 * 给你一个字符串 s 和两个整数 x 和 y 。你可以执行下面两种操作任意次。
 *
 * 删除子字符串 "ab" 并得到 x 分。
 * 比方说，从 "cabxbae" 删除 ab ，得到 "cxbae" 。
 * 删除子字符串"ba" 并得到 y 分。
 * 比方说，从 "cabxbae" 删除 ba ，得到 "cabxe" 。
 * 请返回对 s 字符串执行上面操作若干次能得到的最大得分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "cdbcbbaaabab", x = 4, y = 5
 * 输出：19
 * 解释：
 * - 删除 "cdbcbbaaabab" 中加粗的 "ba" ，得到 s = "cdbcbbaaab" ，加 5 分。
 * - 删除 "cdbcbbaaab" 中加粗的 "ab" ，得到 s = "cdbcbbaa" ，加 4 分。
 * - 删除 "cdbcbbaa" 中加粗的 "ba" ，得到 s = "cdbcba" ，加 5 分。
 * - 删除 "cdbcba" 中加粗的 "ba" ，得到 s = "cdbc" ，加 5 分。
 * 总得分为 5 + 4 + 5 + 5 = 19 。
 * 示例 2：
 *
 * 输入：s = "aabbaaxybbaabb", x = 5, y = 4
 * 输出：20
 * @Version 1.0
 */
public class maximumscorefromremovingsubstrings {
    public int maximumGain(String s, int x, int y) {
        int n = s.length();
        int left = 0, right = 0;
        int ans = 0;
        while (left < n) {
            while (left < n && s.charAt(left) != 'a' && s.charAt(left) != 'b') left++;
            if (left >= n) break;
            right = left;
            while (right + 1 < n && (s.charAt(right + 1) == 'a' || s.charAt(right + 1) == 'b')) right++;
            int ca = 0, cb = 0;
            for (int k = left; k <= right; k++) {
                char c = s.charAt(k);
                if (x > y) { // prefer to ab
                    if (c == 'b') {
                        if (ca > 0) {
                            ca--;
                            ans += x;
                        } else {
                            cb++;
                        }
                    } else {
                        ca++;
                    }
                } else { // prefer to ba
                    if (c == 'a') {
                        if (cb > 0) {
                            cb--;
                            ans += y;
                        } else {
                            ca++;
                        }
                    } else {
                        cb++;
                    }
                }
            }
            ans = ans + Math.min(ca, cb) * Math.min(x, y);
            left = right + 1;
        }
        return ans;
    }
}