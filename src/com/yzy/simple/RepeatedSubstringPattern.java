package com.yzy.simple;

/**
 * ClassName: RepeatedSubstringPattern
 * Description:
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * 示例 1:
 *
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: s = "aba"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 * @author Administrator
 * @date 2023-4-12 8:57
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {

    }

    /**
     * 将原字符串 s 与自身拼接，形成一个新的字符串 ss = s + s。这样一来，原字符串 s 可以看作是新字符串 ss 的一个子串。
     * 去掉新字符串 ss 的第一个和最后一个字符，得到一个新的字符串 ss_trim。
     * 在 ss_trim 中查找原字符串 s。如果可以找到，说明原字符串 s 可以由一个子串重复多次构成；否则，说明原字符串 s 不能由一个子串重复多次构成。
     * 这个方法的时间复杂度为 O(n)，其中 n 是字符串的长度。这是因为字符串拼接的时间复杂度为 O(n)，而字符串查找的时间复杂度也为 O(n)。
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern(String s) {
        String ss = s + s;
        String ss_trim = ss.substring(1, ss.length() - 1);
        return ss_trim.contains(s);
    }
}
