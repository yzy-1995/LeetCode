package com.yzy.simple;

/**
 * Description: leetcode1662
 * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 *
 * 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
 * 输出：true
 * 解释：
 * word1 表示的字符串为 "ab" + "c" -> "abc"
 * word2 表示的字符串为 "a" + "bc" -> "abc"
 * 两个字符串相同，返回 true
 * 示例 2：
 *
 * 输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
 * 输出：false
 * 示例 3：
 *
 * 输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * 输出：true
 * @author yzy15
 * @date 2023/05/01 13:31
 **/
public class CheckIfTwoStringArraysareEquivalent {
    public static void main(String[] args) {

    }


    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 =new StringBuilder();
        StringBuilder s2 =new StringBuilder();
        for (String s :word1) {
            s1.append(s);
        }
        for (String s :word2) {
            s2.append(s);
        }
    return s1.toString().equals(s2.toString());
    }
}
