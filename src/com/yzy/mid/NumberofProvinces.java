package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/07 00:29
 * @Description
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * 示例 2：
 *
 *
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 * @Version 1.0
 */
public class NumberofProvinces {
    public int findCircleNum(int[][] M) {
        /**
         使用一个visited数组, 依次判断每个节点, 如果其未访问, 朋友圈数加1并对该节点进行dfs搜索标记所有访问到的节点
         **/
        boolean[] visited = new boolean[M.length];
        int ret = 0;
        for(int i = 0; i < M.length; ++i) {
            if(!visited[i]) {
                dfs(M, visited, i);
                ret++;
            }
        }
        return ret;
    }

    private void dfs(int[][] m, boolean[] visited, int i) {
        for(int j = 0; j < m.length; ++j) {
            if(m[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(m, visited, j);
            }
        }
    }
}