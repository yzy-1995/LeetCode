package com.yzy.mid;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/01 23:04
 * @Description
 * 给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。
 *
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：words = ["w","wo","wor","worl", "world"]
 * 输出："world"
 * 解释： 单词"world"可由"w", "wo", "wor", 和 "worl"逐步添加一个字母组成。
 * 示例 2：
 *
 * 输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出："apple"
 * 解释："apply" 和 "apple" 都能由词典中的单词组成。但是 "apple" 的字典序小于 "apply"
 * @Version 1.0
 */
public class longestwordindictionary {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String res = "";
        for (String s : words) {
            //如果单词只有一个字母，那一定是共有的
            if (s.length() == 1 || set.contains(s.substring(0, s.length() - 1))) {
                res = s.length() > res.length() ? s : res;
                set.add(s);
            }
        }
        return res;
    }
}