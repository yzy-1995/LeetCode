package com.yzy.mid;

import java.util.HashMap;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/09 21:22
 * @Description
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 *
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 *
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 *
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 条件：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 示例 2：
 *
 * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * 输出：[3.75000,0.40000,5.00000,0.20000]
 * 示例 3：
 *
 * 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * 输出：[0.50000,2.00000,-1.00000,-1.00000]
 * @Version 1.0
 */
public class EvaluateDivision {
    class UF{
        private int[] parent;
        private int[] size;
        private double[] weight;
        public UF(int n){
            parent = new int[n];
            weight = new double[n];
            for(int i=0; i<n; i++){
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }
        public void union(int p, int q, double value){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ){
                return;
            }
            // 不是同一个根节点, 则需要合并
            parent[rootP] = rootQ;
            weight[rootP] = weight[q] * value / weight[p];
        }

        private int find(int x){
            //  路径压缩
            if(parent[x] != x){
                int temp = parent[x];
                parent[x] = find(temp);
                weight[x] *= weight[temp];
            }
            return parent[x];
        }
        public double connected(int p, int q){
            if(find(p) == find(q)){
                return weight[p] / weight[q];
            }else{
                return -1.0d;
            }
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 预处理 构造并查集
        int n = equations.size();
        HashMap<String, Integer> map = new HashMap<>(2*n);
        UF uf = new UF(2*n);
        int id = 0;
        for(int i=0; i<n; i++){
            List<String> list = equations.get(i);
            String p = list.get(0);
            String q = list.get(1);
            if(!map.containsKey(p)){
                map.put(p, id);
                id++;
            }
            if(!map.containsKey(q)){
                map.put(q, id);
                id++;
            }
            uf.union(map.get(p), map.get(q), values[i]);
        }
        // System.out.println(map);
        double[] ans = new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            List<String> list = queries.get(i);
            String p = list.get(0);
            String q = list.get(1);
            if(map.get(p) == null || map.get(q) == null){
                ans[i] = -1.0d;
            }else{
                ans[i] = uf.connected(map.get(p), map.get(q));
            }
        }
        return ans;
    }
}