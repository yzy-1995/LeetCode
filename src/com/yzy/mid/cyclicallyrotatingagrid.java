package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/02/20 23:42
 * @Description
 * 给你一个大小为 m x n 的整数矩阵 grid​​​ ，其中 m 和 n 都是 偶数 ；另给你一个整数 k 。
 *
 * 矩阵由若干层组成，如下图所示，每种颜色代表一层：
 *
 *
 *
 * 矩阵的循环轮转是通过分别循环轮转矩阵中的每一层完成的。在对某一层进行一次循环旋转操作时，层中的每一个元素将会取代其 逆时针 方向的相邻元素。轮转示例如下：
 *
 *
 * 返回执行 k 次循环轮转操作后的矩阵。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[40,10],[30,20]], k = 1
 * 输出：[[10,20],[40,30]]
 * 解释：上图展示了矩阵在执行循环轮转操作时每一步的状态。
 * 示例 2：
 *
 *
 * 输入：grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], k = 2
 * 输出：[[3,4,8,12],[2,11,10,16],[1,7,6,15],[5,9,13,14]]
 * 解释：上图展示了矩阵在执行循环轮转操作时每一步的状态。
 * @Version 1.0
 */
public class cyclicallyrotatingagrid {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int circle = Math.min(m, n) / 2;
        for (int i = 0; i < circle; i++) {
            int round = k % (2 * (m + n) - 4 - 8 * i);
            while (round-- > 0) {
                int x = i, y = i;
                char forward = 'e';
                int init = grid[i][i];
                while (true) {
                    if (forward == 's') {
                        if (x == m - i - 1) forward = 'w';
                        else grid[x][y] = grid[++x][y];
                    }
                    if (forward == 'e') {
                        if (y == n - i - 1) forward = 's';
                        else grid[x][y] = grid[x][++y];
                    }
                    if (forward == 'n') {
                        if (x == i) {
                            grid[x + 1][y] = init;
                            break;
                        } else grid[x][y] = grid[--x][y];
                    }
                    if (forward == 'w') {
                        if (y == i) forward = 'n';
                        else grid[x][y] = grid[x][--y];
                    }
                }
            }
        }
        return grid;
    }
}