package com.yzy.mid;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/10 00:08
 * @Description
 * 有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
 *
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
 *
 *
 *
 * 示例 1：
 *
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * 输出: 200
 * 解释:
 * 城市航班图如下
 *
 *
 * 从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
 * 示例 2：
 *
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * 输出: 500
 * 解释:
 * 城市航班图如下
 *
 *
 * 从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。
 * @Version 1.0
 */
public class cheapestflightswithinkstops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] graph = new int[n][n];
        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        for(int[] flight : flights){
            graph[flight[0]][flight[1]] = flight[2];
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{k, src, 0});
        while(!queue.isEmpty()){
            int[] info = queue.poll();
            if(info[0] >= 0 && graph[info[1]].length != 0){
                int[] tmpDst = graph[info[1]];
                for(int i = 0; i < tmpDst.length; i++){
                    if(tmpDst[i] == 0) continue;
                    int nextPrice = info[2] + tmpDst[i];
                    if(nextPrice >= result[i]){
                        continue;
                    }
                    result[i] = nextPrice;
                    queue.offer(new int[]{info[0] - 1, i, nextPrice});
                }
            }
        }
        return result[dst] == Integer.MAX_VALUE ? -1 : result[dst];
    }
}