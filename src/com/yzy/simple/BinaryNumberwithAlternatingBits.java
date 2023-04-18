package com.yzy.simple;

/**
 * ClassName: BinaryNumberwithAlternatingBits
 * Description:leetcode693
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 * 示例 1：
 * 输入：n = 5
 * 输出：true
 * 解释：5 的二进制表示是：101
 * 示例 2：
 * 输入：n = 7
 * 输出：false
 * 解释：7 的二进制表示是：111.
 * 示例 3：
 * 输入：n = 11
 * 输出：false
 * 解释：11 的二进制表示是：1011.
 * @author Administrator
 * @date 2023-4-18 9:37
 */
public class BinaryNumberwithAlternatingBits {
    public static void main(String[] args) {
        System.out.println(new BinaryNumberwithAlternatingBits().hasAlternatingBits(7));
    }
    public boolean hasAlternatingBits(int n) {
        String binaryString = Integer.toBinaryString(n);
        for (int i = 0; i < binaryString.length()-1; i++) {
            char c = binaryString.charAt(i);
            char d = binaryString.charAt(i+1);
            if (c==d){
                return false;
            }
        }
        return true;
    }
}
