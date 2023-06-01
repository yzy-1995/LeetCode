package com.yzy.mid;

/**
 * ClassName: SpiralMatrixii
 * Description:
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 *
 * @author Administrator
 * @date 2023-5-23 10:39
 */
public class SpiralMatrixii {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int index = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int i = 0, j = 0, k = 1; k <= n * n; ++k) {
            res[i][j] = k;
            int x = i + dx[index];
            int y = j + dy[index];
            if (x < 0 || x >= n || y < 0 || y >= n || res[x][y] != 0) {
                index = (index + 1) % 4;
            }
            i += dx[index];
            j += dy[index];
        }
        return res;
    }
}
