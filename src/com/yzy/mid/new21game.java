package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/20 00:01
 * @Description
 * 爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
 *
 * 爱丽丝以 0 分开始，并在她的得分少于 k 分时抽取数字。 抽取时，她从 [1, maxPts] 的范围中随机获得一个整数作为分数进行累计，其中 maxPts 是一个整数。 每次抽取都是独立的，其结果具有相同的概率。
 *
 * 当爱丽丝获得 k 分 或更多分 时，她就停止抽取数字。
 *
 * 爱丽丝的分数不超过 n 的概率是多少？
 *
 * 与实际答案误差不超过 10-5 的答案将被视为正确答案。
 *
 *
 * 示例 1：
 *
 * 输入：n = 10, k = 1, maxPts = 10
 * 输出：1.00000
 * 解释：爱丽丝得到一张牌，然后停止。
 * 示例 2：
 *
 * 输入：n = 6, k = 1, maxPts = 10
 * 输出：0.60000
 * 解释：爱丽丝得到一张牌，然后停止。 在 10 种可能性中的 6 种情况下，她的得分不超过 6 分。
 * 示例 3：
 *
 * 输入：n = 21, k = 17, maxPts = 10
 * 输出：0.73278
 * @Version 1.0
 */
public class new21game {
    public double new21Game(int N, int K, int W) {
        double[]dp=new double[N+K+W+1];
        for(int i=0;i<K;i++) dp[i]=0;
        for(int i = K; i <= N; i ++) dp[i] = 1;
        double num=0;
        for(int i = K; i <= K + W - 1; i ++) num += dp[i];
        for(int i = K - 1; i >= 0; i --){
            dp[i] = num / W;
            num -= dp[i + W];
            num += dp[i];
        }
        return dp[0];
    }
}