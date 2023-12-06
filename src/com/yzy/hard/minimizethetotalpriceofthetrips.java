package com.yzy.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.hard
 * @Date 2023/12/06 08:12
 * @Description
 * 现有一棵无向、无根的树，树中有 n 个节点，按从 0 到 n - 1 编号。给你一个整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。
 *
 * 每个节点都关联一个价格。给你一个整数数组 price ，其中 price[i] 是第 i 个节点的价格。
 *
 * 给定路径的 价格总和 是该路径上所有节点的价格之和。
 *
 * 另给你一个二维整数数组 trips ，其中 trips[i] = [starti, endi] 表示您从节点 starti 开始第 i 次旅行，并通过任何你喜欢的路径前往节点 endi 。
 *
 * 在执行第一次旅行之前，你可以选择一些 非相邻节点 并将价格减半。
 *
 * 返回执行所有旅行的最小价格总和。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 4, edges = [[0,1],[1,2],[1,3]], price = [2,2,10,6], trips = [[0,3],[2,1],[2,3]]
 * 输出：23
 * 解释：
 * 上图表示将节点 2 视为根之后的树结构。第一个图表示初始树，第二个图表示选择节点 0 、2 和 3 并使其价格减半后的树。
 * 第 1 次旅行，选择路径 [0,1,3] 。路径的价格总和为 1 + 2 + 3 = 6 。
 * 第 2 次旅行，选择路径 [2,1] 。路径的价格总和为 2 + 5 = 7 。
 * 第 3 次旅行，选择路径 [2,1,3] 。路径的价格总和为 5 + 2 + 3 = 10 。
 * 所有旅行的价格总和为 6 + 7 + 10 = 23 。可以证明，23 是可以实现的最小答案。
 * 示例 2：
 *
 *
 * 输入：n = 2, edges = [[0,1]], price = [2,2], trips = [[0,0]]
 * 输出：1
 * 解释：
 * 上图表示将节点 0 视为根之后的树结构。第一个图表示初始树，第二个图表示选择节点 0 并使其价格减半后的树。
 * 第 1 次旅行，选择路径 [0] 。路径的价格总和为 1 。
 * 所有旅行的价格总和为 1 。可以证明，1 是可以实现的最小答案。
 * @Version 1.0
 */
public class minimizethetotalpriceofthetrips {
    private static final int MAXN = 55, MAXM = MAXN << 1;

    private static int[] h = new int[MAXN], e = new int[MAXM], ne = new int[MAXM];

    private static int[] color = new int[MAXN], fa = new int[MAXN], father = new int[MAXN], diff = new int[MAXN];

    private List<Integer>[] qs;

    private static int idx;

    private void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private int find(int x) {
        if (fa[x] != x) fa[x] = find(fa[x]);
        return fa[x];
    }

    private void tarjan(int u, int f) {
        father[u] = f;
        color[u] = 1;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if (color[v] == 0) {
                tarjan(v, u);
                fa[v] = u;
            }
        }

        for (Integer v : qs[u]) {
            if (u == v || color[v] == 2) {
                diff[u]++;
                diff[v]++;
                int lca = find(v);
                diff[lca]--;
                if (father[lca] != -1) {
                    diff[father[lca]]--;
                }
            }
        }

        color[u] = 2;
    }

    private int[] dfs(int[] price, int u, int f) {
        int[] ans = new int[]{0, 0, diff[u]};
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if (v == f) continue;
            int[] sub = dfs(price, v, u);
            ans[0] += Math.min(sub[0], sub[1]);
            ans[1] += sub[0];
            ans[2] += sub[2];
        }

        ans[0] += price[u] * ans[2];
        ans[1] += price[u] * ans[2] / 2;
        return ans;
    }

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        idx = 0;
        for (int i = 0; i < n; i++) {
            h[i] = -1;
            color[i] = 0;
            fa[i] = i;
            father[i] = -1;
            diff[i] = 0;
        }

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            add(a, b);
            add(b, a);
        }

        qs = new ArrayList[n];
        Arrays.setAll(qs, v -> new ArrayList<>());
        for (int[] trip : trips) {
            int a = trip[0], b = trip[1];
            qs[a].add(b);
            if (a != b) qs[b].add(a);
        }

        tarjan(0, -1);
        int[] ans = dfs(price, 0, -1);
        return Math.min(ans[0], ans[1]);
    }
}