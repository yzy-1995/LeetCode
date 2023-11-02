package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/03 02:23
 * @Description
 * 给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：9
 * 示例 2：
 *
 * 输入：grid = [[1,1,0,0]]
 * 输出：1
 * @Version 1.0
 */
public class largest1borderedsquare {
    public int largest1BorderedSquare(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int maxSize = Math.min(n, m);
        int res = 0;
        for(int i = 1; i <= maxSize; ++i) {
            if(isOk(grid, i)) {
                res = i * i;
            }
        }
        return res;
    }

    public boolean isOk(int[][] grid, int size) {
        int n = grid.length, m = grid[0].length;
        for(int i = 0; i <= n - size; ++i) {
            for(int j = 0; j <= m - size; ++j) {
                boolean flag = true;
                for(int y = j; y < j + size; ++y) {
                    if(grid[i][y] == 0 || grid[i + size - 1][y] == 0) {
                        flag = false;
                    }
                }
                for(int x = i; x < i + size; ++x) {
                    if(grid[x][j] == 0 || grid[x][j + size - 1] == 0) {
                        flag = false;
                    }
                }
                if(flag) {
                    return true;
                }
            }
        }
        return false;
    }
}