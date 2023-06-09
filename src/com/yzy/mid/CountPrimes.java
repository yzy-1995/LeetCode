package com.yzy.mid;

/**
 * ClassName: CountPrimes
 * Description:
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：0
 *
 * @author Administrator
 * @date 2023-6-9 16:13
 */
public class CountPrimes {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] flag = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!flag[i]) {
                count++;
                for (int j = i + i; j < n; j += i)
                    flag[j] = true;
            }
        }
        return count;
    }
}
