package com.yzy.simple;

import java.util.*;

/**
 * ClassName: WordPattern
 * Description:
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 *
 * @author Administrator
 * @date 2023-3-30 13:41
 */
public class WordPattern {
    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern("abba", "dog cat cat dog"));
    }

    public boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c : chars) {
            list.add(c);
        }

        Map<Character, String> map = new HashMap<Character, String>();
        Map<String, Character> strMap = new HashMap<>();
        List<String> strList = new ArrayList<>();
        String[] s1 = s.split(" ");
        for (String o : s1) {
            strList.add(o);
        }
        if (pattern.length() != strList.size()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(list.get(i)) && !strMap.containsKey(strList.get(i))) {
                map.put(list.get(i), strList.get(i));
                strMap.put(strList.get(i), list.get(i));
            } else if (map.containsKey(list.get(i)) && strMap.containsKey(strList.get(i))) {
                if (!map.get(list.get(i)).equals(strList.get(i)) || strMap.get(strList.get(i)) != list.get(i)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
