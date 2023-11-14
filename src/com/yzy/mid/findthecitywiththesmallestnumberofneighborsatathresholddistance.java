package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/14 00:02
 * @Description
 * 有 n 个城市，按从 0 到 n-1 编号。给你一个边数组 edges，其中 edges[i] = [fromi, toi, weighti] 代表 fromi 和 toi 两个城市之间的双向加权边，距离阈值是一个整数 distanceThreshold。
 *
 * 返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为 distanceThreshold 的城市。如果有多个这样的城市，则返回编号最大的城市。
 *
 * 注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
 * 输出：3
 * 解释：城市分布图如上。
 * 每个城市阈值距离 distanceThreshold = 4 内的邻居城市分别是：
 * 城市 0 -> [城市 1, 城市 2]
 * 城市 1 -> [城市 0, 城市 2, 城市 3]
 * 城市 2 -> [城市 0, 城市 1, 城市 3]
 * 城市 3 -> [城市 1, 城市 2]
 * 城市 0 和 3 在阈值距离 4 以内都有 2 个邻居城市，但是我们必须返回城市 3，因为它的编号最大。
 * 示例 2：
 *
 *
 *
 * 输入：n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]], distanceThreshold = 2
 * 输出：0
 * 解释：城市分布图如上。
 * 每个城市阈值距离 distanceThreshold = 2 内的邻居城市分别是：
 * 城市 0 -> [城市 1]
 * 城市 1 -> [城市 0, 城市 4]
 * 城市 2 -> [城市 3, 城市 4]
 * 城市 3 -> [城市 2, 城市 4]
 * 城市 4 -> [城市 1, 城市 2, 城市 3]
 * 城市 0 在阈值距离 2 以内只有 1 个邻居城市。
 * @Version 1.0
 */
public class findthecitywiththesmallestnumberofneighborsatathresholddistance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //初始化二维数组保存路径信息
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //-1 表示不存在联通路径
                grid[i][j] = (i == j?0:-1);
            }
        }
        for (int i = 0; i < edges.length; i++) {
            grid[edges[i][0]][edges[i][1]] = edges[i][2];
            grid[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        //count保存从0到n-1个节点的阈值距离内邻居城市数量
        int[] count = new int[n];
        //进行多次dijkstra求最短路径
        for (int i = 0; i < n; i++) {
            int mark = i;
            int[] dis = new int[n];
            boolean[] is = new boolean[n];
            Arrays.fill(dis,Integer.MAX_VALUE);
            Arrays.fill(is,false);
            dis[mark] = 0;
            is[mark] = true;
            for(int m = 0;m != n;m++){
                for (int j = 0; j < dis.length; j++) {
                    if(grid[mark][j] != -1) dis[j] = Math.min(dis[j],grid[mark][j] + dis[mark]);
                }
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < dis.length; j++) {
                    if(!is[j]){
                        if(dis[j] < min){
                            min = dis[j];
                            mark = j;
                        }
                    }
                }
                is[mark] = true;
            }
            for (int i1 = 0; i1 < dis.length; i1++) {
                //将节点本身也算入进count数组不影响最终结果
                if(dis[i1] <= distanceThreshold) count[i] ++;
            }
        }

        int min = Integer.MAX_VALUE;
        int mark = -1;
        for (int i = 0; i < count.length; i++) {
            //找到邻居城市最少且标号最大的城市
            if(count[i] <= min){
                min = count[i];
                mark = i;
            }
        }
        return mark;
    }
}