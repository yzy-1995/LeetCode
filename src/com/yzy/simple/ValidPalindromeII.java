package com.yzy.simple;

/**
 * ClassName: ValidPalindromeII
 * Description:leetcode680
 * 给你一个字符串 s，最多 可以从中删除一个字符。
 * 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：s = "aba"
 * 输出：true
 * 示例 2：
 * 输入：s = "abca"
 * 输出：true
 * 解释：你可以删除字符 'c' 。
 * 示例 3：
 * 输入：s = "abc"
 * 输出：false
 *
 * @author Administrator
 * @date 2023-4-17 16:16
 */
public class ValidPalindromeII {
    public static void main(String[] args) {
        System.out.println(new ValidPalindromeII().validPalindrome("abica"));
    }
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
