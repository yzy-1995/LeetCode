package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: FindtheDifference
 * Description:
 * 给定两个字符串 s 和 t ，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 * @author Administrator
 * @date 2023-4-10 15:32
 */
public class FindtheDifference {
    public static void main(String[] args) {
        FindtheDifference findtheDifference = new FindtheDifference();
        System.out.println(findtheDifference.findTheDifference("abcd", "abcde"));
    }

    public char findTheDifference(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            cnt[ch - 'a']--;
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }
        return ' ';
    }
}
