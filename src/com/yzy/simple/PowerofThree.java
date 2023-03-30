package com.yzy.simple;

/**
 * ClassName: PowerofThree
 * Description:
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 * @author Administrator
 * @date 2023-3-30 16:19
 */
public class PowerofThree {
    public static void main(String[] args) {
        PowerofThree powerOfThree = new PowerofThree();
        System.out.println(powerOfThree.isPowerOfThree(998899999));
    }
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
