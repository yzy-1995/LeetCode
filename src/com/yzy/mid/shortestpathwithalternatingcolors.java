package com.yzy.mid;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/02 00:04
 * @Description
 * 给定一个整数 n，即有向图中的节点数，其中节点标记为 0 到 n - 1。图中的每条边为红色或者蓝色，并且可能存在自环或平行边。
 *
 * 给定两个数组 redEdges 和 blueEdges，其中：
 *
 * redEdges[i] = [ai, bi] 表示图中存在一条从节点 ai 到节点 bi 的红色有向边，
 * blueEdges[j] = [uj, vj] 表示图中存在一条从节点 uj 到节点 vj 的蓝色有向边。
 * 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，那么 answer[x] = -1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
 * 输出：[0,1,-1]
 * 示例 2：
 *
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
 * 输出：[0,1,-1]
 * @Version 1.0
 */
public class shortestpathwithalternatingcolors {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        List<Integer>[] redList = new List[n];
        List<Integer>[] blueList = new List[n];

        for (int i = 0; i < n; i++) {
            redList[i] = new ArrayList<>();
            blueList[i] = new ArrayList<>();
        }

        // 顶点 i[0] 到 i[1] 的直接红色路径
        for (var i : redEdges) {
            redList[i[0]].add(i[1]);
        }

        // 顶点 i[0] 到 i[1] 的直接蓝色路径
        for (var i : blueEdges) {
            blueList[i[0]].add(i[1]);
        }

        // 最后一步是红色时到达点 i 的最小步数
        int[] redAns = new int[n];
        // 最后一步是蓝色时到达点 i 的最小步数
        int[] blueAns = new int[n];

        for (int i = 1; i < n; i++) {
            redAns[i] = Integer.MAX_VALUE;
            blueAns[i] = Integer.MAX_VALUE;
        }

        // 由长度为 2 的数组表示每个点，数组内容：点的序号 + 下一步路的颜色
        Queue<int[]> queue = new ArrayDeque<>();

        // 0 表示下一步要走红色
        queue.add(new int[]{0, 0});
        // 1 表示下一步要走蓝色
        // 初始状态有 2 个是因为一开始既可以走红色也可以走蓝色
        queue.add(new int[]{0, 1});

        // bfs 的层数 = 走的步数
        // 在层数 i 到达的点意味着从起点出发走 i 步能到达这个点
        int level = 0;

        // bfs 用队列来模拟
        while(!queue.isEmpty()) {
            level++;

            int size = queue.size();

            // 对每个准备走的点
            for (int i = 0; i < size; i++) {
                int[] curArr = queue.poll();
                int cur = curArr[0];

                // 如果下一步要走红色
                if (curArr[1] == 0) {
                    for (var next : redList[cur]) {
                        // 如果记录的最后一步为红色时，到达点next的最小步数比当前的level小
                        if (level < redAns[next]) {
                            // 更新记录的最小步数
                            redAns[next] = level;
                            // next入队，下一步走蓝色
                            queue.offer(new int[]{next, 1});
                        }
                    }
                    // 如果下一步要走蓝色
                } else {
                    for (var next : blueList[cur]) {
                        if (level < blueAns[next]) {
                            blueAns[next] = level;
                            queue.offer(new int[]{next, 0});
                        }
                    }
                }
            }
        }

        // 到达一个点的最小步数，从 redAns 和 blueAns 中选出最小者
        for (int i = 0; i < redAns.length; i++) {
            if (blueAns[i] < redAns[i]) {
                redAns[i] = blueAns[i];
            } else if (redAns[i] == Integer.MAX_VALUE) {
                redAns[i] = -1;
            }
        }

        return redAns;
    }
}