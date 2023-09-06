package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/07 00:04
 * @Description
 * 在一个 n x n 的矩阵 grid 中，除了在数组 mines 中给出的元素为 0，其他每个元素都为 1。mines[i] = [xi, yi]表示 grid[xi][yi] == 0
 *
 * 返回  grid 中包含 1 的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。
 *
 * 一个 k 阶由 1 组成的 “轴对称”加号标志 具有中心网格 grid[r][c] == 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，由 1 组成的臂。注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入: n = 5, mines = [[4, 2]]
 * 输出: 2
 * 解释: 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
 * 示例 2：
 *
 *
 *
 * 输入: n = 1, mines = [[0, 0]]
 * 输出: 0
 * 解释: 没有加号标志，返回 0 。
 * @Version 1.0
 */
public class largestplussign {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid = new int[n][n];
        for (int i=0;i<n;i++)  Arrays.fill(grid[i],1);
        for (int [] e :mines)
        {
            int x=e[0];int y=e[1];
            grid[x][y]=0;
        }
        int res=0;
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<n;j++)
            {
                if (grid[i][j]==0)continue;
                int up=0;
                int left=0;
                int right=0;
                int down=0;
                for (int k=i;k>=0;k--) if (grid[k][j]==1)up++;else break;
                for (int k=i;k<n;k++) if (grid[k][j]==1)down++;else break;
                for (int k=j;k>=0;k--)if (grid[i][k]==1)left++;else break;
                for (int k=j;k<n;k++) if (grid[i][k]==1)right++;else break;
                int cur=Math.min(up,left);
                int cur2=Math.min(right,down);
                int cur3=Math.min(cur,cur2);
                res=Math.max(res,cur3);
            }
        }
        return res;
    }
}