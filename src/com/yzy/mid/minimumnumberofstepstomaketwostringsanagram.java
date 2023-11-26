package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/27 01:22
 * @Description
 * 给你两个长度相等的字符串 s 和 t。每一个步骤中，你可以选择将 t 中的 任一字符 替换为 另一个字符。
 *
 * 返回使 t 成为 s 的字母异位词的最小步骤数。
 *
 * 字母异位词 指字母相同，但排列不同（也可能相同）的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输出：s = "bab", t = "aba"
 * 输出：1
 * 提示：用 'b' 替换 t 中的第一个 'a'，t = "bba" 是 s 的一个字母异位词。
 * 示例 2：
 *
 * 输出：s = "leetcode", t = "practice"
 * 输出：5
 * 提示：用合适的字符替换 t 中的 'p', 'r', 'a', 'i' 和 'c'，使 t 变成 s 的字母异位词。
 * 示例 3：
 *
 * 输出：s = "anagram", t = "mangaar"
 * 输出：0
 * 提示："anagram" 和 "mangaar" 本身就是一组字母异位词。
 * 示例 4：
 *
 * 输出：s = "xxyyzz", t = "xxyyzz"
 * 输出：0
 * 示例 5：
 *
 * 输出：s = "friend", t = "family"
 * 输出：4
 * @Version 1.0
 */
public class minimumnumberofstepstomaketwostringsanagram {
    public int minSteps(String s, String t) {
        int[] hash = new int[26];
        for(int i = 0; i < s.length(); ++i){
            hash[s.charAt(i) - 'a']++;
            hash[t.charAt(i) - 'a']--;
        }
        int ans = 0;
        for(int i : hash){
            if(i > 0)ans += i;
        }
        return ans;
    }
}