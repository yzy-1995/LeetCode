package com.yzy.simple;

/**
 * Description: le
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入: num = 1775(110111011112)
 * 输出: 8
 * 示例 2：
 * <p>
 * 输入: num = 7(01112)
 * 输出: 4
 *
 * @author yzy15
 * @date 2023/05/20 15:18
 **/
public class ReverseBits {
    public int reverseBits(int num) {
        //统计num的32个二进制位上的数字
        int[] bits = new int[32];
        for (int i = 0; i < 32; i++) {
            bits[i] = (num >> i) & 1;
        }
        int[][] dp = new int[32][2]; //动态规划
        //dp[i][0]记录不插入1时, 以i为连续1尾部的长度
        //dp[i][0]记录最新遇到的0二进制位插入1时,以i为连续1尾部的长度
        dp[0][0] = bits[0];
        dp[0][1] = 1; //初始化
        int ans = 1; //记录返回结果
        for (int i = 1; i < 32; i++) {
            if (bits[i] == 0) { //遇到0时
                dp[i][0] = 0; //dp[i][0] = 1
                dp[i][1] = 1 + dp[i - 1][0]; //第i位插入1, dp[i][1] = 1 + dp[i - 1][0];
            } else {
                dp[i][0] = 1 + dp[i - 1][0]; //dp[i][0] = 1 + dp[i - 1][0]
                dp[i][1] = 1 + dp[i - 1][1]; //第i位不插入1,之前遇到的二进制位插入1, dp[i][1] = dp[i-1][1] + 1
            }
            ans = Math.max(ans, dp[i][1]); //更新返回结果
        }
        return ans;
    }
}
