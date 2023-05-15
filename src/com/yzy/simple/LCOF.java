package com.yzy.simple;

/**
 * ClassName: LCOF
 * Description:
 *
 * @author Administrator
 * @date 2023-5-15 9:57
 */
public class LCOF {
    public int numWays(int n) {
        if (n == 1 || n == 0)
            return 1;
        if (n == 2)
            return 2;
        int a = 1, b = 2, sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }
}
