package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/31 00:03
 * @Description
 * 给你一个无向图，整数 n 表示图中节点的数目，edges 数组表示图中的边，其中 edges[i] = [ui, vi] ，表示 ui 和 vi 之间有一条无向边。
 *
 * 一个 连通三元组 指的是 三个 节点组成的集合且这三个点之间 两两 有边。
 *
 * 连通三元组的度数 是所有满足此条件的边的数目：一个顶点在这个三元组内，而另一个顶点不在这个三元组内。
 *
 * 请你返回所有连通三元组中度数的 最小值 ，如果图中没有连通三元组，那么返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 6, edges = [[1,2],[1,3],[3,2],[4,1],[5,2],[3,6]]
 * 输出：3
 * 解释：只有一个三元组 [1,2,3] 。构成度数的边在上图中已被加粗。
 * 示例 2：
 *
 *
 * 输入：n = 7, edges = [[1,3],[4,1],[4,3],[2,5],[5,6],[6,7],[7,5],[2,6]]
 * 输出：0
 * 解释：有 3 个三元组：
 * 1) [1,4,3]，度数为 0 。
 * 2) [2,5,6]，度数为 2 。
 * 3) [5,6,7]，度数为 2 。
 * @Version 1.0
 */
public class minimumdegreeofaconnectedtrioinagraph {
    public int minTrioDegree(int n, int[][] edges) {
        boolean[][] matrix = new boolean[n][n];
        short[] degree = new short[n];

        for (int[] e : edges) {
            matrix[e[0]-1][e[1]-1] = true;
            matrix[e[1]-1][e[0]-1] = true;

            degree[e[0]-1]++;
            degree[e[1]-1]++;
        }

        int minDegree = Integer.MAX_VALUE;
        for (int i = 0; i < n-2; i++) {
            if (degree[i] < 2) continue;

            for (int j = i+1; j < n-1; j++) {
                if (degree[j] < 2) continue;
                if (!matrix[j][i]) continue;

                for (int k = j+1; k < n; k++) {
                    boolean is3 = matrix[i][k] && matrix[j][k];
                    if (!is3) continue;

                    minDegree = Math.min(minDegree, degree[i]+degree[j]+degree[k] - 6);
                }
            }
        }
        if (minDegree == Integer.MAX_VALUE) return -1;
        return minDegree;
    }
}