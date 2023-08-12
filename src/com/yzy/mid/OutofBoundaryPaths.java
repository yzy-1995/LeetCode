package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/11 00:05
 * @Description
 * 给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。
 *
 * 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 109 + 7 取余 后的结果。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * 输出：6
 * 示例 2：
 *
 *
 * 输入：m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
 * 输出：12
 * @Version 1.0
 */
public class OutofBoundaryPaths {
    final int mod = (int) 1e9 + 7;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][][] cache;
    int m;
    int n;

    public int findPaths(int _m, int _n, int maxMove, int startRow, int startColumn) {
        m = _m;
        n = _n;
        cache = new int[m][n][maxMove + 1];
        for (int[][] c : cache) {
            for (int[] ca : c) Arrays.fill(ca, -1);
        }
        dfs(startRow, startColumn, maxMove);
        return Math.max(cache[startRow][startColumn][maxMove], 0);
    }

    int dfs(int x, int y, int step) {
        // 已经出界了，可行
        if (x < 0 || x >= m || y < 0 || y >= n) return 1;
        if (step == 0) return 0;
        if (cache[x][y][step] != -1) return cache[x][y][step];
        int res = 0;
        for (int[] dir : dirs) {
            res += dfs(x + dir[0], y + dir[1], step - 1);
            res %= mod;
        }
        return cache[x][y][step] = res;
    }
}