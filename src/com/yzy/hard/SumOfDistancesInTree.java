package com.yzy.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.hard
 * @Date 2023/07/16 23:27
 * @Description
 * 给定一个无向、连通的树。树中有 n 个标记为 0...n-1 的节点以及 n-1 条边 。
 *
 * 给定整数 n 和数组 edges ， edges[i] = [ai, bi]表示树中的节点 ai 和 bi 之间有一条边。
 *
 * 返回长度为 n 的数组 answer ，其中 answer[i] 是树中第 i 个节点与所有其他节点之间的距离之和。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
 * 输出: [8,12,6,10,10,10]
 * 解释: 树如图所示。
 * 我们可以计算出 dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
 * 也就是 1 + 1 + 2 + 2 + 2 = 8。 因此，answer[0] = 8，以此类推。
 * 示例 2:
 *
 *
 * 输入: n = 1, edges = []
 * 输出: [0]
 * 示例 3:
 *
 *
 * 输入: n = 2, edges = [[1,0]]
 * 输出: [1,1]
 * @Version 1.0
 */
public class SumOfDistancesInTree {
    private List<Integer>[] edgeList = null;
    private int[] answer = null, childs = null;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {

        answer = new int[n];
        childs = new int[n];

        edgeList = Stream.generate(ArrayList::new).limit(n).toArray(List[]::new);
        for (int[] edge : edges) {
            edgeList[edge[0]].add(edge[1]);
            edgeList[edge[1]].add(edge[0]);
        }

        dfs(0, 0, 0);
        dfs(0, 0);

        return answer;

    }

    public void dfs(int parent, int root, int depth) {
        answer[0] += depth++;
        for (int son : edgeList[root]) {
            if (son != parent) {
                dfs(root, son, depth);
                childs[root] += childs[son] + 1;
            }
        }
    }

    public void dfs(int parent, int root) {
        for (int son : edgeList[root]) {
            if (son != parent) {
                answer[son] = answer[root] - (childs[son] + 1) + (edgeList.length - (childs[son] + 1));
                dfs(root, son);
            }
        }
    }
}