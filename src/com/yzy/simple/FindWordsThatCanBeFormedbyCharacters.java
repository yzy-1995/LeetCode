package com.yzy.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: FindWordsThatCanBeFormedbyCharacters
 * Description:
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *
 * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
 *
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 * 示例 1：
 *
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 *
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 * @author Administrator
 * @date 2023-4-26 14:31
 */
public class FindWordsThatCanBeFormedbyCharacters {
    public static void main(String[] args) {

    }

    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : chars.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int lengthSum = 0;
        for (String word : words) {
            Map<Character, Integer> tempCount = new HashMap<>(charCount);
            boolean canForm = true;
            for (char c : word.toCharArray()) {
                if (tempCount.getOrDefault(c, 0) > 0) {
                    tempCount.put(c, tempCount.get(c) - 1);
                } else {
                    canForm = false;
                    break;
                }
            }
            if (canForm) {
                lengthSum += word.length();
            }
        }

        return lengthSum;
    }
}
