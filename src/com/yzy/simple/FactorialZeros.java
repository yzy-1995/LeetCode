package com.yzy.simple;

/**
 * Description: le
 * 设计一个算法，算出 n 阶乘有多少个尾随零。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 * @author yzy15
 * @date 2023/05/20 16:04
 **/
public class FactorialZeros {

    public int trailingZeroes(int n) {
        int count = 0;
        while (n != 0) {
            n = n / 5;
            count = count + n;
        }

        return count;
    }
}
