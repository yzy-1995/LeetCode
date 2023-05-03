package com.yzy.simple;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Description: leetcode1897
 * 给你一个字符串数组 words（下标 从 0 开始 计数）。
 * 在一步操作中，需先选出两个 不同 下标 i 和 j，其中 words[i] 是一个非空字符串，接着将 words[i] 中的 任一 字符移动到 words[j] 中的 任一 位置上。
 * 如果执行任意步操作可以使 words 中的每个字符串都相等，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：words = ["abc","aabc","bc"]
 * 输出：true
 * 解释：将 words[1] 中的第一个 'a' 移动到 words[2] 的最前面。
 * 使 words[1] = "abc" 且 words[2] = "abc" 。
 * 所有字符串都等于 "abc" ，所以返回 true 。
 * 示例 2：
 * 输入：words = ["ab","a"]
 * 输出：false
 * 解释：执行操作无法使所有字符串都相等。
 *
 * @author yzy15
 * @date 2023/05/03 11:25
 **/
public class RedistributeCharacterstoMakeAllStringsEqual {
    public static void main(String[] args) {

    }

    public boolean makeEqual(String[] words) {
        int[] charCount = new int[26];
        int n = words.length;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                charCount[c - 'a']++;
            }

        }
        for (int count : charCount) {
            if (count % n != 0) {
                return false;
            }
        }

        return true;
    }
}
