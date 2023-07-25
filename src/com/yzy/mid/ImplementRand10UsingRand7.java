package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/25 00:23
 * @Description
 * 给定方法 rand7 可生成 [1,7] 范围内的均匀随机整数，试写一个方法 rand10 生成 [1,10] 范围内的均匀随机整数。
 *
 * 你只能调用 rand7() 且不能调用其他方法。请不要使用系统的 Math.random() 方法。
 *
 * 每个测试用例将有一个内部参数 n，即你实现的函数 rand10() 在测试时将被调用的次数。请注意，这不是传递给 rand10() 的参数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: [2]
 * 示例 2:
 *
 * 输入: 2
 * 输出: [2,8]
 * 示例 3:
 *
 * 输入: 3
 * 输出: [3,8,10]
 * @Version 1.0
 */
public class ImplementRand10UsingRand7 {
    public int rand10() {
        int ans = rand2();
        for (int i = 0; i < 3; i++) {
            ans <<= 1;
            ans ^= rand2();
        }
        return (ans <= 10 && ans > 0) ? ans : rand10();
    }

    public int rand2() {
        int ans = rand7();
        return ans == 7 ? rand2() : ans % 2;
    }
}