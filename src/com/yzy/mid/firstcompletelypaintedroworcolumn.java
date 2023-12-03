package com.yzy.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/01 10:46
 * @Description
 * 给你一个下标从 0 开始的整数数组 arr 和一个 m x n 的整数 矩阵 mat 。arr 和 mat 都包含范围 [1，m * n] 内的 所有 整数。
 *
 * 从下标 0 开始遍历 arr 中的每个下标 i ，并将包含整数 arr[i] 的 mat 单元格涂色。
 *
 * 请你找出 arr 中在 mat 的某一行或某一列上都被涂色且下标最小的元素，并返回其下标 i 。
 *
 *
 *
 * 示例 1：
 *
 * image explanation for example 1
 * 输入：arr = [1,3,4,2], mat = [[1,4],[2,3]]
 * 输出：2
 * 解释：遍历如上图所示，arr[2] 在矩阵中的第一行或第二列上都被涂色。
 * 示例 2：
 *
 * image explanation for example 2
 * 输入：arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
 * 输出：3
 * 解释：遍历如上图所示，arr[3] 在矩阵中的第二列上都被涂色。
 * @Version 1.0
 */
public class firstcompletelypaintedroworcolumn {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer,int[]> map=new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++){
                map.put(mat[i][j],new int[]{i,j});
            }
        }
        int[] index=new int[mat.length];
        int[] indey=new int[mat[0].length];
        for (int i = 0; i < arr.length; i++) {
            if (++index[map.get(arr[i])[0]]==mat[0].length||++indey[map.get(arr[i])[1]]==mat.length){
                return i;
            }
        }
        return arr.length-1;
    }
}