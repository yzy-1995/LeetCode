package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/02/13 19:58
 * @Description
 * 给你一个下标从 0 开始的二进制字符串 s 和两个整数 minJump 和 maxJump 。一开始，你在下标 0 处，且该位置的值一定为 '0' 。当同时满足如下条件时，你可以从下标 i 移动到下标 j 处：
 *
 * i + minJump <= j <= min(i + maxJump, s.length - 1) 且
 * s[j] == '0'.
 * 如果你可以到达 s 的下标 s.length - 1 处，请你返回 true ，否则返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "011010", minJump = 2, maxJump = 3
 * 输出：true
 * 解释：
 * 第一步，从下标 0 移动到下标 3 。
 * 第二步，从下标 3 移动到下标 5 。
 * 示例 2：
 *
 * 输入：s = "01101110", minJump = 2, maxJump = 3
 * 输出：false
 * @Version 1.0
 */
public class jumpgamevii {
    public boolean canReach(String s, int minJump, int maxJump) {
        boolean[] dp = new boolean[s.length()];
        dp[0] = true;
        int index = 0;
        for(int i=0;i<s.length();i++){
            if(dp[i]){
                for(int j=Math.max(index,i+minJump);j<=Math.min(i+maxJump,s.length()-1);j++){
                    if(s.charAt(j)=='0') dp[j] = true;
                }
                index = Math.min(i+maxJump,s.length()-1);
            }
        }
        return dp[dp.length-1];
    }
}