package com.yzy.simple;

import java.util.List;

/**
 * ClassName: NumberofSegmentsinaString
 * Description:
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 *
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 * @author Administrator
 * @date 2023-4-11 15:41
 */
public class NumberofSegmentsinaString {
    public static void main(String[] args) {
        NumberofSegmentsinaString numberofSegmentsinaString = new NumberofSegmentsinaString();
        System.out.println(numberofSegmentsinaString.countSegments("Hello, my name is John"));
    }

    public int countSegments(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        String[] words = s.trim().split("\\s+");
        return words.length;
    }


}
