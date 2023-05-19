package com.yzy.simple;

/**
 * ClassName: OfferII02
 * Description:
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * 示例 1:
 *
 * 输入: a = "11", b = "10"
 * 输出: "101"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * @author Administrator
 * @date 2023-5-19 13:42
 */
public class OfferII02 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int m = a.length() - 1, n = b.length() - 1;
        int carry = 0;
        while(m >= 0 || n >= 0){ // 从最低位开始，只要位数较多的那个数还未运算完毕就继续
            int ai = m >= 0 ? a.charAt(m) - '0' : 0;
            int bi = n >= 0 ? b.charAt(n) - '0' : 0;
            m--; n--;
            int cur = (ai + bi + carry) % 2; // 当前位
            carry = (ai + bi + carry) / 2; // 进位
            sb.append(cur);
        }
        if(carry == 1) sb.append(carry); // 最高位仍有进位时
        return sb.reverse().toString(); // 翻转
    }
}
