package com.yzy.simple;

/**
 * ClassName: OfferII01
 * Description:
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 * 注意：
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231−1]。本题中，如果除法结果溢出，则返回 231 − 1
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 15, b = 2
 * 输出：7
 * 解释：15/2 = truncate(7.5) = 7
 * 示例 2：
 * <p>
 * 输入：a = 7, b = -3
 * 输出：-2
 * 解释：7/-3 = truncate(-2.33333..) = -2
 * 示例 3：
 * <p>
 * 输入：a = 0, b = 1
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：a = 1, b = 1
 * 输出：1
 *
 * @author Administrator
 * @date 2023-5-19 13:39
 */
public class OfferII01 {
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        boolean flag = a > 0 && b > 0 || a < 0 && b < 0;
        long d = a;
        long v = b;
        d = d > 0 ? d : -d;
        v = v > 0 ? v : -v;
        int res = 0;
        while (true) {
            if (d < v) {
                break;
            }
            int cur = 1;
            long tmp = v;
            while (tmp + tmp <= d) {
                tmp += tmp;
                cur += cur;
            }
            res += cur;
            d -= tmp;
        }
        return flag ? res : -res;
    }
}
