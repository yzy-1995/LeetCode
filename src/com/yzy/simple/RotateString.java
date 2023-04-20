package com.yzy.simple;

/**
 * ClassName: RotateString
 * Description:
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
 * 示例 1:
 * 输入: s = "abcde", goal = "cdeab"
 * 输出: true
 * 示例 2:
 * 输入: s = "abcde", goal = "abced"
 * 输出: false
 *
 * @author Administrator
 * @date 2023-4-20 13:41
 */
public class RotateString {
    public static void main(String[] args) {
        System.out.println(new RotateString().rotateString("abcde","abced"));
    }
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.equals(goal)) {
                return true;
            }
            s = s.substring(1) + s.charAt(0);
        }
        return false;
    }
}
