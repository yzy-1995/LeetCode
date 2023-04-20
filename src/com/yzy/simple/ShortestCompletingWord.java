package com.yzy.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: ShortestCompletingWord
 * Description:leetcode748
 * 给你一个字符串 licensePlate 和一个字符串数组 words ，请你找出 words 中的 最短补全词 。
 * 补全词 是一个包含 licensePlate 中所有字母的单词。忽略 licensePlate 中的 数字和空格 。
 * 不区分大小写。如果某个字母在 licensePlate 中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
 * 例如：licensePlate = "aBc 12c"，那么它的补全词应当包含字母 'a'、'b' （忽略大写）和两个 'c' 。可能的 补全词 有 "abccdef"、"caaacab" 以及 "cbca" 。
 * 请返回 words 中的 最短补全词 。题目数据保证一定存在一个最短补全词。当有多个单词都符合最短补全词的匹配条件时取 words 中 第一个 出现的那个。
 * 示例 1：
 * 输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * 输出："steps"
 * 解释：最短补全词应该包括 "s"、"p"、"s"（忽略大小写） 以及 "t"。
 * "step" 包含 "t"、"p"，但只包含一个 "s"，所以它不符合条件。
 * "steps" 包含 "t"、"p" 和两个 "s"。
 * "stripe" 缺一个 "s"。
 * "stepple" 缺一个 "s"。
 * 因此，"steps" 是唯一一个包含所有字母的单词，也是本例的答案。
 * 示例 2：
 * 输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * 输出："pest"
 * 解释：licensePlate 只包含字母 "s" 。所有的单词都包含字母 "s" ，其中 "pest"、"stew"、和 "show" 三者最短。
 * 答案是 "pest" ，因为它是三个单词中在 words 里最靠前的那个。
 * @author Administrator
 * @date 2023-4-20 9:22
 */
public class ShortestCompletingWord {
    public static void main(String[] args) {

    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        String result = "";
        Map<Character, Integer> licenseMap = new HashMap<>();
        licensePlate = licensePlate.toLowerCase();

        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                licenseMap.put(c, licenseMap.getOrDefault(c, 0) + 1);
            }
        }

        int minLength = Integer.MAX_VALUE;
        for (String word : words) {
            if (isCompletingWord(word, new HashMap<>(licenseMap))) {
                if (word.length() < minLength) {
                    minLength = word.length();
                    result = word;
                }
            }
        }

        return result;
    }

    private boolean isCompletingWord(String word, Map<Character, Integer> licenseMap) {
        for (char c : word.toCharArray()) {
            if (licenseMap.containsKey(c)) {
                licenseMap.put(c, licenseMap.get(c) - 1);
                if (licenseMap.get(c) == 0) {
                    licenseMap.remove(c);
                }
            }
        }
        return licenseMap.isEmpty();

    }
}
