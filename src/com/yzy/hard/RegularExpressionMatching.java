package com.yzy.hard;

/**
 * ClassName: RegularExpressionMatching
 * Description:
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * @author Administrator
 * @date 2023-3-28 14:35
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {

    }

    /**
     * 这是一个广为人知的正则表达式匹配问题，通常可以用动态规划来解决。
     *
     * 我们可以使用 dp[i][j] 表示 s 的前 i 个字符和 p 的前 j 个字符是否能够匹配。其中，s 的前 i 个字符指前 i 个字符，
     * p 的前 j 个字符指从第一个字符开始，到第 j 个字符为止（注意：不是前 j 个字符组成的子串）。
     *
     * 对于状态转移，如果 p[j] 是正常字符，那么只有 s[i] 和 p[j] 相等时，才有 dp[i][j] = dp[i-1][j-1]；如果 p[j] 是 '.'，
     * 那么可以匹配任何字符，所以也有 dp[i][j] = dp[i-1][j-1]；如果 p[j] 是 '*'，那么需要考虑两种情况：
     *
     * 由于 '' 可以匹配零个或多个前面的字符，所以可以将 dp[i][j] 看作是 dp[i][j-2] 的延续，即不考虑 '' 的情况；
     * 如果 s[i] 与 p[j-1] 匹配成功，那么可以把 s 的前 i-1 个字符和 p 的前 j 个字符当作一个整体，即 dp[i][j] = dp[i-1][j]。
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-2];
                    if (matches(s, p, i, j-1)) {
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    private boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j-1) == '.') {
            return true;
        }
        return s.charAt(i-1) == p.charAt(j-1);
    }
}
