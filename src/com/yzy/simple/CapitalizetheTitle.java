package com.yzy.simple;

/**
 * Description: leetcode2129
 * 给你一个字符串 title ，它由单个空格连接一个或多个单词组成，每个单词都只包含英文字母。请你按以下规则将每个单词的首字母 大写 ：
 * 如果单词的长度为 1 或者 2 ，所有字母变成小写。
 * 否则，将单词首字母大写，剩余字母变成小写。
 * 请你返回 大写后 的 title 。
 * 示例 1：
 * 输入：title = "capiTalIze tHe titLe"
 * 输出："Capitalize The Title"
 * 解释：
 * 由于所有单词的长度都至少为 3 ，将每个单词首字母大写，剩余字母变为小写。
 * 示例 2：
 * 输入：title = "First leTTeR of EACH Word"
 * 输出："First Letter of Each Word"
 * 解释：
 * 单词 "of" 长度为 2 ，所以它保持完全小写。
 * 其他单词长度都至少为 3 ，所以其他单词首字母大写，剩余字母小写。
 * 示例 3：
 * 输入：title = "i lOve leetcode"
 * 输出："i Love Leetcode"
 * 解释：
 * 单词 "i" 长度为 1 ，所以它保留小写。
 * 其他单词长度都至少为 3 ，所以其他单词首字母大写，剩余字母小写。
 *
 * @author yzy15
 * @date 2023/05/05 22:51
 **/
public class CapitalizetheTitle {
    public static void main(String[] args) {

    }

    public String capitalizeTitle(String title) {
        String a[] = title.split(" ");
        String s = "";
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length(); j++) {
                if (a[i].length() == 1 || a[i].length() == 2) {
                    s += a[i].substring(j, j + 1).toLowerCase();
                } else {
                    if (j == 0) {
                        String b = a[i].substring(0, 1);
                        s += b.toUpperCase();
                    } else {

                        s += a[i].substring(j, j + 1).toLowerCase();
                    }

                }
            }
            s += " ";
        }
        return s.trim();
    }
}
