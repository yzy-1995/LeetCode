package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: DeliverInformation
 * Description:
 * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 * <p>
 * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。
 * 传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
 * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。
 * 返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 * 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
 * 输出：3
 * 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
 * <p>
 * 输入：n = 3, relation = [[0,2],[2,1]], k = 2
 * 输出：0
 * 解释：信息不能从小 A 处经过 2 轮传递到编号 2
 *
 * @author Administrator
 * @date 2023-3-27 10:50
 */
public class DeliverInformation {
    int ways, n, k;
    List<List<Integer>> edges;

    public static void main(String[] args) {
        int[][] a = {
                {0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}
        };
        DeliverInformation deliverInformation = new DeliverInformation();
        System.out.println(deliverInformation.numWays(5, a, 3));
    }

    /**
     * 可以把传信息的关系看成有向图，每个玩家对应一个节点，每个传信息的关系对应一条有向边。
     * 如果 x 可以向 y 传信息，则对应从节点 x 到节点 y 的一条有向边。
     * 寻找从编号 0 的玩家经过 k 轮传递到编号 n−1 的玩家处的方案数，
     * 等价于在有向图中寻找从节点 0 到节点 n−1 的长度为 k 的路径数，
     * 同一条路径可以重复经过同一个节点。
     * <p>
     * 可以使用深度优先搜索计算方案数。从节点 0 出发做深度优先搜索，
     * 每一步记录当前所在的节点以及经过的轮数，当经过 k 轮时，如果位于节点 n−1，
     * 则将方案数加 1。搜索结束之后，即可得到总的方案数。
     * <p>
     * 具体实现方面，可以对传信息的关系进行预处理，使用列表存储有向边的关系，
     * 即可在 O(1) 的时间内得到特定节点的相邻节点（即可以沿着有向边一步到达的节点）。
     *
     * @param n
     * @param relation
     * @param k
     * @return
     */
    public int numWays(int n, int[][] relation, int k) {
        ways = 0;
        this.n = n;
        this.k = k;
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int[] edge : relation) {
            int src = edge[0], dst = edge[1];
            edges.get(src).add(dst);
        }
        dfs(0, 0);
        return ways;
    }

    public void dfs(int index, int steps) {
        if (steps == k) {
            if (index == n - 1) {
                ways++;
            }
            return;
        }
        List<Integer> list = edges.get(index);
        for (int nextIndex : list) {
            dfs(nextIndex, steps + 1);
        }
    }

    /**
     * 前两种方法都是通过在图中搜索计算方案数。可以换一个思路，这道题是计数问题，可以使用动态规划的方法解决。
     *
     * 定义动态规划的状态 dp[i][j]为经过 i 轮传递到编号 j 的玩家的方案数，其中 0≤i≤k  0≤j<n。
     *
     * 由于从编号 0 的玩家开始传递，当 i=0 时，一定位于编号 0 的玩家，不会传递到其他玩家，因此动态规划的边界情况如下：
     * dp[0][j]={1,j=0
     * 0,j!=0
     * }
     * 对于传信息的关系 [src,dst]，如果第 i 轮传递到编号 src 的玩家，则第 i+1 轮可以从编号 src 的玩家传递到编号 dst 的玩家。
     * 因此在计算 dp[i+1][dst] 时，需要考虑可以传递到编号 dst的所有玩家。由此可以得到动态规划的状态转移方程，其中 0≤i<k：
     * 最终得到 dp[k][n−1]\textit{dp}[k][n-1]dp[k][n−1] 即为总的方案数。
     */
    public int numWays1(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] edge : relation) {
                int src = edge[0], dst = edge[1];
                dp[i + 1][dst] += dp[i][src];
            }
        }
        return dp[k][n - 1];
    }

}
