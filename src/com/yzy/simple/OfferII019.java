package com.yzy.simple;

/**
 * ClassName: OfferII019
 * Description:
 * 给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。
 * 示例 1:
 *
 * 输入: s = "aba"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "abca"
 * 输出: true
 * 解释: 可以删除 "c" 字符 或者 "b" 字符
 * 示例 3:
 *
 * 输入: s = "abc"
 * 输出: false
 * @author Administrator
 * @date 2023-5-19 14:20
 */
public class OfferII019 {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int l = 0;
        int r = n - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return valid(s,l + 1,r) || valid(s,l,r - 1);
            }
        }
        return true;
    }
    public boolean valid(String s,int l,int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
