package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Shift2DGrid
 * Description:
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 *
 * 每次「迁移」操作将会引发下述活动：
 *
 * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[9,1,2],[3,4,5],[6,7,8]]
 * 示例 2：
 *
 *
 *
 * 输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * 输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 * 示例 3：
 *
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * 输出：[[1,2,3],[4,5,6],[7,8,9]]
 * @author Administrator
 * @date 2023-4-27 10:16
 */
public class Shift2DGrid {
    public static void main(String[] args) {

    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int totalElements = m * n;
        int[] linearGrid = new int[totalElements];

        // Convert 2D grid to 1D array
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                linearGrid[index++] = grid[i][j];
            }
        }

        // Shift elements in the 1D array
        k = k % totalElements;
        reverse(linearGrid, 0, totalElements - 1);
        reverse(linearGrid, 0, k - 1);
        reverse(linearGrid, k, totalElements - 1);

        // Convert the shifted 1D array back to a 2D grid
        List<List<Integer>> shiftedGrid = new ArrayList<>();
        index = 0;
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(linearGrid[index++]);
            }
            shiftedGrid.add(row);
        }

        return shiftedGrid;
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
