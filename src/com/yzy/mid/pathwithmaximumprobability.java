package com.yzy.mid;

import java.util.*;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/26 00:40
 * @Description
 * 给你一个由 n 个节点（下标从 0 开始）组成的无向加权图，该图由一个描述边的列表组成，其中 edges[i] = [a, b] 表示连接节点 a 和 b 的一条无向边，且该边遍历成功的概率为 succProb[i] 。
 *
 * 指定两个节点分别作为起点 start 和终点 end ，请你找出从起点到终点成功概率最大的路径，并返回其成功概率。
 *
 * 如果不存在从 start 到 end 的路径，请 返回 0 。只要答案与标准答案的误差不超过 1e-5 ，就会被视作正确答案。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
 * 输出：0.25000
 * 解释：从起点到终点有两条路径，其中一条的成功概率为 0.2 ，而另一条为 0.5 * 0.5 = 0.25
 * 示例 2：
 *
 *
 *
 * 输入：n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
 * 输出：0.30000
 * 示例 3：
 *
 *
 *
 * 输入：n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
 * 输出：0.00000
 * 解释：节点 0 和 节点 2 之间不存在路径
 * @Version 1.0
 */
public class pathwithmaximumprobability {
    double res = 0;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Integer>> posCanGo = new HashMap<>();
        int edgeNum = edges.length;
        // 建立从某个位置能去到位置的edges数组索引，方便之后查找。
        for (int i = 0; i < edgeNum; i++) {
            List<Integer> goList = posCanGo.getOrDefault(edges[i][0], new ArrayList<Integer>());
            goList.add(i);
            posCanGo.put(edges[i][0], goList);
            goList = posCanGo.getOrDefault(edges[i][1], new ArrayList<Integer>());
            goList.add(i);
            posCanGo.put(edges[i][1], goList);
        }
        // for (Integer key : posCanGo.keySet())
        //     System.out.println(posCanGo.get(key));
        if (!posCanGo.containsKey(end))
            return res;
        bfs(posCanGo, edges, succProb, start, end, n);
        return res;
    }
    public void bfs(Map<Integer,List<Integer>> posCanGo, int[][] edges, double[] succProb, int start, int end, int n) {
        double[] maxProb = new double[n+1];    // 记录去到每个位置的最大概率
        boolean[] inQue = new boolean[n+1];    // 记录有哪些还在队列里
        maxProb[start] = 1.0;
        maxProb[n] = 1.1;    // 加一个用于大根堆更新的大根值，不会有概率比1.1大了
        // 大根堆存位置，但根据最大概率进行排序
        PriorityQueue<Integer> nextMaxWay = new PriorityQueue<Integer>((a, b) -> (maxProb[b] > maxProb[a] ? 1 : -1));
        nextMaxWay.add(start);
        inQue[start] = true;
        while (!nextMaxWay.isEmpty()) {
            int pos = nextMaxWay.poll();
            inQue[pos] = false;
            // 走到了end，不再向后走了
            if (pos == end) {
                if (maxProb[end] > res)
                    res = maxProb[end];
                continue;
            }
            // 停止条件：堆中最大的概率都小于res时就结束
            if (maxProb[pos] <= res)
                break;
            // 找该位置的能去到的下一个位置
            List<Integer> goList = posCanGo.getOrDefault(pos, new ArrayList<Integer>());
            int goNum = goList.size();
            if (goNum == 0)
                continue;
            for (int i = 0; i < goNum; i++) {
                int nxtPosIdx = goList.get(i);
                int nxtPos = (edges[nxtPosIdx][0] == pos ? edges[nxtPosIdx][1] : edges[nxtPosIdx][0]);
                double thisWaytoNxtProb = maxProb[pos] * succProb[nxtPosIdx];
                // 下个去到的位置的概率小于等于res的概率，就不去下个位置了
                if (thisWaytoNxtProb <= res)
                    continue;
                // 下一个去到的位置的概率大于历史去这个位置的概率
                if (thisWaytoNxtProb > maxProb[nxtPos]) {
                    maxProb[nxtPos] = thisWaytoNxtProb;
                    // 放入最大的数，让堆更新，然后再删除堆顶，时间复杂度O(2logh)
                    // 应该也可以通过插入最小概率并不删除来减小一点时间，但堆中就会有很多无用数值，导致h变大，logh变大
                    if (inQue[nxtPos] && thisWaytoNxtProb > maxProb[nextMaxWay.peek()]) {
                        nextMaxWay.add(n);
                        nextMaxWay.poll();
                    }
                    // 不在堆里就放进堆里
                    else {
                        nextMaxWay.add(nxtPos);
                        inQue[nxtPos] = true;
                    }
                }
            }
        }
    }
}