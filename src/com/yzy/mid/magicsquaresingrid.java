package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/20 00:03
 * @Description
 * 3 x 3 的幻方是一个填充有 从 1 到 9  的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 *
 * 给定一个由整数组成的row x col 的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入: grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]
 * 输出: 1
 * 解释:
 * 下面的子矩阵是一个 3 x 3 的幻方：
 *
 * 而这一个不是：
 *
 * 总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
 * 示例 2:
 *
 * 输出: grid = [[8]]
 * 输入: 0
 * @Version 1.0
 */
public class magicsquaresingrid {
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int cnt = 0;
        for (int i = 0; i <= row - 3; i++) {
            for (int j = 0; j <= col - 3; j++) {
                if (isMagicSquare(grid, i, j)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean isMagicSquare(int[][] grid, int x, int y) {
        if (grid[x + 1][y + 1] != 5) {
            return false;
        }
        // 11111111111111111111110000000001
        int exists = ~(0xff << 2 | 2);
        for (int i = 0; i < 3; i++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j = 0; j < 3; j++) {
                int num = grid[x + i][y + j];
                if ((exists & 1 << num) != 0) {
                    return false;
                }
                exists |= 1 << num;
                sum1 += num;
                sum2 += grid[x + j][y + i];
            }
            if (sum1 != 15 || sum2 != 15) {
                return false;
            }
        }
        return grid[x][y] + grid[x + 2][y + 2] == 10 && grid[x][y + 2] + grid[x + 2][y] == 10;
    }
}