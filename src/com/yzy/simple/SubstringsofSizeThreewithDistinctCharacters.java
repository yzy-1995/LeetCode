package com.yzy.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: leetcode1876
 * 如果一个字符串不含有任何重复字符，我们称这个字符串为 好 字符串。
 * 给你一个字符串 s ，请你返回 s 中长度为 3 的 好子字符串 的数量。
 * 注意，如果相同的好子字符串出现多次，每一次都应该被记入答案之中。
 * 子字符串 是一个字符串中连续的字符序列。
 * 示例 1：
 * 输入：s = "xyzzaz"
 * 输出：1
 * 解释：总共有 4 个长度为 3 的子字符串："xyz"，"yzz"，"zza" 和 "zaz" 。
 * 唯一的长度为 3 的好子字符串是 "xyz" 。
 * 示例 2：
 * 输入：s = "aababcabc"
 * 输出：4
 * 解释：总共有 7 个长度为 3 的子字符串："aab"，"aba"，"bab"，"abc"，"bca"，"cab" 和 "abc" 。
 * 好子字符串包括 "abc"，"bca"，"cab" 和 "abc" 。
 *
 * @author yzy15
 * @date 2023/05/02 14:05
 **/
public class SubstringsofSizeThreewithDistinctCharacters {

    public int countGoodSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            set.add(s.charAt(i + 1));
            set.add(s.charAt(i + 2));
            if (set.size() == 3) {
                count++;
            }
        }
        return count;
    }

}
