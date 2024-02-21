package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/02/22 00:30
 * @Description
 * 给你一个字符串 s ，返回 s 中 长度为 3 的不同回文子序列 的个数。
 *
 * 即便存在多种方法来构建相同的子序列，但相同的子序列只计数一次。
 *
 * 回文 是正着读和反着读一样的字符串。
 *
 * 子序列 是由原字符串删除其中部分字符（也可以不删除）且不改变剩余字符之间相对顺序形成的一个新字符串。
 *
 * 例如，"ace" 是 "abcde" 的一个子序列。
 *
 *
 * 示例 1：
 *
 * 输入：s = "aabca"
 * 输出：3
 * 解释：长度为 3 的 3 个回文子序列分别是：
 * - "aba" ("aabca" 的子序列)
 * - "aaa" ("aabca" 的子序列)
 * - "aca" ("aabca" 的子序列)
 * 示例 2：
 *
 * 输入：s = "adc"
 * 输出：0
 * 解释："adc" 不存在长度为 3 的回文子序列。
 * 示例 3：
 *
 * 输入：s = "bbcbaba"
 * 输出：4
 * 解释：长度为 3 的 4 个回文子序列分别是：
 * - "bbb" ("bbcbaba" 的子序列)
 * - "bcb" ("bbcbaba" 的子序列)
 * - "bab" ("bbcbaba" 的子序列)
 * - "aba" ("bbcbaba" 的子序列)
 * @Version 1.0
 */
public class uniquelength3palindromicsubsequences {
    public int countPalindromicSubsequence(String s) {
        int num=0;
        for(int i=0;i<26;i++){
            int[] arr=new int[26];
            char index=(char)(i+97);
            int left=s.indexOf(index);
            int right=s.lastIndexOf(index);
            for(int j=left+1;j<right;j++){
                arr[s.charAt(j)-97]++;
            }
            for(int j=0;j<26;j++){
                if(arr[j]!=0){
                    num++;
                }
            }
        }
        return num;

    }
}