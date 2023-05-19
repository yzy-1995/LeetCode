package com.yzy.simple;

/**
 * ClassName: StringRotation
 * Description:
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * 示例1:
 *
 *  输入：s1 = "waterbottle", s2 = "erbottlewat"
 *  输出：True
 * 示例2:
 *
 *  输入：s1 = "aa", s2 = "aba"
 *  输出：False
 * @author Administrator
 * @date 2023-5-19 16:29
 */
public class StringRotation {

    public boolean isFlipedString(String s1, String s2) {
        if (s1.length()!=s2.length()) return false;
        String ss = s2+s2;
        return ss.contains(s1);
    }
}
