package com.yzy.simple;

/**
 * ClassName: MaximumDifferencebyRemappingaDigit
 * Description:
 * 给你一个整数 num 。你知道 Danny Mittal 会偷偷将 0 到 9 中的一个数字 替换 成另一个数字。
 * 请你返回将 num 中 恰好一个 数字进行替换后，得到的最大值和最小值的差为多少。
 * 注意：
 * 当 Danny 将一个数字 d1 替换成另一个数字 d2 时，Danny 需要将 nums 中所有 d1 都替换成 d2 。
 * Danny 可以将一个数字替换成它自己，也就是说 num 可以不变。
 * Danny 可以将数字分别替换成两个不同的数字分别得到最大值和最小值。
 * 替换后得到的数字可以包含前导 0 。
 * Danny Mittal 获得周赛 326 前 10 名，让我们恭喜他。
 * 示例 1：
 * 输入：num = 11891
 * 输出：99009
 * 解释：
 * 为了得到最大值，我们将数字 1 替换成数字 9 ，得到 99899 。
 * 为了得到最小值，我们将数字 1 替换成数字 0 ，得到 890 。
 * 两个数字的差值为 99009 。
 * 示例 2：
 * 输入：num = 90
 * 输出：99
 * 解释：
 * 可以得到的最大值是 99（将 0 替换成 9），最小值是 0（将 9 替换成 0）。
 * 所以我们得到 99 。
 *
 * @author Administrator
 * @date 2023-5-11 10:36
 */
public class MaximumDifferencebyRemappingaDigit {
    public static void main(String[] args) {

    }

    public int minMaxDifference(int num) {
        int max = 0, min = 0;
        boolean notNine = false;
        String str = String.valueOf(num);
        char c1 = 0, c2 = str.charAt(0);
        for (char c : str.toCharArray()) {
            if (c != '9') {
                if (!notNine) {
                    notNine = true;
                    c1 = c;
                    max = max * 10 + 9;
                } else {
                    if (c == c1) {
                        max = max * 10 + 9;
                    } else {
                        max = max * 10 + (c - '0');
                    }
                }
            } else {
                max = max * 10 + 9;
            }
            if (c == c2) {
                min = min * 10;
            } else {
                min = min * 10 + (c - '0');
            }
        }
        return max - min;
    }
}
