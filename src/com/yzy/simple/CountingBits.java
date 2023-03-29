package com.yzy.simple;

/**
 * ClassName: CountingBits
 * Description:
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，
 * 计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * @author Administrator
 * @date 2023-3-28 9:29
 */
public class CountingBits {
    public static void main(String[] args) {

    }
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}
