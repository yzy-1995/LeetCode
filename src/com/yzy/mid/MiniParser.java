package com.yzy.mid;

import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/06 00:19
 * @Description
 * 给定一个字符串 s 表示一个整数嵌套列表，实现一个解析它的语法分析器并返回解析的结果 NestedInteger 。
 *
 * 列表中的每个元素只可能是整数或整数嵌套列表
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "324",
 * 输出：324
 * 解释：你应该返回一个 NestedInteger 对象，其中只包含整数值 324。
 * 示例 2：
 *
 * 输入：s = "[123,[456,[789]]]",
 * 输出：[123,[456,[789]]]
 * 解释：返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
 * 1. 一个 integer 包含值 123
 * 2. 一个包含两个元素的嵌套列表：
 *     i.  一个 integer 包含值 456
 *     ii. 一个包含一个元素的嵌套列表
 *          a. 一个 integer 包含值 789
 * @Version 1.0
 */
public class MiniParser {
    int start=0;
    public NestedInteger deserialize(String s) {
        if(s.charAt(start)=='['){
            start++;
            NestedInteger nestedInteger=new NestedInteger();
            while(s.charAt(start)!=']'){
                nestedInteger.add(deserialize(s));
                if(s.charAt(start)==','){start++;}
            }
            start++;
            return nestedInteger;
        }
        else{
            int positive=1;
            if(s.charAt(start)=='-'){
                positive=-1;
                start++;
            }
            int num=0;
            while(start<s.length()){
                char c=s.charAt(start);
                if(Character.isDigit(c)){
                    num=10*num+c-'0';
                    start++;
                }
                else{break;}
            }
            return new NestedInteger(positive*num);
        }
    }
}