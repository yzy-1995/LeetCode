package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/14 00:08
 * @Description
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 *
 *  graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 * 示例 2：
 *
 *
 *
 * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * @Version 1.0
 */
public class allpathsfromsourcetotarget {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int[][] g ;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        g = graph;
        dfs(0,g[0]);
        return res;
    }
    public void dfs(int k,int[] a){
        list.add(k);
        if(k==g.length-1) {
            res.add(new ArrayList<>(list));//踩大坑，直接res.add(list)不行，只能新new一个才行？
            list.remove(list.size()-1);
            return;
        }
        for(int i = 0;i<a.length;i++){
            dfs(a[i],g[a[i]]);
        }
        list.remove(list.size()-1);
    }
}