package com.yzy.simple;

/**
 * Description: leetcode2119
 * 反转 一个整数意味着倒置它的所有位。
 * 例如，反转 2021 得到 1202 。反转 12300 得到 321 ，不保留前导零 。
 * 给你一个整数 num ，反转 num 得到 reversed1 ，接着反转 reversed1 得到 reversed2 。如果 reversed2 等于 num ，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：num = 526
 * 输出：true
 * 解释：反转 num 得到 625 ，接着反转 625 得到 526 ，等于 num 。
 * 示例 2：
 * 输入：num = 1800
 * 输出：false
 * 解释：反转 num 得到 81 ，接着反转 81 得到 18 ，不等于 num 。
 * 示例 3：
 * 输入：num = 0
 * 输出：true
 * 解释：反转 num 得到 0 ，接着反转 0 得到 0 ，等于 num 。
 * @author yzy15
 * @date 2023/05/05 21:34
 **/
public class ANumberAfteraDoubleReversal {
    public static void main(String[] args) {

    }

    public boolean isSameAfterReversals(int num) {
        // 转化为字符串
        String strNum = Integer.toString(num);
        // 反转字符串
        String reversed1 = new StringBuilder(strNum).reverse().toString();
        // 去掉前导零
        while (reversed1.startsWith("0") && reversed1.length() > 1) {
            reversed1 = reversed1.substring(1);
        }
        // 再次反转字符串
        String reversed2 = new StringBuilder(reversed1).reverse().toString();
        // 转化为整数并比较
        return num == Integer.parseInt(reversed2);
    }
}
