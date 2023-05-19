package com.yzy.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: PalindromePermutationLCCI
 * Description:
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * <p>
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * <p>
 * 回文串不一定是字典当中的单词。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 *
 * @author Administrator
 * @date 2023-5-19 16:21
 */
public class PalindromePermutationLCCI {

    public boolean canPermutePalindrome(String s) {
        if (s == null) {
            return false;
        }
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : chars) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() <= 1;
    }
}
