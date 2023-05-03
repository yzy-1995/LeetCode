package com.yzy.simple;

import java.util.Arrays;

/**
 * Description: leetcode1624
 * 给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
 * 子字符串 是字符串中的一个连续字符序列。
 * 示例 1：
 * 输入：s = "aa"
 * 输出：0
 * 解释：最优的子字符串是两个 'a' 之间的空子字符串。
 * 示例 2：
 * 输入：s = "abca"
 * 输出：2
 * 解释：最优的子字符串是 "bc" 。
 * 示例 3：
 * 输入：s = "cbzxy"
 * 输出：-1
 * 解释：s 中不存在出现出现两次的字符，所以返回 -1 。
 * 示例 4：
 * 输入：s = "cabbac"
 * 输出：4
 * 解释：最优的子字符串是 "abba" ，其他的非最优解包括 "bb" 和 "" 。
 *
 * @author yzy15
 * @date 2023/04/30 22:58
 **/
public class LargestSubstringBetweenTwoEqualCharacters {
    public static void main(String[] args) {

    }

    public int maxLengthBetweenEqualCharacters(String s) {
        int maxLength = -1;
        int[] firstOccurrences = new int[26];

        Arrays.fill(firstOccurrences, -1);

        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'a';
            if (firstOccurrences[charIndex] == -1) {
                firstOccurrences[charIndex] = i;
            } else {
                maxLength = Math.max(maxLength, i - firstOccurrences[charIndex] - 1);
            }
        }

        return maxLength;
    }
}
