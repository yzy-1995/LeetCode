package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/07 13:04
 * @Description
 * n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
 *
 * 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
 *
 * 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
 *
 * 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
 *
 * 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * 输出：3
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 * 示例 2：
 *
 *
 *
 * 输入：n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * 输出：2
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 * 示例 3：
 *
 * 输入：n = 3, connections = [[1,0],[2,0]]
 * 输出：0
 * @Version 1.0
 */
public class reorderroutestomakeallpathsleadtothecityzero {
    int N = (int)1e5;
    int[] e = new int[N * 2];
    int[] ne = new int[N * 2];
    int[] h = new int[N];
    boolean[] origin = new boolean[N * 2];  // 是否是原本存在的线
    int idx;

    public void add(int a, int b, boolean o) {
        e[idx] = b;
        ne[idx] = h[a];
        origin[idx] = o;
        h[a] = idx++;
    }

    public int minReorder(int n, int[][] connections) {
        // 每个找到他最近的可以到0的位置？
        Arrays.fill(h, -1);
        int m = connections.length;
        for(int i = 0; i < m; i++) {
            int a = connections[i][0];
            int b = connections[i][1];
            add(a, b, true);
            add(b, a, false);
        }

        return dfs(0, -1);
    }

    public int dfs(int u, int fa) {
        int res = 0;
        for(int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if(v != fa) {
                // 如果原来这条边是存在的，那就需要逆转
                if(origin[i]) {
                    res++;
                }
                res += dfs(v, u);
            }
        }

        return res;
    }
}