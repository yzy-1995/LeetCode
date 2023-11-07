package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/05 00:09
 * @Description
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * @Version 1.0
 */
public class editdistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];

        //初始化,dp[i][j]表示word1的截止i位置到word2的截止j位置字符串变换需要几步
        //解释下每个位置操作的含义：
        //dp[i-1][j] 删除操作，表示0~i-1的word1通过某些操作可以得到0~j的word2，那么删除word1的i位置字符串再进行同样操作即可
        //dp[i][j-1] 插入操作，表示0~i的word1通过某些操作可以得到0~j-1的word2，那么直接在该操作后【在word1中直接插入word2的j位置字符】
        //dp[i-1][j-1] 表示0~i-1的word1已经可以得到0~j-1的word2，此时分为i，j字符相等和不等两种情况，不等则需要经过一次替换
        for(int j = 1;j <= n; ++j) dp[0][j] = dp[0][j-1] + 1;
        for(int i = 1;i <= m; ++i) dp[i][0] = dp[i-1][0] + 1;

        for(int i = 1; i <= m; ++i){
            for(int j = 1;j <= n; ++j){
                //当前位置字符相同，则不需要任何操作
                if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                    //取经过插入、删除、替换操作的最优操作次数
                else dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
            }
        }

        return dp[m][n];
    }
}