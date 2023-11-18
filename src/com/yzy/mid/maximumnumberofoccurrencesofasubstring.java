package com.yzy.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/19 00:18
 * @Description
 * 给你一个字符串 s ，请你返回满足以下条件且出现次数最大的 任意 子串的出现次数：
 *
 * 子串中不同字母的数目必须小于等于 maxLetters 。
 * 子串的长度必须大于等于 minSize 且小于等于 maxSize 。
 *
 *
 * 示例 1：
 *
 * 输入：s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
 * 输出：2
 * 解释：子串 "aab" 在原字符串中出现了 2 次。
 * 它满足所有的要求：2 个不同的字母，长度为 3 （在 minSize 和 maxSize 范围内）。
 * 示例 2：
 *
 * 输入：s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
 * 输出：2
 * 解释：子串 "aaa" 在原字符串中出现了 2 次，且它们有重叠部分。
 * 示例 3：
 *
 * 输入：s = "aabcabcab", maxLetters = 2, minSize = 2, maxSize = 3
 * 输出：3
 * 示例 4：
 *
 * 输入：s = "abcde", maxLetters = 2, minSize = 3, maxSize = 3
 * 输出：0
 * @Version 1.0
 */
public class maximumnumberofoccurrencesofasubstring {
    private boolean checkMaxLetter(String s,int maxLetter){
        Map<Character,Integer> m = new HashMap<>();
        char[] chars=s.toCharArray();
        for(char c:chars){
            m.put(c,m.getOrDefault(c,0)+1);
            if(m.size()>maxLetter) return false;
        }
        return true;
    }
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int max = 0;
        Map<String,Integer> m = new HashMap<>();
        for(int i=0;i<=s.length()-minSize;i++){
            String t = s.substring(i,i+minSize);
            m.put(t,m.getOrDefault(t,0)+1);
        }
        for(String t:m.keySet()){
            if(m.get(t)>max&&checkMaxLetter(t,maxLetters)) max = m.get(t);
        }
        return max;
    }
}