package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/19 00:00
 * @Description
 * 一个 2D 网格中的 峰值 是指那些 严格大于 其相邻格子(上、下、左、右)的元素。
 *
 * 给你一个 从 0 开始编号 的 m x n 矩阵 mat ，其中任意两个相邻格子的值都 不相同 。找出 任意一个 峰值 mat[i][j] 并 返回其位置 [i,j] 。
 *
 * 你可以假设整个矩阵周边环绕着一圈值为 -1 的格子。
 *
 * 要求必须写出时间复杂度为 O(m log(n)) 或 O(n log(m)) 的算法
 *
 *
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入: mat = [[1,4],[3,2]]
 * 输出: [0,1]
 * 解释: 3 和 4 都是峰值，所以[1,0]和[0,1]都是可接受的答案。
 * 示例 2:
 *
 *
 *
 * 输入: mat = [[10,20,15],[21,30,14],[7,16,32]]
 * 输出: [1,1]
 * 解释: 30 和 32 都是峰值，所以[1,1]和[2,2]都是可接受的答案。
 * @Version 1.0
 */
public class findapeakelementii {
    public int[] findPeakGrid(int[][] mat) {
        int row = 0;
        int col = 0;
        int[] pos = new int[2];
        while(!isPeak(mat, row, col)){
            pos = biggerPeak(mat, row, col);
            row = pos[0];
            col = pos[1];
        }
        return pos;
    }

    public boolean isPeak(int[][] mat, int row, int col) {
        if(col>0 && mat[row][col-1] > mat[row][col]){
            return false;
        }
        if(col < mat[0].length-1 && mat[row][col+1] > mat[row][col]){
            return false;
        }
        if(row > 0 && mat[row-1][col] > mat[row][col]){
            return false;
        }
        if(row < mat.length-1 && mat[row+1][col] > mat[row][col]){
            return false;
        }
        return true;
    }
    public int[] biggerPeak(int[][] mat, int row, int col){
        int[] pos = new int[2];
        int maxV = mat[row][col];
        if(col>0 && mat[row][col-1] > maxV){
            maxV = mat[row][col-1];
            pos[0] = row;
            pos[1] = col-1;
        }
        if(col < mat[0].length-1 && mat[row][col+1] > maxV){
            maxV = mat[row][col+1];
            pos[0] = row;
            pos[1] = col+1;
        }
        if(row > 0 && mat[row-1][col] > maxV){
            maxV = mat[row-1][col];
            pos[0] = row-1;
            pos[1] = col;
        }
        if(row < mat.length-1 && mat[row+1][col] > maxV){
            maxV = mat[row+1][col];
            pos[0] = row+1;
            pos[1] = col;
        }
        return pos;
    }
}