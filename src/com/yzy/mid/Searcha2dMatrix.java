package com.yzy.mid;

/**
 * ClassName: Aearcha2dMatrix
 * Description:
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *
 * @author Administrator
 * @date 2023-5-24 11:10
 */
public class Searcha2dMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(matrix, 13));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int a = 0;
        int b = n - 1;
        while (a >= 0 && a < m && b >= 0 && b < n) {
            if (matrix[a][b] == target) {
                return true;
            }
            if (matrix[a][b] > target) {
                b--;
            }else{
                a++;
            }
        }
        return false;
    }
}
