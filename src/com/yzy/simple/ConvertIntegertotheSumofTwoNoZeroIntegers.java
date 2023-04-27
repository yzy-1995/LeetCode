package com.yzy.simple;

/**
 * ClassName: ConvertIntegertotheSumofTwoNoZeroIntegers
 * Description:
 * 「无零整数」是十进制表示中 不含任何 0 的正整数。
 * 给你一个整数 n，请你返回一个 由两个整数组成的列表 [A, B]，满足：
 * A 和 B 都是无零整数
 * A + B = n
 * 题目数据保证至少有一个有效的解决方案。
 * 如果存在多个有效解决方案，你可以返回其中任意一个。
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：[1,1]
 * 解释：A = 1, B = 1. A + B = n 并且 A 和 B 的十进制表示形式都不包含任何 0 。
 * 示例 2：
 *
 * 输入：n = 11
 * 输出：[2,9]
 * 示例 3：
 *
 * 输入：n = 10000
 * 输出：[1,9999]
 * 示例 4：
 *
 * 输入：n = 69
 * 输出：[1,68]
 * 示例 5：
 *
 * 输入：n = 1010
 * 输出：[11,999]
 * @author Administrator
 * @date 2023-4-27 17:23
 */
public class ConvertIntegertotheSumofTwoNoZeroIntegers {
    public static void main(String[] args) {
        int[] noZeroIntegers = new ConvertIntegertotheSumofTwoNoZeroIntegers().getNoZeroIntegers(888888);
        for (int o :noZeroIntegers) {
            System.out.println(o);
        }

    }

    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            if (isValid(i) && isValid(n - i)) {
                return new int[]{i, n - i};
            }
        }
        return new int[]{-1, -1};
    }

    public static boolean isValid(int num) {
        while (num > 0) {
            if (num % 10 == 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}
