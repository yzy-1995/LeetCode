package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/09 21:28
 * @Description 给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：n = 11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 * @Version 1.0
 */
public class NthDigit {
    public int findNthDigit(int n) {
        long start = 1;
        long end = 9;
        int digit = 1;
        while (n > digit * end) {
            n -= digit * end;
            digit += 1;
            start *= 10;
            end *= 10;
        }
        long num = start + (n - 1) / digit;
        String s = num + "";
        return s.charAt((n - 1) % digit) - '0';
    }
}