package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/27 00:02
 * @Description
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 *
 * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
 *
 *
 *
 * 示例 1：
 *
 * 输入：a = "abcd", b = "cdabcdab"
 * 输出：3
 * 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
 * 示例 2：
 *
 * 输入：a = "a", b = "aa"
 * 输出：2
 * 示例 3：
 *
 * 输入：a = "a", b = "a"
 * 输出：1
 * 示例 4：
 *
 * 输入：a = "abc", b = "wxyz"
 * 输出：-1
 * @Version 1.0
 */
public class repeatedstringmatch {
    public int repeatedStringMatch(String a, String b) {
        int na = a.length(), nb = b.length(), beg = -1, ia = 0;
        char[] ca = (a + a).toCharArray(), cb = b.toCharArray();
        for (int i = 0; i < na; i++) {
            boolean flag = true;
            for (int j = 0; j < Math.min((na << 1) - i, nb); j++) {
                if (ca[i + j] != cb[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                beg = na - i;
                break;
            }
        }
        if (beg == -1) return -1;
        for (int i = beg; i < nb; i++) {
            if (cb[i] != ca[ia++ % na]) {
                return -1;
            }
        }
        return ia == 0 ? 1 : (ia - 1) / na + 2;
    }
}