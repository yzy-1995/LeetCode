package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/11 00:03
 * @Description 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 * <p>
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 * @Version 1.0
 */
public class PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        // 异位词
        int[] word = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            word[c - 'a']++;
        }

        // 滑动窗口
        for (int i = 0, j = 0; i < s2.length(); i++) {
            // 消耗
            word[s2.charAt(i) - 'a']--;

            // 补充
            while (word[s2.charAt(i) - 'a'] < 0) {
                word[s2.charAt(j) - 'a']++;
                j++;
            }

            // 存在
            if (i - j + 1 == s1.length()) {
                return true;
            }
        }

        return false;
    }
}