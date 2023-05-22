package com.yzy.simple;

/**
 * Description: le
 * 设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
 * <p>
 * 示例:
 * <p>
 * 输入: a = 1, b = 1
 * 输出: 2
 * <p>
 * <p>
 * 提示：
 * <p>
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 *
 * @author yzy15
 * @date 2023/05/20 16:31
 **/
public class AddWithoutPlus {

    public int add(int a, int b) {
        int sum = 0, carry = 0;
        while (b != 0) {
            sum = a ^ b;            // 异或计算未进位的部分
            carry = (a & b) << 1;    // 进位部分
            a = sum;                // 保存未进位部分，再次计算
            b = carry;                // 保存进位部分，再次计算
        }
        return a;    // 最后无进位，异或的结果即加法结果
    }
}
