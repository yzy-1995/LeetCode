package com.yzy.simple;

/**
 * Description: le
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 * <p>
 * 示例1:
 * <p>
 * 输入：n = 3
 * 输出：4
 * 说明: 有四种走法
 * 示例2:
 * <p>
 * 输入：n = 5
 * 输出：13
 * 提示:
 * <p>
 * n范围在[1, 1000000]之间
 *
 * @author yzy15
 * @date 2023/05/20 15:26
 **/
public class ThreeStepsProblem {

    public int waysToStep(int n) {
        if (n <= 2) return n;
        if (n == 3) return 4;
        int[] d = new int[n + 1];

        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for (int i = 4; i <= n; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % 1000000007 + d[i - 3];
            d[i] %= 1000000007;
        }
        return d[n];
    }
}
