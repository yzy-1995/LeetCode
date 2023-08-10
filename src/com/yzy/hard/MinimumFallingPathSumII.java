package com.yzy.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.hard
 * @Date 2023/08/10 00:02
 * @Description
 * 给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。
 *
 * 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：13
 * 解释：
 * 所有非零偏移下降路径包括：
 * [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 * [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 * [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 * 下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
 * 示例 2：
 *
 * 输入：grid = [[7]]
 * 输出：7
 * @Version 1.0
 */
public class MinimumFallingPathSumII {
    public int minFallingPathSum(int[][] arr) {
        int len = arr.length;
        if(len==1){
            return arr[0][0];
        }
        List<Integer> list = new ArrayList();
        for(int i=0;i<len;i++){
            list.add(i);
        }
        list.sort((x,y)->arr[0][x]-arr[0][y]);
        int min1 = list.get(0);
        int min2 = list.get(1);
        for(int i=1;i<len;i++){
            for(int j=0;j<len;j++){
                if(j!=min1){
                    arr[i][j] = arr[i][j]+arr[i-1][min1];
                }else{
                    arr[i][j] = arr[i][j]+arr[i-1][min2];
                }
            }
            int idx = i;
            list.sort((x,y)->arr[idx][x]-arr[idx][y]);
            min1 = list.get(0);
            min2 = list.get(1);
        }
        return arr[len-1][min1];
    }
}