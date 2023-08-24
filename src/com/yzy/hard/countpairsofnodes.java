package com.yzy.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.hard
 * @Date 2023/08/23 00:05
 * @Description
 * 给你一个无向图，无向图由整数 n  ，表示图中节点的数目，和 edges 组成，其中 edges[i] = [ui, vi] 表示 ui 和 vi 之间有一条无向边。同时给你一个代表查询的整数数组 queries 。
 *
 * 第 j 个查询的答案是满足如下条件的点对 (a, b) 的数目：
 *
 * a < b
 * cnt 是与 a 或者 b 相连的边的数目，且 cnt 严格大于 queries[j] 。
 * 请你返回一个数组 answers ，其中 answers.length == queries.length 且 answers[j] 是第 j 个查询的答案。
 *
 * 请注意，图中可能会有 重复边 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 4, edges = [[1,2],[2,4],[1,3],[2,3],[2,1]], queries = [2,3]
 * 输出：[6,5]
 * 解释：每个点对中，与至少一个点相连的边的数目如上图所示。
 * 示例 2：
 *
 * 输入：n = 5, edges = [[1,5],[1,5],[3,4],[2,5],[1,3],[5,1],[2,3],[2,5]], queries = [1,2,3,4,5]
 * 输出：[10,10,9,8,6]
 *
 * @Version 1.0
 */
public class countpairsofnodes {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int count[]=new int[n];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<edges.length;i++){
            count[edges[i][0]-1]++;
            count[edges[i][1]-1]++;
            int a=20005*(Math.max(edges[i][0],edges[i][1])-1)+Math.min(edges[i][0],edges[i][1])-1;
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int copy[]=count.clone();
        Arrays.sort(copy);
        for(int i=0;i<queries.length;i++){
            int a=queries[i],sum=0,l=0,r=n-1;
            while(l<n){
                while(r>=0&&copy[l]+copy[r]>a){r--;}
                sum+=n-Math.max(l,r)-1;
                l++;
            }
            for(int b:map.keySet()){
                int c=map.get(b),u=b/20005,v=b%20005;
                if(count[u]+count[v]>a&&count[u]+count[v]-c<=a){sum--;}
            }
            queries[i]=sum;
        }
        return queries;
    }
}