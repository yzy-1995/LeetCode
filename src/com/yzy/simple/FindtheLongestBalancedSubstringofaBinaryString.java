package com.yzy.simple;

/**
 * ClassName: FindtheLongestBalancedSubstringofaBinaryString
 * Description:
 * 给你一个仅由 0 和 1 组成的二进制字符串 s 。
 * 如果子字符串中 所有的 0 都在 1 之前 且其中 0 的数量等于 1 的数量，则认为 s 的这个子字符串是平衡子字符串。请注意，空子字符串也视作平衡子字符串。
 * 返回  s 中最长的平衡子字符串长度。
 * 子字符串是字符串中的一个连续字符序列。
 * 示例 1：
 * 输入：s = "01000111"
 * 输出：6
 * 解释：最长的平衡子字符串是 "000111" ，长度为 6 。
 * 示例 2：
 * 输入：s = "00111"
 * 输出：4
 * 解释：最长的平衡子字符串是 "0011" ，长度为  4 。
 * 示例 3：
 * 输入：s = "111"
 * 输出：0
 * 解释：除了空子字符串之外不存在其他平衡子字符串，所以答案为 0 。
 *
 * @author Administrator
 * @date 2023-5-11 17:27
 */
public class FindtheLongestBalancedSubstringofaBinaryString {
    public static void main(String[] args) {

    }

    public int findTheLongestBalancedSubstring(String s) {
        int[][] dp = new int[s.length() + 1][2];

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int type = s.charAt(i) - '0';
            dp[i + 1][type] = dp[i][type] + 1;
            if (type == 1 && i + 1 - dp[i + 1][type] > 0) {
                result = Math.max(result, Math.min(dp[i + 1][type], dp[i + 1 - dp[i + 1][type]][1 - type]) * 2);
            }
        }
        return result;
    }
}
