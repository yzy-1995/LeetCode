package com.yzy.simple;

/**
 * Description: leetcode2496
 * 一个由字母和数字组成的字符串的 值 定义如下：
 * 如果字符串 只 包含数字，那么值为该字符串在 10 进制下的所表示的数字。
 * 否则，值为字符串的 长度 。
 * 给你一个字符串数组 strs ，每个字符串都只由字母和数字组成，请你返回 strs 中字符串的 最大值 。
 * 示例 1：
 * 输入：strs = ["alic3","bob","3","4","00000"]
 * 输出：5
 * 解释：
 * - "alic3" 包含字母和数字，所以值为长度 5 。
 * - "bob" 只包含字母，所以值为长度 3 。
 * - "3" 只包含数字，所以值为 3 。
 * - "4" 只包含数字，所以值为 4 。
 * - "00000" 只包含数字，所以值为 0 。
 * 所以最大的值为 5 ，是字符串 "alic3" 的值。
 * 示例 2：
 * 输入：strs = ["1","01","001","0001"]
 * 输出：1
 * 解释：
 * 数组中所有字符串的值都是 1 ，所以我们返回 1 。
 *
 * @author yzy15
 * @date 2023/05/10 21:25
 **/
public class MaximumValueofaStringinanArray {
    public static void main(String[] args) {

    }

    public int maximumValue(String[] strs) {
        int ans = 0;
        for (int i = 0; i < strs.length; i++) {
            boolean isDigit = true;
            for (char c : strs[i].toCharArray()) {
                if (Character.isLetter(c)) {
                    isDigit = false;
                    ans = Math.max(ans, strs[i].length());
                }
            }
            if (isDigit) {
                ans = Math.max(ans, Integer.parseInt(strs[i]));
            }
        }
        return ans;
    }
}
