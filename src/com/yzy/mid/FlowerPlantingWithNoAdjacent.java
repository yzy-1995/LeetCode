package com.yzy.mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: leetcode1042
 * 有 n 个花园，按从 1 到 n 标记。另有数组 paths ，其中 paths[i] = [xi, yi] 描述了花园 xi 到花园 yi 的双向路径。在每个花园中，你打算种下四种花之一。
 * 另外，所有花园 最多 有 3 条路径可以进入或离开.
 * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 * 以数组形式返回 任一 可行的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1、2、3、4 表示。保证存在答案。
 * 示例 1：
 * 输入：n = 3, paths = [[1,2],[2,3],[3,1]]
 * 输出：[1,2,3]
 * 解释：
 * 花园 1 和 2 花的种类不同。
 * 花园 2 和 3 花的种类不同。
 * 花园 3 和 1 花的种类不同。
 * 因此，[1,2,3] 是一个满足题意的答案。其他满足题意的答案有 [1,2,4]、[1,4,2] 和 [3,2,1]
 * 示例 2：
 * 输入：n = 4, paths = [[1,2],[3,4]]
 * 输出：[1,2,1,2]
 * 示例 3：
 * 输入：n = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * 输出：[1,2,3,4]
 * @author yzy15
 * @date 2023/04/15 10:14
 **/
public class FlowerPlantingWithNoAdjacent {
    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] path : paths) {
            int x = path[0], y = path[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int[] res = new int[n];

        for (int i = 1; i <= n; i++) {
            boolean[] used = new boolean[5];

            for (int neighbor : graph.get(i)) {
                used[res[neighbor - 1]] = true;
            }

            for (int color = 1; color <= 4; color++) {
                if (!used[color]) {
                    res[i - 1] = color;
                    break;
                }
            }
        }

        return res;
    }
}
