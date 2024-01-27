package com.yzy.hard;

import java.util.*;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.hard
 * @Date 2024/01/26 21:35
 * @Description
 * 现有一棵由 n 个节点组成的无向树，节点按从 0 到 n - 1 编号。给你一个整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] = [ui, vi, wi] 表示树中存在一条位于节点 ui 和节点 vi 之间、权重为 wi 的边。
 *
 * 另给你一个长度为 m 的二维整数数组 queries ，其中 queries[i] = [ai, bi] 。对于每条查询，请你找出使从 ai 到 bi 路径上每条边的权重相等所需的 最小操作次数 。在一次操作中，你可以选择树上的任意一条边，并将其权重更改为任意值。
 *
 * 注意：
 *
 * 查询之间 相互独立 的，这意味着每条新的查询时，树都会回到 初始状态 。
 * 从 ai 到 bi的路径是一个由 不同 节点组成的序列，从节点 ai 开始，到节点 bi 结束，且序列中相邻的两个节点在树中共享一条边。
 * 返回一个长度为 m 的数组 answer ，其中 answer[i] 是第 i 条查询的答案。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 7, edges = [[0,1,1],[1,2,1],[2,3,1],[3,4,2],[4,5,2],[5,6,2]], queries = [[0,3],[3,6],[2,6],[0,6]]
 * 输出：[0,0,1,3]
 * 解释：第 1 条查询，从节点 0 到节点 3 的路径中的所有边的权重都是 1 。因此，答案为 0 。
 * 第 2 条查询，从节点 3 到节点 6 的路径中的所有边的权重都是 2 。因此，答案为 0 。
 * 第 3 条查询，将边 [2,3] 的权重变更为 2 。在这次操作之后，从节点 2 到节点 6 的路径中的所有边的权重都是 2 。因此，答案为 1 。
 * 第 4 条查询，将边 [0,1]、[1,2]、[2,3] 的权重变更为 2 。在这次操作之后，从节点 0 到节点 6 的路径中的所有边的权重都是 2 。因此，答案为 3 。
 * 对于每条查询 queries[i] ，可以证明 answer[i] 是使从 ai 到 bi 的路径中的所有边的权重相等的最小操作次数。
 * 示例 2：
 *
 *
 * 输入：n = 8, edges = [[1,2,6],[1,3,4],[2,4,6],[2,5,3],[3,6,6],[3,0,8],[7,0,2]], queries = [[4,6],[0,4],[6,5],[7,4]]
 * 输出：[1,2,2,3]
 * 解释：第 1 条查询，将边 [1,3] 的权重变更为 6 。在这次操作之后，从节点 4 到节点 6 的路径中的所有边的权重都是 6 。因此，答案为 1 。
 * 第 2 条查询，将边 [0,3]、[3,1] 的权重变更为 6 。在这次操作之后，从节点 0 到节点 4 的路径中的所有边的权重都是 6 。因此，答案为 2 。
 * 第 3 条查询，将边 [1,3]、[5,2] 的权重变更为 6 。在这次操作之后，从节点 6 到节点 5 的路径中的所有边的权重都是 6 。因此，答案为 2 。
 * 第 4 条查询，将边 [0,7]、[0,3]、[1,3] 的权重变更为 6 。在这次操作之后，从节点 7 到节点 4 的路径中的所有边的权重都是 6 。因此，答案为 3 。
 * 对于每条查询 queries[i] ，可以证明 answer[i] 是使从 ai 到 bi 的路径中的所有边的权重相等的最小操作次数。
 * @Version 1.0
 */
public class minimumedgeweightequilibriumqueriesinatree {
    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        if (n == 1) {
            return new int[queries.length];
        }
        int[][] res = new int[n][];
        // 建立无向树
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] edge : edges) {
            List<int[]> list = map.computeIfAbsent(edge[0], k -> new ArrayList<>());
            list.add(new int[]{edge[1],edge[2]});
            list = map.computeIfAbsent(edge[1], k -> new ArrayList<>());
            list.add(new int[]{edge[0],edge[2]});
        }
        // Tarjan - 离线
        Map<Integer , List<int[]>> Qmap = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            int[] ins = queries[i];
            List<int[]> list = Qmap.computeIfAbsent(ins[0], k -> new ArrayList<>());
            list.add(new int[]{ins[1], i});
            list = Qmap.computeIfAbsent(ins[1], k -> new ArrayList<>());
            list.add(new int[]{ins[0], i});
        }

        res[0] = new int[26];
        int[] father = new int[queries.length];
        dfs(0, map, res, -1, Qmap, new boolean[n], new UnionFind(n, n), father);
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int max = 0, m = 0, f = father[i];
            for (int j = 0; j < 26; j++) {
                int k = res[queries[i][0]][j] - res[f][j] + res[queries[i][1]][j] - res[f][j];
                max = Math.max(max, k);
                m += k;
            }
            answer[i] = m - max;
        }
        return answer;
    }
    private void dfs(int node, Map<Integer, List<int[]>> map, int[][] res, int f, Map<Integer, List<int[]>> Qmap, boolean[] vis, UnionFind uf, int[] father) {
        int[] anr = res[node];
        for (int[] ins : map.get(node)) {
            if (ins[0] != f) {
                res[ins[0]] = Arrays.copyOf(anr, anr.length);
                res[ins[0]][ins[1] - 1]++;
                dfs(ins[0], map, res, node, Qmap, vis, uf, father);
                uf.unite(node, ins[0]);
                vis[ins[0]] = true;
            }
        }
        List<int[]> list = Qmap.get(node);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                int[] its = list.get(i);
                if (vis[its[0]] || its[0] == node) {
                    father[its[1]] = uf.find(its[0]);
                }
            }
        }
    }
}
class UnionFind{
    int[] root = null;
    int setCount;
    int n;
    public UnionFind(int n,int sum){
        root = new int[n];
        setCount = sum;
        for (int i = 0; i < n; ++i) {
            root[i] = i;
        }
    }
    public int find(int x){
        if(root[x] == x){
            return x;
        }
        return root[x] = find(root[x]);
    }
    public boolean unite(int x,int y){
        x = find(x);
        y = find(y);
        if(x == y) return false;
        root[y] = x;
        setCount--;
        return true;
    }
    public int getCount() {
        return setCount;
    }
}