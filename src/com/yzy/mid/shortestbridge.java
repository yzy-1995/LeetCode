package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/10 23:09
 * @Description 给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。
 * <p>
 * 岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。
 * <p>
 * 你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。
 * <p>
 * 返回必须翻转的 0 的最小数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[0,1],[1,0]]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：grid = [[0,1,0],[0,0,0],[0,0,1]]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * 输出：1
 * @Version 1.0
 */
public class shortestbridge {
    public int shortestBridge(int[][] grid) {
        boolean flag = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        // 找到另一个岛屿向外扩散，每个都上下左右扩散，第一次遇到2即第一个岛屿就是答案
        int res = 0;
        while (true) {
            List<Integer[]> list = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    // 这里拿到所有的岛屿
                    if (grid[i][j] == 1) {
                        list.add(new Integer[]{i, j});
                    }
                }
            }
            // 遍历这些岛屿进行扩散
            int size = list.size();
            for (int k = 0; k < size; k++) {
                Integer[] temp = list.get(k);
                int i = temp[0];
                int j = temp[1];
                if (grid[i][j] == 1) {//是我们的岛屿就向外扩散
                    //左边
                    if (j - 1 >= 0) {
                        if (grid[i][j - 1] == 2) return res;
                        grid[i][j - 1] = 1;
                    }
                    //右边
                    if (j + 1 < grid[0].length) {
                        if (grid[i][j + 1] == 2) return res;
                        grid[i][j + 1] = 1;
                    }
                    //下边
                    if (i + 1 < grid.length) {
                        if (grid[i + 1][j] == 2) return res;
                        grid[i + 1][j] = 1;
                    }
                    //上边
                    if (i - 1 >= 0) {
                        if (grid[i - 1][j] == 2) return res;
                        grid[i - 1][j] = 1;
                    }
                }
            }
            res++;/* 扩散次数+1 */
        }
    }

    // 染色
    public void dfs(int[][] arr, int i, int j) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] != 1) return;
        arr[i][j] = 2;
        dfs(arr, i - 1, j);
        dfs(arr, i, j - 1);
        dfs(arr, i + 1, j);
        dfs(arr, i, j + 1);
    }
}