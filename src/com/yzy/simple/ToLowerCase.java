package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ToLowerCase
 * Description:leetcode709
 * 给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
 * 示例 1：
 * 输入：s = "Hello"
 * 输出："hello"
 * 示例 2：
 * 输入：s = "here"
 * 输出："here"
 * 示例 3：
 * 输入：s = "LOVELY"
 * 输出："lovely"
 * @author Administrator
 * @date 2023-4-19 10:30
 */
public class ToLowerCase {

    public static void main(String[] args) {
        System.out.println(new ToLowerCase().toLowerCase("Hello"));
    }


    public String toLowerCase(String s) {
        return s.toLowerCase();
    }
}
