package com.yzy.mid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/25 20:11
 * @Description
 * 矩阵对角线 是一条从矩阵最上面行或者最左侧列中的某个元素开始的对角线，沿右下方向一直到矩阵末尾的元素。例如，矩阵 mat 有 6 行 3 列，从 mat[2][0] 开始的 矩阵对角线 将会经过 mat[2][0]、mat[3][1] 和 mat[4][2] 。
 *
 * 给你一个 m * n 的整数矩阵 mat ，请你将同一条 矩阵对角线 上的元素按升序排序后，返回排好序的矩阵。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
 * 输出：[[1,1,1,1],[1,2,2,2],[1,2,3,3]]
 * 示例 2：
 *
 * 输入：mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]
 * 输出：[[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]]
 * @Version 1.0
 */
public class sortthematrixdiagonally {
    public int[][] diagonalSort(int[][] mat) {
        for(int i=0;i<mat.length-1;i++){
            //从[i,0]开始
            List<int[]> idx=new ArrayList<>();
            List<Integer> num=new ArrayList<>();
            for(int k=0;k<mat[0].length&&i+k<mat.length;k++){
                idx.add(new int[]{i+k,k});
                num.add(mat[i+k][k]);
            }
            Collections.sort(num);
            for(int k=0;k<num.size();k++){
                int p[]=idx.get(k);
                mat[p[0]][p[1]]=num.get(k);
            }
        }
        for(int j=1;j<mat[0].length-1;j++){
            //从[0,j]开始
            List<int[]> idx=new ArrayList<>();
            List<Integer> num=new ArrayList<>();
            for(int k=0;k<mat.length&&j+k<mat[0].length;k++){
                idx.add(new int[]{k,j+k});
                num.add(mat[k][j+k]);
            }
            Collections.sort(num);
            for(int k=0;k<num.size();k++){
                int p[]=idx.get(k);
                mat[p[0]][p[1]]=num.get(k);
            }
        }
        return mat;
    }
}