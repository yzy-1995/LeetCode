package com.yzy.mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/02/03 13:04
 * @Description
 * 现有一个加权无向连通图。给你一个正整数 n ，表示图中有 n 个节点，并按从 1 到 n 给节点编号；另给你一个数组 edges ，其中每个 edges[i] = [ui, vi, weighti] 表示存在一条位于节点 ui 和 vi 之间的边，这条边的权重为 weighti 。
 *
 * 从节点 start 出发到节点 end 的路径是一个形如 [z0, z1, z2, ..., zk] 的节点序列，满足 z0 = start 、zk = end 且在所有符合 0 <= i <= k-1 的节点 zi 和 zi+1 之间存在一条边。
 *
 * 路径的距离定义为这条路径上所有边的权重总和。用 distanceToLastNode(x) 表示节点 n 和 x 之间路径的最短距离。受限路径 为满足 distanceToLastNode(zi) > distanceToLastNode(zi+1) 的一条路径，其中 0 <= i <= k-1 。
 *
 * 返回从节点 1 出发到节点 n 的 受限路径数 。由于数字可能很大，请返回对 109 + 7 取余 的结果。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 5, edges = [[1,2,3],[1,3,3],[2,3,1],[1,4,2],[5,2,2],[3,5,1],[5,4,10]]
 * 输出：3
 * 解释：每个圆包含黑色的节点编号和蓝色的 distanceToLastNode 值。三条受限路径分别是：
 * 1) 1 --> 2 --> 5
 * 2) 1 --> 2 --> 3 --> 5
 * 3) 1 --> 3 --> 5
 * 示例 2：
 *
 *
 * 输入：n = 7, edges = [[1,3,1],[4,1,2],[7,3,4],[2,5,3],[5,6,1],[6,7,2],[7,5,3],[2,6,4]]
 * 输出：1
 * 解释：每个圆包含黑色的节点编号和蓝色的 distanceToLastNode 值。唯一一条受限路径是：1 --> 3 --> 7 。
 * @Version 1.0
 */
public class numberofrestrictedpathsfromfirsttolastnode {
    public int countRestrictedPaths(int n, int[][] edges) {
        Map<Integer, Node> map = new HashMap<>();
        int mod = 1_000_000_007;
        for (int i = 1; i <= n; i++) map.put(i, new Node(i));
        for (int[] e : edges) {
            Node x = map.get(e[0]), y = map.get(e[1]);
            map.get(e[0]).vts.add(y);
            map.get(e[0]).eds.add(e[2]);
            map.get(e[1]).vts.add(x);
            map.get(e[1]).eds.add(e[2]);
        }
//        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.cost));
        PQ pq = new PQ();
        Node end = map.get(n);
        end.cost = 0;
        end.paths = 1;
        pq.offer(map.get(n));
        while (!pq.isEmpty()) {
            Node node = pq.poll(), next;
            if (node.vis) continue;
            List<Node> verts = node.vts;
            List<Integer> es = node.eds;
            for (int i = 0; i < verts.size(); i++) {
                if (!(next = verts.get(i)).vis) {
                    if (node.cost + es.get(i) < next.cost) {
                        next.cost = node.cost + es.get(i);
                        if (next.pos > 0) pq.decline(next.pos);
                        else pq.offer(next);
                    }
                    if (node.cost < next.cost) next.paths = (next.paths + node.paths) % mod;
                }

            }
            node.vis = true;
            // System.out.println(node.id + ", " + node.cost + ", " + node.paths);
        }
        return map.get(1).paths;
    }

    class Node {
        int id, cost, paths, pos;
        boolean vis;
        List<Node> vts;
        List<Integer> eds;
        public Node(int id) {
            this.id = id;
            this.cost = Integer.MAX_VALUE;
            this.paths = 0;
            this.vts = new ArrayList<>();
            this.eds = new ArrayList<>();
        }
    }

    class PQ {
        Node[] t = new Node[20010];
        int size;

        public void offer(Node node) {
            t[++size] = node;
            t[size].pos = size;
            up(size);
        }

        public Node poll() {
            Node res = t[1];
            t[1] = t[size--];
            down(1);
            return res;
        }

        public void decline(int pos) {
            up(pos);
        }

        public boolean isEmpty() {return size == 0;}

        private void down(int pos) {
            int child;
            Node cur = t[pos];
            for (; pos << 1 <= size; pos = child) {
                child = pos << 1;
                if (child < size && t[child].cost > t[child + 1].cost) ++child;
                if (cur.cost < t[child].cost) break;
                t[child].pos = pos;
                t[pos] = t[child];
            }
            t[pos] = cur;
            t[pos].pos = pos;
        }

        private void up(int pos) {
            Node cur = t[pos];
            for (; (pos >> 1) > 0 && cur.cost < t[pos >> 1].cost; pos >>= 1) {
                t[pos >> 1].pos = pos;
                t[pos] = t[pos >> 1];
            }
            t[pos] = cur;
            t[pos].pos = pos;
        }
    }
}