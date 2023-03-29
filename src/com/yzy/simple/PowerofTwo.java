package com.yzy.simple;

/**
 * ClassName: PowerofTwo
 * Description:
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：true
 * 解释：20 = 1
 * 示例 2：
 * <p>
 * 输入：n = 16
 * 输出：true
 * 解释：24 = 16
 * 示例 3：
 * <p>
 * 输入：n = 3
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：n = 4
 * 输出：true
 *
 * @author Administrator
 * @date 2023-3-29 10:13
 */
public class PowerofTwo {
    public static void main(String[] args) {
        PowerofTwo powerofTwo = new PowerofTwo();
        System.out.println(powerofTwo.isPowerOfTwo(10));
    }

    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }

        while (n % 2 == 0) {
            n = n / 2;
        }
        if (n == 1) {
            return true;
        }
        return false;
    }
}
