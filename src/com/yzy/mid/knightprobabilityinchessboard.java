package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/28 00:13
 * @Description
 * 在一个 n x n 的国际象棋棋盘上，一个骑士从单元格 (row, column) 开始，并尝试进行 k 次移动。行和列是 从 0 开始 的，所以左上单元格是 (0,0) ，右下单元格是 (n - 1, n - 1) 。
 *
 * 象棋骑士有8种可能的走法，如下图所示。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格。
 *
 *
 *
 * 每次骑士要移动时，它都会随机从8种可能的移动中选择一种(即使棋子会离开棋盘)，然后移动到那里。
 *
 * 骑士继续移动，直到它走了 k 步或离开了棋盘。
 *
 * 返回 骑士在棋盘停止移动后仍留在棋盘上的概率 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: n = 3, k = 2, row = 0, column = 0
 * 输出: 0.0625
 * 解释: 有两步(到(1,2)，(2,1))可以让骑士留在棋盘上。
 * 在每一个位置上，也有两种移动可以让骑士留在棋盘上。
 * 骑士留在棋盘上的总概率是0.0625。
 * 示例 2：
 *
 * 输入: n = 1, k = 0, row = 0, column = 0
 * 输出: 1.00000
 * @Version 1.0
 */
public class knightprobabilityinchessboard {
    int[][] move = { { 1, 2 }, { 1, -2 }, { 2, 1 }, { 2, -1 }, { -1, 2 }, { -1, -2 }, { -2, 1 }, { -2, -1 } };
    double[][][] dp;

    public double knightProbability(int N, int K, int r, int c) {
        dp = new double[N][N][K + 1];
        if (K == 0)
            return 1;
        return dfs(N, K, r, c);
    }

    private double dfs(int N, int K, int r, int c) {
        if (dp[r][c][K] != 0)
            return dp[r][c][K];
        double res = 0;
        for (int i = 0; i < 8; i++) {
            int r1 = r + move[i][0];
            int c1 = c + move[i][1];
            if (r1 >= 0 && r1 < N && c1 >= 0 && c1 < N) {
                res += (K == 1 ? 1 : dfs(N, K - 1, r1, c1));
            }
        }
        return dp[r][c][K] = res / 8;
    }
}