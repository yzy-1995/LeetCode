package com.yzy.mid;

import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/03 00:36
 * @Description
 * 给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 *
 * 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * 示例 2：
 *
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 * @Version 1.0
 */
public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        d.sort((a1, a2) -> {
            if (a1.length() != a2.length()) {
                return a2.length() - a1.length();
            }
            return a1.compareTo(a2);
        });
        for (String str : d) {
            int i = 0, j = 0;
            while (i < s.length() && j < str.length()){
                if(s.charAt(i) == str.charAt(j)){
                    j ++;
                }
                i ++;
            }
            if(j == str.length()){
                return str;
            }
        }
        return "";
    }
}