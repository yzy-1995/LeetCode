package com.yzy.mid;

import java.util.Arrays;

/**
 * ClassName: MinimumPathSum
 * Description:
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * 示例 1：
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *
 * @author Administrator
 * @date 2023-5-24 9:40
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < grid.length; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 0; j < grid[i].length; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j] + grid[i][j]);
            }
        }
        return dp[grid[0].length - 1];
    }
}
