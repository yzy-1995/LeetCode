package com.yzy.mid;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * ClassName: SuperUglyNumber
 * Description:
 * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 * <p>
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 * <p>
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12, primes = [2,7,13,19]
 * 输出：32
 * 解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 * 示例 2：
 * <p>
 * 输入：n = 1, primes = [2,3,5]
 * 输出：1
 * 解释：1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。
 *
 * @author Administrator
 * @date 2023-6-25 10:22
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(1);
        while (n-- > 0) {
            int x = q.poll();
            if (n == 0) return x;
            for (int k : primes) {
                if (k <= Integer.MAX_VALUE / x) q.add(k * x);
                if (x % k == 0) break;
            }
        }
        return -1;
    }
}
