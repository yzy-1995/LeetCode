package com.yzy.simple;

/**
 * ClassName: DecryptStringfromAlphabettoIntegerMapping
 * Description:
 * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
 *
 * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
 * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。
 * 返回映射之后形成的新字符串。
 *
 * 题目数据保证映射始终唯一。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "10#11#12"
 * 输出："jkab"
 * 解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 * 示例 2：
 *
 * 输入：s = "1326#"
 * 输出："acz"
 * @author Administrator
 * @date 2023-4-27 15:42
 */
public class DecryptStringfromAlphabettoIntegerMapping {
    public static void main(String[] args) {

    }

    /**
     * freqAlphabets() 方法使用一个 while 循环遍历字符串 s。如果遇到 '#'，
     * 则表明当前位置表示的是一个两位数，将其解析成对应的字符并添加到结果字符串中。
     * 如果没有遇到 '#'，则表示当前位置是一个一位数，将其解析成对应的字符并添加到结果字符串中。
     * 在循环结束后，返回结果字符串。
     * @param s
     * @return
     */
    public String freqAlphabets(String s) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            if (i < s.length() - 2 && s.charAt(i + 2) == '#') {
                result.append((char) ('a' + Integer.parseInt(s.substring(i, i + 2)) - 1));
                i += 3;
            } else {
                result.append((char) ('a' + Integer.parseInt(s.substring(i, i + 1)) - 1));
                i += 1;
            }
        }

        return result.toString();
    }
}
