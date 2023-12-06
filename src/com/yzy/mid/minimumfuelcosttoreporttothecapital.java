package com.yzy.mid;

import java.util.*;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/05 00:03
 * @Description
 * 给你一棵 n 个节点的树（一个无向、连通、无环图），每个节点表示一个城市，编号从 0 到 n - 1 ，且恰好有 n - 1 条路。0 是首都。给你一个二维整数数组 roads ，其中 roads[i] = [ai, bi] ，表示城市 ai 和 bi 之间有一条 双向路 。
 *
 * 每个城市里有一个代表，他们都要去首都参加一个会议。
 *
 * 每座城市里有一辆车。给你一个整数 seats 表示每辆车里面座位的数目。
 *
 * 城市里的代表可以选择乘坐所在城市的车，或者乘坐其他城市的车。相邻城市之间一辆车的油耗是一升汽油。
 *
 * 请你返回到达首都最少需要多少升汽油。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：roads = [[0,1],[0,2],[0,3]], seats = 5
 * 输出：3
 * 解释：
 * - 代表 1 直接到达首都，消耗 1 升汽油。
 * - 代表 2 直接到达首都，消耗 1 升汽油。
 * - 代表 3 直接到达首都，消耗 1 升汽油。
 * 最少消耗 3 升汽油。
 * 示例 2：
 *
 *
 *
 * 输入：roads = [[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]], seats = 2
 * 输出：7
 * 解释：
 * - 代表 2 到达城市 3 ，消耗 1 升汽油。
 * - 代表 2 和代表 3 一起到达城市 1 ，消耗 1 升汽油。
 * - 代表 2 和代表 3 一起到达首都，消耗 1 升汽油。
 * - 代表 1 直接到达首都，消耗 1 升汽油。
 * - 代表 5 直接到达首都，消耗 1 升汽油。
 * - 代表 6 到达城市 4 ，消耗 1 升汽油。
 * - 代表 4 和代表 6 一起到达首都，消耗 1 升汽油。
 * 最少消耗 7 升汽油。
 * 示例 3：
 *
 *
 *
 * 输入：roads = [], seats = 1
 * 输出：0
 * 解释：没有代表需要从别的城市到达首都。
 * @Version 1.0
 */
public class minimumfuelcosttoreporttothecapital {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    long res = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        // 构建map
        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            List<Integer> list1 = map.getOrDefault(from, new ArrayList<>());
            list1.add(to);
            map.put(from, list1);
            List<Integer> list2 = map.getOrDefault(to, new ArrayList<>());
            list2.add(from);
            map.put(to, list2);
        }
        // 对于某个节点cur，如果它有size个子节点，
        // 那么这size个节点到达cur父节点时，因为只有一条路来往，所有耗油量为(size+seats-1)/seats。
        getNodesCnt(0, seats);
        return res;
    }

    // DFS，计算以每个节点为根节点的子树节点数目，同时将其子节点到该节点的耗油量算入总量中
    private int getNodesCnt(int current, int seats) {
        visited.add(current);
        int totalCnt = 1;
        if (!map.containsKey(current)) {
            return 0;
        }
        for (int next : map.get(current)) {
            if (visited.contains(next)) {
                continue;
            }
            int nodesCnt = getNodesCnt(next, seats);
            res += (nodesCnt + seats - 1) / seats;
            totalCnt += nodesCnt;
        }
        return totalCnt;
    }
}