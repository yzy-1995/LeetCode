package com.yzy.simple;

/**
 * Description: leetcode1784
 * 给你一个二进制字符串 s ，该字符串 不含前导零 。
 * 如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true​​​ 。否则，返回 false 。
 * 示例 1：
 * 输入：s = "1001"
 * 输出：false
 * 解释：由连续若干个 '1' 组成的字段数量为 2，返回 false
 * 示例 2：
 * 输入：s = "110"
 * 输出：true
 *
 * @author yzy15
 * @date 2023/05/01 22:51
 **/
public class CheckifBinaryStringHasatMostOneSegmentofOnes {
    public static void main(String[] args) {

    }


    public boolean checkOnesSegment(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
                while (i + 1 < s.length() && s.charAt(i + 1) == '1') {
                    i++;
                }
            }
        }
        return count <= 1;
    }
}
