package com.yzy.simple;

/**
 * ClassName: OfferII018
 * Description:
 * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
 * 本题中，将空字符串定义为有效的 回文串 。
 * 示例 1:
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 * <p>
 * 输入: s = "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 *
 * @author Administrator
 * @date 2023-5-19 14:10
 */
public class OfferII018 {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        char[] arr = s.toCharArray();
        while (l < r) {
            while (l < r && !isValid(arr[l])) l++;
            while (l < r && !isValid(arr[r])) r--;
            if (arr[l] != arr[r] && arr[l] != (arr[r] ^ 32)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isValid(char x) {
        int val = x - '0';
        if (val <= 9 && val >= 0) return true; // 是数字
        val = x - 'a';
        if (val <= 25 && val >= 0) return true; // 是小写字母
        val = x - 'A';
        if (val <= 25 && val >= 0) return true; // 是大写字母
        return false;
    }
}
