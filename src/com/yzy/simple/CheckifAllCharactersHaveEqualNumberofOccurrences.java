package com.yzy.simple;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: leetcode1941
 * 给你一个字符串 s ，如果 s 是一个 好 字符串，请你返回 true ，否则请返回 false 。
 * 如果 s 中出现过的 所有 字符的出现次数 相同 ，那么我们称字符串 s 是 好 字符串。
 * 示例 1：
 * 输入：s = "abacbc"
 * 输出：true
 * 解释：s 中出现过的字符为 'a'，'b' 和 'c' 。s 中所有字符均出现 2 次。
 * 示例 2：
 * 输入：s = "aaabb"
 * 输出：false
 * 解释：s 中出现过的字符为 'a' 和 'b' 。
 * 'a' 出现了 3 次，'b' 出现了 2 次，两者出现次数不同。
 * @author yzy15
 * @date 2023/05/03 21:35
 **/
public class CheckifAllCharactersHaveEqualNumberofOccurrences {
    public static void main(String[] args) {

    }

    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        Collection<Integer> values = countMap.values();
        int firstVal = values.iterator().next();
        for (int val : values) {
            if (val != firstVal) {
                return false;
            }
        }
        return true;
    }
}
