package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/16 01:07
 * @Description
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * 输出：15
 * 解释：
 * 边长为 1 的正方形有 10 个。
 * 边长为 2 的正方形有 4 个。
 * 边长为 3 的正方形有 1 个。
 * 正方形的总数 = 10 + 4 + 1 = 15.
 * 示例 2：
 *
 * 输入：matrix =
 * [
 *   [1,0,1],
 *   [1,1,0],
 *   [1,1,0]
 * ]
 * 输出：7
 * 解释：
 * 边长为 1 的正方形有 6 个。
 * 边长为 2 的正方形有 1 个。
 * 正方形的总数 = 6 + 1 = 7.
 * @Version 1.0
 */
public class countsquaresubmatriceswithallones {
    public int countSquares(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int dp[][]=new int[row][col];
        int count=0;
        for(int i=0;i<row;i++){
            if(matrix[i][0]==1){
                dp[i][0]=1;
                count++;
            }
        }
        for(int j=1;j<col;j++){
            if(matrix[0][j]==1){
                dp[0][j]=1;
                count++;
            }
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][j]==1){
                    dp[i][j]=1;
                    if(dp[i-1][j]!=0&&dp[i][j-1]!=0&&dp[i-1][j-1]!=0){
                        dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    }
                    count+=dp[i][j];
                }
            }
        }
        return count;
    }
}