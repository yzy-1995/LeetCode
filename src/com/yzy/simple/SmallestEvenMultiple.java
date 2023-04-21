package com.yzy.simple;

/**
 * ClassName: SmallestEvenMultiple
 * Description:
 * 给你一个正整数 n ，返回 2 和 n 的最小公倍数（正整数）。
 * 示例 1：
 * 输入：n = 5
 * 输出：10
 * 解释：5 和 2 的最小公倍数是 10 。
 * 示例 2：
 * 输入：n = 6
 * 输出：6
 * 解释：6 和 2 的最小公倍数是 6 。注意数字会是它自身的倍数。
 * @author Administrator
 * @date 2023-4-21 8:59
 */
public class SmallestEvenMultiple {
    public static void main(String[] args) {
        System.out.println(new SmallestEvenMultiple().smallestEvenMultiple(8));
    }

    public int smallestEvenMultiple(int n) {
        return (2 * n) / gcd(2, n);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
