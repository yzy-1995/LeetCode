package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/02/17 00:35
 * @Description
 * 一个 k x k 的 幻方 指的是一个 k x k 填满整数的方格阵，且每一行、每一列以及两条对角线的和 全部相等 。幻方中的整数 不需要互不相同 。显然，每个 1 x 1 的方格都是一个幻方。
 *
 * 给你一个 m x n 的整数矩阵 grid ，请你返回矩阵中 最大幻方 的 尺寸 （即边长 k）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[7,1,4,5,6],[2,5,1,6,4],[1,5,4,3,2],[1,2,7,3,4]]
 * 输出：3
 * 解释：最大幻方尺寸为 3 。
 * 每一行，每一列以及两条对角线的和都等于 12 。
 * - 每一行的和：5+1+6 = 5+4+3 = 2+7+3 = 12
 * - 每一列的和：5+5+2 = 1+4+7 = 6+3+3 = 12
 * - 对角线的和：5+4+3 = 6+4+2 = 12
 * 示例 2：
 *
 *
 * 输入：grid = [[5,1,3,1],[9,3,3,1],[1,3,3,8]]
 * 输出：2
 * @Version 1.0
 */
public class largestmagicsquare {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int k = Math.min(m, n);
        int[][] prevSumRow = new int[m][n], prevSumCol = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                prevSumRow[i][j] = (j == 0? 0: prevSumRow[i][j - 1]) + grid[i][j];
                prevSumCol[i][j] = (i == 0? 0: prevSumCol[i - 1][j]) + grid[i][j];
            }
        }
        outer:for(; k >= 1; k--){
            for(int i = 0; i <= m - k; i++){
                for(int j = 0; j <= n - k; j++){
                    int diagSum = grid[i][j], antiDiagSum = grid[i][j + k - 1];
                    boolean rowIsValid = true, colIsValid = true;
                    int rowSum = prevSumRow[i][j + k - 1] - (j == 0? 0: prevSumRow[i][j - 1]);
                    int colSum = prevSumCol[i + k - 1][j] - (i == 0? 0: prevSumCol[i - 1][j]);
                    for(int d = 1; d < k; d++){
                        if(prevSumRow[i + d][j + k - 1] - (j == 0? 0: prevSumRow[i + d][j - 1]) != rowSum){
                            rowIsValid = false;      // 当前行的和与首行不相等，无法构成幻方
                            break;
                        }
                        if(prevSumCol[i + k - 1][j + d] - (i == 0? 0: prevSumCol[i - 1][j + d]) != colSum){
                            colIsValid = false;      // 当前列的和与首列不相等，无法构成幻方
                            break;
                        }
                        // 累加主对角线和副对角线的和
                        diagSum += grid[i + d][j + d];
                        antiDiagSum += grid[i + d][j + k - 1 - d];
                    }
                    if(rowIsValid && colIsValid && diagSum == antiDiagSum && rowSum == colSum && colSum == diagSum){
                        break outer;     // 行和、列和、对角线和均相等才退出循环
                    }
                }
            }
        }
        return k;
    }
}