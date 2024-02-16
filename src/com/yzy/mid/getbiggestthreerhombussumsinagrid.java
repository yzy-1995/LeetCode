package com.yzy.mid;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/02/15 15:22
 * @Description
 * 给你一个 m x n 的整数矩阵 grid 。
 *
 * 菱形和 指的是 grid 中一个正菱形 边界 上的元素之和。本题中的菱形必须为正方形旋转45度，且四个角都在一个格子当中。下图是四个可行的菱形，每个菱形和应该包含的格子都用了相应颜色标注在图中。
 *
 *
 *
 *
 * 注意，菱形可以是一个面积为 0 的区域，如上图中右下角的紫色菱形所示。
 *
 * 请你按照 降序 返回 grid 中三个最大的 互不相同的菱形和 。如果不同的和少于三个，则将它们全部返回。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[3,4,5,1,3],[3,3,4,2,3],[20,30,200,40,10],[1,5,5,4,1],[4,3,2,2,5]]
 * 输出：[228,216,211]
 * 解释：最大的三个菱形和如上图所示。
 * - 蓝色：20 + 3 + 200 + 5 = 228
 * - 红色：200 + 2 + 10 + 4 = 216
 * - 绿色：5 + 200 + 4 + 2 = 211
 * 示例 2：
 *
 *
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[20,9,8]
 * 解释：最大的三个菱形和如上图所示。
 * - 蓝色：4 + 2 + 6 + 8 = 20
 * - 红色：9 （右下角红色的面积为 0 的菱形）
 * - 绿色：8 （下方中央面积为 0 的菱形）
 * 示例 3：
 *
 * 输入：grid = [[7,7,7]]
 * 输出：[7]
 * 解释：所有三个可能的菱形和都相同，所以返回 [7] 。
 * @Version 1.0
 */
public class getbiggestthreerhombussumsinagrid {
    Set<Integer> set = new HashSet<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int[] getBiggestThree(int[][] grid) {
        //前缀和 + 优先队列
        int n = grid.length, m = grid[0].length;
        int[][] sums1 = new int[n][m], sums2 = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sums1[i][j] = grid[i][j];
                sums2[i][j] = grid[i][j];
                if(i-1 >= 0 && j+1 < m) sums1[i][j] += sums1[i-1][j+1];
                if(i-1 >= 0 && j-1 >= 0) sums2[i][j] += sums2[i-1][j-1];
            }
        }
        for(int i=0; i<3; i++) pq.add(0);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                max(sums1,sums2,i,j,n,m,grid);
            }
        }
        while(!pq.isEmpty() && pq.peek() == 0) pq.poll();
        int[] arr = new int[pq.size() >= 3 ? 3 : pq.size()];
        int i = arr.length-1;
        while(i >= 0) arr[i--] = pq.poll();
        return arr;
    }
    private void max(int[][] sums1, int[][] sums2, int i, int j,int n, int m, int[][] grid){
        int l = grid[i][j] , k = 1;
        if(!set.contains(l) && l > pq.peek()){
            pq.poll();
            pq.add(l);
            set.add(l);
        }
        while(i-k >= 0 && i+k < n && j-k >=0 && j+k < m){
            int l1 = i-k-1 < 0 ? sums1[i][j-k] : sums1[i][j-k] - sums1[i-k-1][j+1];
            int l2 = j+k+1 >= m ? sums1[i+k][j] : sums1[i+k][j] - sums1[i-1][j+k+1];
            int l3 = i-k-1 < 0 ? sums2[i][j+k] : sums2[i][j+k] - sums2[i-k-1][j-1];
            int l4 = j-k-1 < 0 ? sums2[i+k][j] : sums2[i+k][j] - sums2[i-1][j-k-1];
            int l5 = grid[i-k][j]+grid[i+k][j]+grid[i][j-k]+grid[i][j+k];
            l = l1+l2+l3+l4-l5;
            if(!set.contains(l) && l > pq.peek()){
                pq.poll();
                pq.add(l);
                set.add(l);
            }
            k++;
        }
    }
}