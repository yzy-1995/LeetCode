package com.yzy.simple;

/**
 * ClassName: BaseSeven
 * Description:
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: num = 100
 * 输出: "202"
 * 示例 2:
 * <p>
 * 输入: num = -7
 * 输出: "-10"
 *
 * @author Administrator
 * @date 2023-4-12 15:08
 */
public class BaseSeven {
    public static void main(String[] args) {
        System.out.println(convertToBase7(-10));
    }

    public static String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        int absNum = Math.abs(num);

        while (absNum != 0) {
            sb.append(absNum % 7);
            absNum /= 7;
        }

        if (num < 0) {
            sb.append("-");
        }

        return sb.reverse().toString();
    }
}
