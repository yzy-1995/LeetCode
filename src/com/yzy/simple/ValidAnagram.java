package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ValidAnagram
 * Description:
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * @author Administrator
 * @date 2023-3-29 14:36
 */
public class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("rat", "car"));

    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        List<Character> a = new ArrayList<>();
        List<Character> b = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            a.add(s.charAt(i));
            b.add(t.charAt(i));
        }
        for (Character character : a) {
            if (b.contains(character)) {
                b.remove(character);
            }
        }
        if (b.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAnagram2(String s, String t){
        int[] record = new int[26];
        for (char c : s.toCharArray()) {
            record[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            record[c - 'a'] -= 1;
        }
        for (int i : record) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
