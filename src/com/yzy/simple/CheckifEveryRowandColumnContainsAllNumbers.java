package com.yzy.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: CheckifEveryRowandColumnContainsAllNumbers
 * Description:
 * 对一个大小为 n x n 的矩阵而言，如果其每一行和每一列都包含从 1 到 n 的 全部 整数（含 1 和 n），则认为该矩阵是一个 有效 矩阵。
 * 给你一个大小为 n x n 的整数矩阵 matrix ，请你判断矩阵是否为一个有效矩阵：如果是，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[3,1,2],[2,3,1]]
 * 输出：true
 * 解释：在此例中，n = 3 ，每一行和每一列都包含数字 1、2、3 。
 * 因此，返回 true 。
 * 示例 2：
 * 输入：matrix = [[1,1,1],[1,2,3],[1,2,3]]
 * 输出：false
 * 解释：在此例中，n = 3 ，但第一行和第一列不包含数字 2 和 3 。
 * 因此，返回 false 。
 * @author Administrator
 * @date 2023-5-6 8:33
 */
public class CheckifEveryRowandColumnContainsAllNumbers {
    public static void main(String[] args) {

    }

    public boolean checkValid(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        Set<Integer> set = new HashSet();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (set.contains(matrix[i][j])) return false;
                set.add(matrix[i][j]);
            }
            set.clear();
        }
        set.clear();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (set.contains(matrix[j][i])) return false;
                set.add(matrix[j][i]);
            }
            set.clear();
        }
        return true;
    }
}
