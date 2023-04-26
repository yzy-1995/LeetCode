package com.yzy.simple;

/**
 * ClassName: GreatestCommonDivisorofStrings
 * Description:
 * 对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
 *
 * 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 X 能除尽 str2 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例 2：
 *
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例 3：
 *
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 * @author Administrator
 * @date 2023-4-26 9:51
 */
public class GreatestCommonDivisorofStrings {
    public static void main(String[] args) {

    }

    /**
     * 首先检查 str1 + str2 是否等于 str2 + str1，因为只有在这种情况下，两个字符串才可能有一个公共的除数。
     * 然后通过计算两个字符串长度的最大公约数，并返回 str1 的前缀子串（长度为最大公约数），找到满足条件的最长字符串。
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
