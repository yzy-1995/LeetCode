package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/29 00:03
 * @Description
 * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
 *
 * n >= 3
 * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。
 *
 * （回想一下，子序列是从原序列 arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）
 *
 *
 *
 * 示例 1：
 *
 * 输入: arr = [1,2,3,4,5,6,7,8]
 * 输出: 5
 * 解释: 最长的斐波那契式子序列为 [1,2,3,5,8] 。
 * 示例 2：
 *
 * 输入: arr = [1,3,7,11,12,14,18]
 * 输出: 3
 * 解释: 最长的斐波那契式子序列有 [1,11,12]、[3,11,14] 以及 [7,11,18] 。
 * @Version 1.0
 */
public class lengthoflongestfibonaccisubsequence {
    public int lenLongestFibSubseq(int[] A) {
        //从i开始，下一个是j
        int max = 2;
        for(int i = 0; i < A.length; i++){
            for(int j = i + 1; j < A.length; j++){
                int tmpI = A[i];
                int tmpJ = A[j];
                int sum = tmpI + tmpJ;
                int cur = 2;
                //存在
                while(Arrays.binarySearch(A, sum) >= 0){
                    tmpI = tmpJ;
                    tmpJ = sum;
                    sum = tmpI + tmpJ;
                    cur++;
                }
                max = Math.max(max, cur);
            }
        }
        return max < 3 ? 0 : max;
    }
}