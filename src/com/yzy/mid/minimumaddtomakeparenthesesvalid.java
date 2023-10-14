package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/08 00:02
 * @Description
 * 只有满足下面几点之一，括号字符串才是有效的：
 *
 * 它是一个空字符串，或者
 * 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 * 它可以被写作 (A)，其中 A 是有效字符串。
 * 给定一个括号字符串 s ，在每一次操作中，你都可以在字符串的任何位置插入一个括号
 *
 * 例如，如果 s = "()))" ，你可以插入一个开始括号为 "(()))" 或结束括号为 "())))" 。
 * 返回 为使结果字符串 s 有效而必须添加的最少括号数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "())"
 * 输出：1
 * 示例 2：
 *
 * 输入：s = "((("
 * 输出：3
 * @Version 1.0
 */
public class minimumaddtomakeparenthesesvalid {
    public int minAddToMakeValid(String s) {
        int ans = 0,countl = 0,countr = 0;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '('){
                if(countr != 0){
                    countl++;
                    ans += countr;
                    countr = 0;
                }else countl++;
            }
            if(s.charAt(i) == ')'){
                if(countl != 0) countl--;
                else countr++;
            }
        }
        return ans + countl + countr;
    }
}