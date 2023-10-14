package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/07 00:04
 * @Description
 * 给你两个字符串数组 words1 和 words2。
 *
 * 现在，如果 b 中的每个字母都出现在 a 中，包括重复出现的字母，那么称字符串 b 是字符串 a 的 子集 。
 *
 * 例如，"wrr" 是 "warrior" 的子集，但不是 "world" 的子集。
 * 如果对 words2 中的每一个单词 b，b 都是 a 的子集，那么我们称 words1 中的单词 a 是 通用单词 。
 *
 * 以数组形式返回 words1 中所有的通用单词。你可以按 任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
 * 输出：["facebook","google","leetcode"]
 * 示例 2：
 *
 * 输入：words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
 * 输出：["apple","google","leetcode"]
 * 示例 3：
 *
 * 输入：words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","oo"]
 * 输出：["facebook","google"]
 * 示例 4：
 *
 * 输入：words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["lo","eo"]
 * 输出：["google","leetcode"]
 * 示例 5：
 *
 * 输入：words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["ec","oc","ceo"]
 * 输出：["facebook","leetcode"]
 * @Version 1.0
 */
public class wordsubsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] w2=new int[26];
        for(String s:words2){
            int[] cur=new int[26];
            for(char c:s.toCharArray()){
                cur[c-'a']++;
            }
            for(int i=0;i<26;i++){
                w2[i]=Math.max(w2[i],cur[i]);
            }
        }
        List<String> res=new ArrayList();
        for(String w:words1){
            int[] w1=new int[26];
            for(char c:w.toCharArray()){
                w1[c-'a']++;
            }
            boolean flag=true;
            for(int i=0;i<26;i++){
                if(w2[i]>w1[i]){
                    flag=false;
                    break;
                }
            }
            if(flag) res.add(w);
        }
        return res;
    }
}