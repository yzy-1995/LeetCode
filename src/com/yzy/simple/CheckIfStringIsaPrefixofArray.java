package com.yzy.simple;

/**
 * Description: leetcode1961
 * 给你一个字符串 s 和一个字符串数组 words ，请你判断 s 是否为 words 的 前缀字符串 。
 * 字符串 s 要成为 words 的 前缀字符串 ，需要满足：s 可以由 words 中的前 k（k 为 正数 ）个字符串按顺序相连得到，且 k 不超过 words.length 。
 * 如果 s 是 words 的 前缀字符串 ，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：s = "iloveleetcode", words = ["i","love","leetcode","apples"]
 * 输出：true
 * 解释：
 * s 可以由 "i"、"love" 和 "leetcode" 相连得到。
 * 示例 2：
 * 输入：s = "iloveleetcode", words = ["apples","i","love","leetcode"]
 * 输出：false
 * 解释：
 * 数组的前缀相连无法得到 s 。
 *
 * @author yzy15
 * @date 2023/05/03 22:22
 **/
public class CheckIfStringIsaPrefixofArray {
    public static void main(String[] args) {

    }


    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            sb.append(word);

            if (sb.length() == s.length()) {
                return sb.toString().equals(s);
            } else if (sb.length() > s.length()) {
                return false;
            }
        }
        return false;
    }
}
