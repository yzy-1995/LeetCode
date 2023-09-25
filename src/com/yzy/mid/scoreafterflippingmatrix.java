package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/26 00:17
 * @Description
 * 给你一个大小为 m x n 的二元矩阵 grid ，矩阵中每个元素的值为 0 或 1 。
 *
 * 一次 移动 是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 *
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的 得分 就是这些数字的总和。
 *
 * 在执行任意次 移动 后（含 0 次），返回可能的最高分数。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 * 示例 2：
 *
 * 输入：grid = [[0]]
 * 输出：1
 * @Version 1.0
 */
public class scoreafterflippingmatrix {
    public int matrixScore(int[][] A) {
        int r=A.length,c=A[0].length;
        boolean[] cb = new boolean[r];
        for(int i=0;i<r;i++) cb[i]=A[i][0]==0;
        int ans = r << c-1;
        for(int i=1,cnt = 0;i<c;i++,cnt =0){
            for(int j=0;j<r;j++)
                if(cb[j] ^ (A[j][i]==0)) cnt++;
            cnt = Math.max(cnt,r-cnt);
            ans+=cnt<<(c-i-1);
        }
        return ans;
    }
}