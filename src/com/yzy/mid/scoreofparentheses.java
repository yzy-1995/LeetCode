package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/26 00:15
 * @Description
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 *
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 *
 *
 * 示例 1：
 *
 * 输入： "()"
 * 输出： 1
 * 示例 2：
 *
 * 输入： "(())"
 * 输出： 2
 * 示例 3：
 *
 * 输入： "()()"
 * 输出： 2
 * 示例 4：
 *
 * 输入： "(()(()))"
 * 输出： 6
 * @Version 1.0
 */
public class scoreofparentheses {
    int idx = 0;
    public int scoreOfParentheses(String s) {
        int res = 0;
        while (idx < s.length() && s.charAt(idx) == '(') {
            idx++; //跳过当前 (
            if (s.charAt(idx) == ')') res += 1; // 没有子节点
            else res += scoreOfParentheses(s) * 2; // 存在子节点
            idx++; //跳过当前 )
        }
        return res;
    }
}