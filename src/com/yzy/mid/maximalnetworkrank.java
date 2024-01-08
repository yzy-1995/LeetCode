package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/09 00:14
 * @Description
 * n 座城市和一些连接这些城市的道路 roads 共同组成一个基础设施网络。每个 roads[i] = [ai, bi] 都表示在城市 ai 和 bi 之间有一条双向道路。
 *
 * 两座不同城市构成的 城市对 的 网络秩 定义为：与这两座城市 直接 相连的道路总数。如果存在一条道路直接连接这两座城市，则这条道路只计算 一次 。
 *
 * 整个基础设施网络的 最大网络秩 是所有不同城市对中的 最大网络秩 。
 *
 * 给你整数 n 和数组 roads，返回整个基础设施网络的 最大网络秩 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
 * 输出：4
 * 解释：城市 0 和 1 的网络秩是 4，因为共有 4 条道路与城市 0 或 1 相连。位于 0 和 1 之间的道路只计算一次。
 * 示例 2：
 *
 *
 *
 * 输入：n = 5, roads = [[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]
 * 输出：5
 * 解释：共有 5 条道路与城市 1 或 2 相连。
 * 示例 3：
 *
 * 输入：n = 8, roads = [[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]
 * 输出：5
 * 解释：2 和 5 的网络秩为 5，注意并非所有的城市都需要连接起来。
 * @Version 1.0
 */
public class maximalnetworkrank {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] res = new int[n][2];
        for(int i=0; i<n; i++) res[i][0] = i;
        boolean[][] f = new boolean[n][n];
        for(int[] road : roads){
            res[road[0]][1]++;
            res[road[1]][1]++;
            f[road[0]][road[1]] = true;
        }
        Arrays.sort(res,(o1, o2) -> o2[1] - o1[1]);
        for(int i=0; i<n && res[i][1] == res[0][1]; i++){
            for(int j=i+1; j<n && res[j][1] == res[1][1]; j++){
                if(!f[res[i][0]][res[j][0]] && !f[res[j][0]][res[i][0]]) return res[i][1] + res[j][1];
            }
        }
        return res[0][1] + res[1][1] - 1;
    }
}