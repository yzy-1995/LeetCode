package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/02 23:59
 * @Description
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：a = 1, b = 2
 * 输出：3
 * 示例 2：
 *
 * 输入：a = 2, b = 3
 * 输出：5
 * @Version 1.0
 */
public class SumofTwoIntegers {
    public  int getSum(int a, int b) {
        while ((a & b) != 0) {
            int t = (a & b) << 1;
            b = a ^ b;
            a = t;
        }
        return a ^ b;
    }
}