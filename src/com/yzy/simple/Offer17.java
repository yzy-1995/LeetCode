package com.yzy.simple;

/**
 * ClassName: Offer17
 * Description:
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 * @author Administrator
 * @date 2023-5-15 10:05
 */
public class Offer17 {
    public int[] printNumbers(int n) {
        int m = (int) Math.pow(10, n);
        int[] a = new int[m - 1];
        for (int i = 0; i < m - 1; i++) {
            a[i] = i + 1;
        }
        return a;
    }
}
