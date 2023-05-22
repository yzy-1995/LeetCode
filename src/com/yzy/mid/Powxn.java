package com.yzy.mid;

/**
 * ClassName: Powxn
 * Description:
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 * @author Administrator
 * @date 2023-5-22 17:11
 */
public class Powxn {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            return 1 / (x * myPow(x, -(n + 1)));
        }
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return x * myPow(x, n - 1);
        }
    }
}
