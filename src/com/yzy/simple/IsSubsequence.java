package com.yzy.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: IsSubsequence
 * Description:
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 进阶：
 * <p>
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 *
 * @author Administrator
 * @date 2023-4-10 15:52
 */
public class IsSubsequence {
    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence("aaaaaa", "bbaaaa"));
    }

    public boolean isSubsequence(String s, String t) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> tmap = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tmap.put(c, i);
        }
        for (int i = 0; i < s.length(); i++) {
            if (!tmap.containsKey(s.charAt(i))) {
                return false;
            } else {
                right = tmap.get(s.charAt(i));
                int temp = 0;
                temp = right;
                right = left;
                left = temp;
                if (right > left) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSubsequence1(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

}
