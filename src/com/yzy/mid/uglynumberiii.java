package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/08 22:12
 * @Description
 * 给你四个整数：n 、a 、b 、c ，请你设计一个算法来找出第 n 个丑数。
 *
 * 丑数是可以被 a 或 b 或 c 整除的 正整数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3, a = 2, b = 3, c = 5
 * 输出：4
 * 解释：丑数序列为 2, 3, 4, 5, 6, 8, 9, 10... 其中第 3 个是 4。
 * 示例 2：
 *
 * 输入：n = 4, a = 2, b = 3, c = 4
 * 输出：6
 * 解释：丑数序列为 2, 3, 4, 6, 8, 9, 10, 12... 其中第 4 个是 6。
 * 示例 3：
 *
 * 输入：n = 5, a = 2, b = 11, c = 13
 * 输出：10
 * 解释：丑数序列为 2, 4, 6, 8, 10, 11, 12, 13... 其中第 5 个是 10。
 * 示例 4：
 *
 * 输入：n = 1000000000, a = 2, b = 217983653, c = 336916467
 * 输出：1999999984
 * @Version 1.0
 */
public class uglynumberiii {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long a_b = commonMultiple(a, b), a_c = commonMultiple(a, c), b_c = commonMultiple(b, c);
        long a_b_c = commonMultiple(a_b, a_c);
        long l = 0, r = 2000000001;
        while (l < r) {
            long mid = (l + r) / 2;
            if (mid / a + mid / b + mid / c - mid / a_b - mid / a_c - mid / b_c + mid / a_b_c < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return (int) l;
    }

    private long commonMultiple(long a, long b) {
        if (a < b) return commonMultiple(b, a);
        long multi_a = a, multi_b = b, c;
        while ((c = a % b) != 0) {
            a = b;
            b = c;
        }
        // 防止a*b溢出
        return multi_a / b * multi_b;
    }
}