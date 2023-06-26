package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/06/25 22:07
 * @Description 给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，并且这两个单词不含有公共字母。如果不存在这样的两个单词，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出：16
 * 解释：这两个单词为 "abcw", "xtfn"。
 * 示例 2：
 * <p>
 * 输入：words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出：4
 * 解释：这两个单词为 "ab", "cd"。
 * 示例 3：
 * <p>
 * 输入：words = ["a","aa","aaa","aaaa"]
 * 输出：0
 * 解释：不存在这样的两个单词。
 * @Version 1.0
 */
public class MaximumProductofWordLengths {

    public int maxProduct(String[] words) {
        int n = words.length;
        int[] hash = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                hash[i] |= 1 << (c - '0');
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((hash[i] & hash[j]) == 0) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }
        return max;
    }
}