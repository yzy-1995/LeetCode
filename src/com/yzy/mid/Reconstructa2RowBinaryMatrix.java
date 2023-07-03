package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/06/29 21:54
 * @Description
 * 给你一个 2 行 n 列的二进制数组：
 *
 * 矩阵是一个二进制矩阵，这意味着矩阵中的每个元素不是 0 就是 1。
 * 第 0 行的元素之和为 upper。
 * 第 1 行的元素之和为 lower。
 * 第 i 列（从 0 开始编号）的元素之和为 colsum[i]，colsum 是一个长度为 n 的整数数组。
 * 你需要利用 upper，lower 和 colsum 来重构这个矩阵，并以二维整数数组的形式返回它。
 *
 * 如果有多个不同的答案，那么任意一个都可以通过本题。
 *
 * 如果不存在符合要求的答案，就请返回一个空的二维数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：upper = 2, lower = 1, colsum = [1,1,1]
 * 输出：[[1,1,0],[0,0,1]]
 * 解释：[[1,0,1],[0,1,0]] 和 [[0,1,1],[1,0,0]] 也是正确答案。
 * 示例 2：
 *
 * 输入：upper = 2, lower = 3, colsum = [2,2,1,1]
 * 输出：[]
 * 示例 3：
 *
 * 输入：upper = 5, lower = 5, colsum = [2,1,2,0,1,0,1,2,0,1]
 * 输出：[[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]
 * @Version 1.0
 */
public class Reconstructa2RowBinaryMatrix {

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 1) sum1++;
            if (colsum[i] == 2) sum2++;
        }
        upper -= sum2;
        lower -= sum2;
        if (upper>=0 && lower>=0 && lower+upper==sum1){
            List<Integer> upperList = new ArrayList<>();
            List<Integer> lowerList = new ArrayList<>();
            for (int i = 0; i < colsum.length; i++) {
                if (colsum[i]==2){
                    upperList.add(1);
                    lowerList.add(1);
                } else if (colsum[i]==1) {
                    if (upper==0 && lower>0){
                        upperList.add(0);
                        lowerList.add(1);
                        lower--;
                    }
                    if (upper>0){
                        upperList.add(1);
                        lowerList.add(0);
                        upper--;
                    }
                }else {
                    upperList.add(0);
                    lowerList.add(0);
                }
            }
            return new ArrayList<List<Integer>>(){{add(upperList);add(lowerList);}};
        }else {
            return new ArrayList<List<Integer>>();
        }
    }
}