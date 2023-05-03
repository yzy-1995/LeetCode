package com.yzy.simple;

/**
 * Description: leetcode1832
 * 全字母句 指包含英语字母表中每个字母至少一次的句子。
 * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
 * 如果是，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
 * 输出：true
 * 解释：sentence 包含英语字母表中每个字母至少一次。
 * 示例 2：
 * 输入：sentence = "leetcode"
 * 输出：false
 *
 * @author yzy15
 * @date 2023/05/02 12:13
 **/
public class CheckiftheSentenceIsPangram {
    public static void main(String[] args) {

    }

    public boolean checkIfPangram(String sentence) {
        int[] hash = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            hash[sentence.charAt(i) - 'a'] = 1;
        }
        for (int i = 0; i < 26; i++) {
            if (hash[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
