package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/15 12:19
 * @Description
 * 有一个有 n 个节点的有向图，节点按 0 到 n - 1 编号。图由一个 索引从 0 开始 的 2D 整数数组 graph表示， graph[i]是与节点 i 相邻的节点的整数数组，这意味着从节点 i 到 graph[i]中的每个节点都有一条边。
 *
 * 如果一个节点没有连出的有向边，则该节点是 终端节点 。如果从该节点开始的所有可能路径都通向 终端节点 ，则该节点为 安全节点 。
 *
 * 返回一个由图中所有 安全节点 组成的数组作为答案。答案数组中的元素应当按 升序 排列。
 *
 *
 *
 * 示例 1：
 *
 * Illustration of graph
 *
 * 输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * 输出：[2,4,5,6]
 * 解释：示意图如上。
 * 节点 5 和节点 6 是终端节点，因为它们都没有出边。
 * 从节点 2、4、5 和 6 开始的所有路径都指向节点 5 或 6 。
 * 示例 2：
 *
 * 输入：graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
 * 输出：[4]
 * 解释:
 * 只有节点 4 是终端节点，从节点 4 开始的所有路径都通向节点 4 。
 * @Version 1.0
 */
public class findeventualsafestates {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<Integer>();//记录结果
        int n = graph.length;//长度
        int[] type = new int[n];//访问类型
        for ( int i = 0; i < n; i++ ) {
            if ( DFS(graph, i, type) == 2 ) ans.add(i);
        }
        return ans;
    }

    public static int DFS( int[][] graph, int index, int[] type ) {
        if ( type[index] == 1 ) return 3;//如果访问过了，说明成环
        if ( type[index] != 0 ) return type[index];	//如果不是0，返回自身
        type[index] = 1;//标记访问了
        for (int i : graph[index]) {
            if ( DFS(graph, i, type) == 3 ) {
                type[i] = 3;
                return 3;
            }
        }

        type[index] = 2;//不成环
        return 2;
    }
}