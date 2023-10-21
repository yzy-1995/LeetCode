package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/21 09:06
 * @Description
 * 给你一个整数 n ，表示一张 无向图 中有 n 个节点，编号为 0 到 n - 1 。同时给你一个二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示节点 ai 和 bi 之间有一条 无向 边。
 *
 * 请你返回 无法互相到达 的不同 点对数目 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 3, edges = [[0,1],[0,2],[1,2]]
 * 输出：0
 * 解释：所有点都能互相到达，意味着没有点对无法互相到达，所以我们返回 0 。
 * 示例 2：
 *
 *
 *
 * 输入：n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
 * 输出：14
 * 解释：总共有 14 个点对互相无法到达：
 * [[0,1],[0,3],[0,6],[1,2],[1,3],[1,4],[1,5],[2,3],[2,6],[3,4],[3,5],[3,6],[4,6],[5,6]]
 * 所以我们返回 14 。
 * @Version 1.0
 */
public class countunreachablepairsofnodesinanundirectedgraph {
    int[] point;
    int[] cnt;
    private int find(int x){
        if(point[x] != x){
            point[x] = find(point[x]);
        }
        return point[x];
    }
    public long countPairs(int n, int[][] edges) {
        point = new int[n];
        cnt = new int[n];
        for(int i = 0; i < n; i ++ ){
            point[i] = i;
        }
        for(int[] e : edges){
            int a = find(e[0]), b = find(e[1]);
            point[a] = point[b];
        }
        for(int i = 0; i < n; i ++){
            int x = find(i);
            cnt[x]++;
        }
        List<Integer> nums = new ArrayList<>();
        for(int i = 0; i < n ; i ++){
            if(cnt[i] != 0){
                nums.add(cnt[i]);
            }
        }
        long ans = 0;
        int sum = 0;
        for(int x : nums){
            ans += (long)x * sum;
            sum += x;
        }
        return ans;
    }
}