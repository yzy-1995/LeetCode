package com.yzy.simple;

/**
 * Description: le
 * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
 * 示例1:
 * 输入：num = 2（或者0b10）
 * 输出 1 (或者 0b01)
 * 示例2:
 * 输入：num = 3
 * 输出：3
 * 提示:
 * num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。
 *
 * @author yzy15
 * @date 2023/05/20 15:21
 **/
public class Exchange {


    public int exchangeBits(int num) {
        String str = Integer.toBinaryString(num);
        if (str.length() % 2 != 0) {
            str = "0" + str;
        }
        char[] c = str.toCharArray();
        String result = "";
        for (int i = 0; i < str.length(); ) {
            result += c[i + 1];
            result += c[i];
            i += 2;
        }
        return Integer.parseInt(result, 2);
    }
}
