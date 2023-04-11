package com.yzy.simple;

/**
 * ClassName: ArrangingCoins
 * Description:
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，
 * 其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 *
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 * 输入：n = 5
 * 输出：2
 * 解释：因为第三行不完整，所以返回 2 。
 * 输入：n = 8
 * 输出：3
 * 解释：因为第四行不完整，所以返回 3 。
 * @author Administrator
 * @date 2023-4-11 15:57
 */
public class ArrangingCoins {
    public static void main(String[] args) {
        ArrangingCoins arrangingCoins = new ArrangingCoins();
        System.out.println(arrangingCoins.arrangeCoins(9));
    }
    public int arrangeCoins(int n) {
        if (n < 1) {
            return 0;
        }

        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long total = (long) mid * (mid + 1) / 2;
            if (total == n) {
                return mid;
            } else if (total < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
    public int arrangeCoins1(int n) {
        int rows = 0;
        int coinsInRow = 1;

        while (n >= coinsInRow) {
            rows++;
            n -= coinsInRow;
            coinsInRow++;
        }
        return rows;
    }
}
