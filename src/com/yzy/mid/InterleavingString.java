package com.yzy.mid;

/**
 * ClassName: InterleavingString
 * Description:
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * <p>
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * <p>
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 注意：a + b 意味着字符串 a 和 b 连接。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：s1 = "", s2 = "", s3 = ""
 * 输出：true
 *
 * @author Administrator
 * @date 2023-5-26 10:38
 */
public class InterleavingString {
    /**
     * 定义一个二维布尔数组 dp，其中 dp[i][j] 表示 s1 的前 i 个字符和 s2 的前 j 个字符是否可以交错组成 s3 的前 i+j 个字符。根据交错字符串的定义，我们可以得到如下状态转移方程：
     * dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1))
     * 其中，dp[i-1][j] 表示 s1 的前 i-1 个字符和 s2 的前 j 个字符可以交错组成 s3 的前 i+j-1 个字符，因此我们需要判断 s1 的第 i 个字符是否等于 s3 的第 i+j-1 个字符；
     * 同理，dp[i][j-1] 表示 s1 的前 i 个字符和 s2 的前 j-1 个字符可以交错组成 s3 的前 i+j-1 个字符，因此我们需要判断 s2 的第 j 个字符是否等于 s3 的第 i+j-1 个字符。
     * 需要注意的是，我们需要先判断 s1 和 s2 的长度之和是否等于 s3 的长度，如果不等于，则 s3 一定不能由 s1 和 s2 交错组成。
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int p = i + j - 1;
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return dp[m][n];
    }
}
