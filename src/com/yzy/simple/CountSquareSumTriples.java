package com.yzy.simple;

/**
 * Description: leetcode1925
 * 一个 平方和三元组 (a,b,c) 指的是满足 a2 + b2 = c2 的 整数 三元组 a，b 和 c 。
 * 给你一个整数 n ，请你返回满足 1 <= a, b, c <= n 的 平方和三元组 的数目。
 * 示例 1：
 * 输入：n = 5
 * 输出：2
 * 解释：平方和三元组为 (3,4,5) 和 (4,3,5) 。
 * 示例 2：
 * 输入：n = 10
 * 输出：4
 * 解释：平方和三元组为 (3,4,5)，(4,3,5)，(6,8,10) 和 (8,6,10) 。
 *
 * @author yzy15
 * @date 2023/05/03 15:50
 **/
public class CountSquareSumTriples {
    public static void main(String[] args) {

    }

    public int countTriples(int n) {
        int count = 0;
        for (int c = 0; c <= n; c++) {
            for (int b = 0; b < c; b++) {
                int a = (int) Math.sqrt(c * c - b * b);
                if (a * a + b * b == c * c && a <= n) {
                    count++;
                }
            }
        }
        return count;
    }
}
