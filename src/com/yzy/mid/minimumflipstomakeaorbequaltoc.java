package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/22 00:08
 * @Description
 * 给你三个正整数 a、b 和 c。
 *
 * 你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算   a OR b == c  成立的最小翻转次数。
 *
 * 「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：a = 2, b = 6, c = 5
 * 输出：3
 * 解释：翻转后 a = 1 , b = 4 , c = 5 使得 a OR b == c
 * 示例 2：
 *
 * 输入：a = 4, b = 2, c = 7
 * 输出：1
 * 示例 3：
 *
 * 输入：a = 1, b = 2, c = 3
 * 输出：0
 * @Version 1.0
 */
public class minimumflipstomakeaorbequaltoc {
    public int minFlips(int a, int b, int c) {
        int d = (a | b) ^ c;
        return Integer.bitCount(d)+Integer.bitCount(a&b&d);
    }
}