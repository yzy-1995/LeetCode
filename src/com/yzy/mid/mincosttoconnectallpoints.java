package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/05 00:25
 * @Description
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 *
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 *
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * 输出：20
 * 解释：
 *
 * 我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
 * 注意到任意两个点之间只有唯一一条路径互相到达。
 * 示例 2：
 *
 * 输入：points = [[3,12],[-2,5],[-4,1]]
 * 输出：18
 * 示例 3：
 *
 * 输入：points = [[0,0],[1,1],[1,0],[-1,1]]
 * 输出：4
 * 示例 4：
 *
 * 输入：points = [[-1000000,-1000000],[1000000,1000000]]
 * 输出：4000000
 * 示例 5：
 *
 * 输入：points = [[0,0]]
 * 输出：0
 * @Version 1.0
 */
public class mincosttoconnectallpoints {
    class UF {
        // 连通分量个数
        private int count;
        // 存储⼀棵树
        private int[] parent;
        // 记录树的「重量」
        private int[] size;
        // n 为图中节点的个数
        public UF(int n) {
            this.count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        // 将节点 p 和节点 q 连通
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;

            // ⼩树接到⼤树下⾯，较平衡
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            // 两个连通分量合并成⼀个连通分量
            count--;
        }
        // 判断节点 p 和节点 q 是否连通
        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }
        // 返回节点 x 的连通分量根节点
        private int find(int x) {
            while (parent[x] != x) {
                //  进⾏路径压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        // 返回图中的连通分量个数
        public int count() {
            return count;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        UF uf = new UF(n);
        int[][] side = new int[(1+n)*n/2][3];
        int index = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                side[index][0] = i;
                side[index][1] = j;
                side[index][2] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                index++;
            }
        }
        // side [节点1, 节点2, length]
        Arrays.sort(side, (int[] x, int[] y)->{
            return x[2]-y[2];
        });
        int ans = 0;
        for(int i=0; i<(1+n)*n/2; i++){
            if(uf.connected(side[i][0], side[i][1])){
                continue;
            }else{
                ans += side[i][2];
                uf.union(side[i][0], side[i][1]);
            }
        }
        return ans;
    }
}