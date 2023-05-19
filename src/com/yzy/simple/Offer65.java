package com.yzy.simple;

/**
 * ClassName: Offer65
 * Description:
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * 示例:
 * <p>
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 * @author Administrator
 * @date 2023-5-19 9:28
 */
public class Offer65 {
    public int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }
}
