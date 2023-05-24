package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: SetMatrixZeroes
 * Description:
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 示例 2：
 * <p>
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * @author Administrator
 * @date 2023-5-24 10:48
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 1;
                }
            }
        }
        List<Integer> ListM = new ArrayList<>();
        List<Integer> ListN = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (res[i][j] == 1) {
                    if (!ListM.contains(i)) {
                        ListM.add(i);
                        for (int k = 0; k < n; k++) {
                            matrix[i][k] = 0;
                        }
                    }
                    if (!ListN.contains(j)) {
                        ListN.add(j);
                        for (int k = 0; k < n; k++) {
                            matrix[k][j] = 0;
                        }
                    }
                }
            }
        }
    }
}
