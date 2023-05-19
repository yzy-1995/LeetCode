package com.yzy.simple;


/**
 * ClassName: CheckPermutationLCCI
 * Description:
 * 给定两个由小写字母组成的字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * @author Administrator
 * @date 2023-5-19 16:16
 */
public class CheckPermutationLCCI {

    public boolean CheckPermutation(String s1, String s2) {
        int[] map = new int[26];
        for(int i = 0 ; i < s1.length(); i++){
            map[s1.charAt(i)-'a']++;
        }
        for(int i = 0 ; i < s2.length(); i++){
            map[s2.charAt(i)-'a']--;
        }
        for(int i = 0 ; i < 26; i++){
            if(map[i] != 0) return false;
        }
        return true;
    }
}
