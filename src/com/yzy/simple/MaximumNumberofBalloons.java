package com.yzy.simple;

/**
 * Description: leetcode1189
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 *
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：text = "nlaebolko"
 * 输出：1
 * 示例 2：
 *
 *
 *
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 * 示例 3：
 *
 * 输入：text = "leetcode"
 * 输出：0
 * @author yzy15
 * @date 2023/04/26 21:33
 **/
public class MaximumNumberofBalloons {
    public static void main(String[] args) {

    }

    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];

        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }

        count['l' - 'a'] /= 2;
        count['o' - 'a'] /= 2;

        int minCount = Integer.MAX_VALUE;
        for (char c : "balon".toCharArray()) {
            minCount = Math.min(minCount, count[c - 'a']);
        }

        return minCount;

    }
}
