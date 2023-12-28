package com.yzy.mid;

import java.util.LinkedList;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/29 00:03
 * @Description
 * 给你一个 n x n 的二进制网格 grid，每一次操作中，你可以选择网格的 相邻两行 进行交换。
 *
 * 一个符合要求的网格需要满足主对角线以上的格子全部都是 0 。
 *
 * 请你返回使网格满足要求的最少操作次数，如果无法使网格符合要求，请你返回 -1 。
 *
 * 主对角线指的是从 (1, 1) 到 (n, n) 的这些格子。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[0,0,1],[1,1,0],[1,0,0]]
 * 输出：3
 * 示例 2：
 *
 *
 *
 * 输入：grid = [[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]]
 * 输出：-1
 * 解释：所有行都是一样的，交换相邻行无法使网格符合要求。
 * 示例 3：
 *
 *
 *
 * 输入：grid = [[1,0,0],[1,1,0],[1,1,1]]
 * 输出：0
 * @Version 1.0
 */
public class minimumswapstoarrangeabinarygrid {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        LinkedList<Integer> countLink = new LinkedList<>();//统计每一行的0的个数
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if(grid[i][j] != 0){
                    break;
                }
                count++;
            }
            countLink.offer(count);
        }
        int minStep = 0;
        //n-1,最后一行不用判断
        for (int i = 0; i < n - 1; i++) {
            int count = n - i - 1;
            int j = 0;
            while(j < n){
                if(countLink.get(j) >= count){
                    minStep += j - i;
                    countLink.remove(j);
                    countLink.addFirst(0);
                    break;
                }
                j++;
            }
            if(j == n){
                return -1;
            }
        }
        return minStep;
    }
}