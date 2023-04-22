package com.yzy.simple;

/**
 * Description: leetcode892
 * 给你一个 n * n 的网格 grid ，上面放置着一些 1 x 1 x 1 的正方体。每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * 放置好正方体后，任何直接相邻的正方体都会互相粘在一起，形成一些不规则的三维形体。
 * 请你返回最终这些形体的总表面积。
 * 注意：每个形体的底面也需要计入表面积中。
 * 示例 1：
 * 输入：grid = [[1,2],[3,4]]
 * 输出：34
 * 示例 2：
 * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 示例 3：
 * 输入：grid = [[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 *
 * @author yzy15
 * @date 2023/04/22 12:05
 **/
public class SurfaceAreaof3DShapes {
    public static void main(String[] args) {

    }

    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int totalSurfaceArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    totalSurfaceArea += grid[i][j] * 4 + 2; // 计算当前柱体的表面积

                    // 检查左侧和上侧是否有相邻的柱体，如果有则减去重叠的表面积
                    if (i > 0) {
                        totalSurfaceArea -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
                    }
                    if (j > 0) {
                        totalSurfaceArea -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
                    }
                }
            }
        }

        return totalSurfaceArea;
    }
}
