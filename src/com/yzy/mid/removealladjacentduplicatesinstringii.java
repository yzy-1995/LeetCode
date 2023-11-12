package com.yzy.mid;

import java.util.LinkedList;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/10 10:38
 * @Description
 * 给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。
 *
 * 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
 *
 * 在执行完所有删除操作后，返回最终得到的字符串。
 *
 * 本题答案保证唯一。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcd", k = 2
 * 输出："abcd"
 * 解释：没有要删除的内容。
 * 示例 2：
 *
 * 输入：s = "deeedbbcccbdaa", k = 3
 * 输出："aa"
 * 解释：
 * 先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
 * 再删除 "bbb"，得到 "dddaa"
 * 最后删除 "ddd"，得到 "aa"
 * 示例 3：
 *
 * 输入：s = "pbbcggttciiippooaais", k = 2
 * 输出："ps"
 * @Version 1.0
 */
public class removealladjacentduplicatesinstringii {
    public String removeDuplicates(String s, int k) {
        LinkedList<int[]> stack = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            int c = s.charAt(i)-'a';
            if(stack.size()>0 && stack.peekLast()[0] == c){
                int[] p = stack.pollLast();
                if(p[1]+1 == k){

                }else {
                    stack.add(new int[]{c, p[1]+1});
                }
            }else {
                stack.add(new int[]{c, 1});
            }
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size()>0){
            int[] p = stack.pollFirst();
            char c =(char) ('a' + p[0]);
            for (int i = 0; i < p[1]; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}