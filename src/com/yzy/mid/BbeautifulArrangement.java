package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/04 00:02
 * @Description
 * 假设有从 1 到 n 的 n 个整数。用这些整数构造一个数组 perm（下标从 1 开始），只要满足下述条件 之一 ，该数组就是一个 优美的排列 ：
 *
 * perm[i] 能够被 i 整除
 * i 能够被 perm[i] 整除
 * 给你一个整数 n ，返回可以构造的 优美排列 的 数量 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 解释：
 * 第 1 个优美的排列是 [1,2]：
 *     - perm[1] = 1 能被 i = 1 整除
 *     - perm[2] = 2 能被 i = 2 整除
 * 第 2 个优美的排列是 [2,1]:
 *     - perm[1] = 2 能被 i = 1 整除
 *     - i = 2 能被 perm[2] = 1 整除
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 * @Version 1.0
 */
public class BbeautifulArrangement {
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        return backtrack(visited, 1);
    }

    private int backtrack(boolean[] visited, int pos) {
        if (pos == visited.length) {
            return 1;
        }

        int count = 0;
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i] && (i % pos == 0 || pos % i == 0)) {
                visited[i] = true;
                count += backtrack(visited, pos + 1);
                visited[i] = false;
            }
        }

        return count;
    }
}