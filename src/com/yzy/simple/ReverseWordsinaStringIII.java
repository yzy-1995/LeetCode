package com.yzy.simple;

/**
 * ClassName: ReverseWordsinaStringIII
 * Description:
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * 示例 2:
 * <p>
 * 输入： s = "God Ding"
 * 输出："doG gniD"
 *
 * @author Administrator
 * @date 2023-4-13 11:41
 */
public class ReverseWordsinaStringIII {
    public static void main(String[] args) {
        ReverseWordsinaStringIII reverseWordsinaStringIII = new ReverseWordsinaStringIII();
        System.out.println(reverseWordsinaStringIII.reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            StringBuilder a = new StringBuilder(words[i]).reverse();
            sb.append(a);
            if (i != words.length - 1) {
                sb.append(" ");
            }

        }
        return sb.toString();
    }
}
