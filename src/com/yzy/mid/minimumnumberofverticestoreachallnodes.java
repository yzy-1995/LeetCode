package com.yzy.mid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/31 00:05
 * @Description
 * 给你一个 有向无环图 ， n 个节点编号为 0 到 n-1 ，以及一个边数组 edges ，其中 edges[i] = [fromi, toi] 表示一条从点  fromi 到点 toi 的有向边。
 *
 * 找到最小的点集使得从这些点出发能到达图中所有点。题目保证解存在且唯一。
 *
 * 你可以以任意顺序返回这些节点编号。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
 * 输出：[0,3]
 * 解释：从单个节点出发无法到达所有节点。从 0 出发我们可以到达 [0,1,2,5] 。从 3 出发我们可以到达 [3,4,2,5] 。所以我们输出 [0,3] 。
 * 示例 2：
 *
 *
 *
 * 输入：n = 5, edges = [[0,1],[2,1],[3,1],[1,4],[2,4]]
 * 输出：[0,2,3]
 * 解释：注意到节点 0，3 和 2 无法从其他节点到达，所以我们必须将它们包含在结果点集中，这些点都能到达节点 1 和 4 。
 * @Version 1.0
 */
public class minimumnumberofverticestoreachallnodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < edges.size(); i++) {
            hash.add(edges.get(i).get(0));
            hashSet.add(edges.get(i).get(1));
        }
        for (Integer a : hash) {
            if(!hashSet.contains(a)){
                res.add(a);
            }
        }
        return res;
    }
}