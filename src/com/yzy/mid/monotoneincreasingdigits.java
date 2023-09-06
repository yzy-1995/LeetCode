package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/04 00:47
 * @Description
 * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 *
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: n = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: n = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: n = 332
 * 输出: 299
 * @Version 1.0
 */
public class monotoneincreasingdigits {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] ch = s.toCharArray();
        // flag要设置为ch.length,防止本身是递增整数也会误处理9，说白了就是不让它进入第2个for循环
        int flag = ch.length;
        for (int i = ch.length - 1; i > 0; i--) {
            if (ch[i - 1] > ch[i]) {
                ch[i - 1] = (char) (ch[i - 1] - 1);
                // flag之后的全部设置为9，处理数字后面是0的情况
                flag = i;
            }
        }
        for (int i = flag; i < ch.length; i++) {
            ch[i] = '9';
        }
        String string = new String(ch);
        return Integer.valueOf(string);
    }
}