package com.yzy.simple;

import java.util.Arrays;

/**
 * ClassName: OfferII032
 * Description:
 * 给定两个字符串 s 和 t ，编写一个函数来判断它们是不是一组变位词（字母异位词）。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同且字符顺序不完全相同，则称 s 和 t 互为变位词（字母异位词）。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "a", t = "a"
 * 输出: false
 * @author Administrator
 * @date 2023-5-19 15:04
 */
public class OfferII032 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || s.equals(t))
            return false;
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++cnt[s.charAt(i) - 'a'];
            --cnt[t.charAt(i) - 'a'];
        }
        for (int c : cnt)
            if (c != 0)
                return false;
        return true;
    }
}
