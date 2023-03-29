package com.yzy.simple;

/**
 * ClassName: HammingDistance
 * Description:
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * @author Administrator
 * @date 2023-3-28 14:18
 */
public class HammingDistance {

    public static void main(String[] args) {
        HammingDistance hammingDistance = new HammingDistance();
        System.out.println(hammingDistance.hammingDistance(3, 1));
    }

    /**
     * 汉明距离指的是两个数的二进制表示中，对应位置上不同的位数。
     *
     * 因此，我们可以将两个数转化为二进制，然后对每一位进行比较，统计不同的位数即可。
     *
     * 具体来说，我们可以使用异或运算（^）来将两个数对应的二进制位进行比较，不同的位上结果为 1，
     * 相同的位上结果为 0。然后，我们可以统计异或结果中 1 的个数，即为两个数的汉明距离。
     * @param x
     * @param y
     * @return
     */
    private int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor != 0) {
            if ((xor & 1) == 1) {
                count++;
            }
            xor = xor >> 1;
        }
        return count;
    }
}
