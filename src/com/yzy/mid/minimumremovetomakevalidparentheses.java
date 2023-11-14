package com.yzy.mid;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/14 00:06
 * @Description
 * 给你一个由 '('、')' 和小写字母组成的字符串 s。
 *
 * 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
 *
 * 请返回任意一个合法字符串。
 *
 * 有效「括号字符串」应当符合以下 任意一条 要求：
 *
 * 空字符串或只包含小写字母的字符串
 * 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
 * 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
 *
 *
 * 示例 1：
 *
 * 输入：s = "lee(t(c)o)de)"
 * 输出："lee(t(c)o)de"
 * 解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
 * 示例 2：
 *
 * 输入：s = "a)b(c)d"
 * 输出："ab(c)d"
 * 示例 3：
 *
 * 输入：s = "))(("
 * 输出：""
 * 解释：空字符串也是有效的
 * @Version 1.0
 */
public class minimumremovetomakevalidparentheses {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb=new StringBuilder();
        int n=0;
        boolean[] bs=new boolean[s.length()];
        Deque<int[]> que=new LinkedList();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(') que.push(new int[]{0,i});
            if(c==')'){
                while(!que.isEmpty()&&que.peek()[0]!=0){
                    que.pop();
                }
                if(que.isEmpty()) bs[i]=true;
                else que.pop();
            }
        }
        while(!que.isEmpty()){
            int[] cur=que.pop();
            bs[cur[1]]=true;
        }
        for(int i=0;i<s.length();i++){
            if(bs[i]==false) sb.append(s.charAt(i));
        }
        return sb.toString();

    }
}