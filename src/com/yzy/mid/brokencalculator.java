package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/22 01:38
 * @Description
 * 在显示着数字 startValue 的坏计算器上，我们可以执行以下两种操作：
 *
 * 双倍（Double）：将显示屏上的数字乘 2；
 * 递减（Decrement）：将显示屏上的数字减 1 。
 * 给定两个整数 startValue 和 target 。返回显示数字 target 所需的最小操作数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：startValue = 2, target = 3
 * 输出：2
 * 解释：先进行双倍运算，然后再进行递减运算 {2 -> 4 -> 3}.
 * 示例 2：
 *
 * 输入：startValue = 5, target = 8
 * 输出：2
 * 解释：先递减，再双倍 {5 -> 4 -> 8}.
 * 示例 3：
 *
 * 输入：startValue = 3, target = 10
 * 输出：3
 * 解释：先双倍，然后递减，再双倍 {3 -> 6 -> 5 -> 10}.
 * @Version 1.0
 */
public class brokencalculator {
    public int brokenCalc(int startValue, int target) {
        if (target <= startValue) return startValue-target;
        int n = 0;
        while ((1 << n) * startValue < target){
            n++;
        }
        int diff = (1 << n) * startValue - target, result = n;
        if (diff == 0) return result;
        while (diff != 0){
            int t = diff / (1 << n);
            diff -= (1 << n) * t;
            result += t;
            n--;
        }
        return result;
    }
}