package com.yzy.mid;

import java.math.BigInteger;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/03 23:18
 * @Description
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 *
 *
 *
 * 示例 1：
 *
 * 输入：a = 2, b = [3]
 * 输出：8
 * 示例 2：
 *
 * 输入：a = 2, b = [1,0]
 * 输出：1024
 * 示例 3：
 *
 * 输入：a = 1, b = [4,3,3,8,5,2]
 * 输出：1
 * 示例 4：
 *
 * 输入：a = 2147483647, b = [2,0,0]
 * 输出：1198
 * @Version 1.0
 */
public class SuperPow {
    public int superPow(int a, int[] b) {
        StringBuilder sb  = new StringBuilder();
        for (int num :b) {
            sb.append(num);
        }
        return new BigInteger(String.valueOf(a))
                .modPow(new BigInteger(sb.toString()),new BigInteger("1337"))
                .intValue();
    }
}