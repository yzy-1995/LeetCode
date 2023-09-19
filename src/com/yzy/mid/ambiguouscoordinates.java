package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/17 21:30
 * @Description
 * 我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表中。
 *
 * 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。
 *
 * 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。
 *
 *
 *
 * 示例 1:
 * 输入: "(123)"
 * 输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 * 示例 2:
 * 输入: "(00011)"
 * 输出:  ["(0.001, 1)", "(0, 0.011)"]
 * 解释:
 * 0.0, 00, 0001 或 00.01 是不被允许的。
 * 示例 3:
 * 输入: "(0123)"
 * 输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
 * 示例 4:
 * 输入: "(100)"
 * 输出: [(10, 0)]
 * 解释:
 * 1.0 是不被允许的。
 * @Version 1.0
 */
public class ambiguouscoordinates {
    public List<String> ambiguousCoordinates(String s) {
        int n=s.length();
        s=s.substring(1,n-1);
        List<String> ans=new ArrayList<>();
        for(int i=1;i<n-2;i++){
            List<String> part1=findSplit(s.substring(0,i)),part2=findSplit(s.substring(i));
            for(String a:part1){for(String b:part2){ans.add("("+a+", "+b+")");}}
        }
        return ans;
    }
    List<String> findSplit(String s){
        List<String> list=new ArrayList<>();
        if(s.length()==1||s.charAt(0)!='0'){list.add(s);}
        for(int i=1;i<s.length();i++){
            String s1=s.substring(0,i),s2=s.substring(i);
            if((s1.length()==1||s.charAt(0)!='0')&&s2.charAt(s2.length()-1)!='0'){list.add(s1+"."+s2);}
        }
        return list;
    }
}