package com.yzy.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/13 00:04
 * @Description
 * 给定字符串 s 和字符串数组 words, 返回  words[i] 中是s的子序列的单词个数 。
 *
 * 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
 *
 * 例如， “ace” 是 “abcde” 的子序列。
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcde", words = ["a","bb","acd","ace"]
 * 输出: 3
 * 解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
 * Example 2:
 *
 * 输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * 输出: 2
 * @Version 1.0
 */
public class numberofmatchingsubsequences {
    public int numMatchingSubseq(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int res = 0;
        for (String word : words) {
            if (map.get(word) != null && isMatch(s, word)) {
                res += map.get(word);
            }
            map.remove(word);
        }
        return res;
    }

    private boolean isMatch(String s, String t) {
        int m = s.length();
        int n = t.length();
        int j = 0;
        for (int i = 0; i < m && j < n; i++) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
        }
        return j == n;
    }
}