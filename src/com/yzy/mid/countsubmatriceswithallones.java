package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/24 00:31
 * @Description
 * 给你一个 m x n 的二进制矩阵 mat ，请你返回有多少个 子矩形 的元素全部都是 1 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：mat = [[1,0,1],[1,1,0],[1,1,0]]
 * 输出：13
 * 解释：
 * 有 6 个 1x1 的矩形。
 * 有 2 个 1x2 的矩形。
 * 有 3 个 2x1 的矩形。
 * 有 1 个 2x2 的矩形。
 * 有 1 个 3x1 的矩形。
 * 矩形数目总共 = 6 + 2 + 3 + 1 + 1 = 13 。
 * 示例 2：
 *
 *
 *
 * 输入：mat = [[0,1,1,0],[0,1,1,1],[1,1,1,0]]
 * 输出：24
 * 解释：
 * 有 8 个 1x1 的子矩形。
 * 有 5 个 1x2 的子矩形。
 * 有 2 个 1x3 的子矩形。
 * 有 4 个 2x1 的子矩形。
 * 有 2 个 2x2 的子矩形。
 * 有 2 个 3x1 的子矩形。
 * 有 1 个 3x2 的子矩形。
 * 矩形数目总共 = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24 。
 * @Version 1.0
 */
public class countsubmatriceswithallones {
    public int numSubmat(int[][] mat) {
        int ans=0;
        int m=mat.length;
        int n=mat[0].length;
        int maxZ[][]=new int[m][n];
        for(int i=0;i<m;i++){
            int maxZuo=0;
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    maxZuo++;
                }
                else{maxZuo=0;}
                maxZ[i][j]=maxZuo;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int rec=150;
                for(int k=i;k>=0;k--){
                    rec=Math.min(rec,maxZ[k][j]);
                    ans+=rec;
                }
            }
        }
        return ans;
    }
}