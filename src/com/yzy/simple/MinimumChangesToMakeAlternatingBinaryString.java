package com.yzy.simple;

/**
 * Description: leetcode1758
 * 给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
 * 交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。
 * 返回使 s 变成 交替字符串 所需的 最少 操作数。
 * 示例 1：
 * 输入：s = "0100"
 * 输出：1
 * 解释：如果将最后一个字符变为 '1' ，s 就变成 "0101" ，即符合交替字符串定义。
 * 示例 2：
 * 输入：s = "10"
 * 输出：0
 * 解释：s 已经是交替字符串。
 * 示例 3：
 * 输入：s = "1111"
 * 输出：2
 * 解释：需要 2 步操作得到 "0101" 或 "1010" 。
 *
 * @author yzy15
 * @date 2023/05/01 21:59
 **/
public class MinimumChangesToMakeAlternatingBinaryString {
    public static void main(String[] args) {

    }

    public int minOperations(String s) {
        int option1 = 0;
        int option2 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '0') {
                    option1++;
                } else {
                    option2++;
                }
            } else {
                if (s.charAt(i) == '1') {
                    option1++;
                } else {
                    option2++;
                }
            }
        }

        return Math.min(option1, option2);
    }
}
