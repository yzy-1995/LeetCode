package com.yzy.simple;

/**
 * ClassName: SubtracttheProductandSumofDigitsofanInteger
 * Description:
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 * 示例 1：
 *
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 * 示例 2：
 *
 * 输入：n = 4421
 * 输出：21
 * 解释：
 * 各位数之积 = 4 * 4 * 2 * 1 = 32
 * 各位数之和 = 4 + 4 + 2 + 1 = 11
 * 结果 = 32 - 11 = 21
 * @author Administrator
 * @date 2023-4-27 11:46
 */
public class SubtracttheProductandSumofDigitsofanInteger {
    public static void main(String[] args) {

    }

    /**
     * 首先初始化乘积（product）和和（sum）变量。然后使用 while 循环遍历整数 n 的每一位数字。
     * 在循环中，我们通过对 10 取余得到当前位的数字（digit），然后更新 product 和 sum。
     * 接着将 n 除以 10，以移动到下一位数字。最后返回 product 和 sum 的差。
     * @param n
     * @return
     */
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            product *= digit;
            sum += digit;
            n /= 10;
        }

        return product - sum;

    }
}
