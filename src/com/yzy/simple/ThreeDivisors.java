package com.yzy.simple;

/**
 * Description: leetcode1952
 * 给你一个整数 n 。如果 n 恰好有三个正除数 ，返回 true ；否则，返回 false 。
 * 如果存在整数 k ，满足 n = k * m ，那么整数 m 就是 n 的一个 除数 。
 * 示例 1：
 * 输入：n = 2
 * 输出：false
 * 解释：2 只有两个除数：1 和 2 。
 * 示例 2：
 * 输入：n = 4
 * 输出：true
 * 解释：4 有三个除数：1、2 和 4 。
 *
 * @author yzy15
 * @date 2023/05/03 21:56
 **/
public class ThreeDivisors {
    public static void main(String[] args) {

    }


    public boolean isThree(int n) {
        if (n < 4) {
            return false;
        }
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count += (i * i == n) ? 1 : 2;
            }
            if (count > 3) {
                return false;
            }
        }
        return count == 3;
    }
}
