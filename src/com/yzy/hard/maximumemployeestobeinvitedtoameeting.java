package com.yzy.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.hard
 * @Date 2023/11/01 00:04
 * @Description
 * 一个公司准备组织一场会议，邀请名单上有 n 位员工。公司准备了一张 圆形 的桌子，可以坐下 任意数目 的员工。
 *
 * 员工编号为 0 到 n - 1 。每位员工都有一位 喜欢 的员工，每位员工 当且仅当 他被安排在喜欢员工的旁边，他才会参加会议。每位员工喜欢的员工 不会 是他自己。
 *
 * 给你一个下标从 0 开始的整数数组 favorite ，其中 favorite[i] 表示第 i 位员工喜欢的员工。请你返回参加会议的 最多员工数目 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：favorite = [2,2,1,2]
 * 输出：3
 * 解释：
 * 上图展示了公司邀请员工 0，1 和 2 参加会议以及他们在圆桌上的座位。
 * 没办法邀请所有员工参与会议，因为员工 2 没办法同时坐在 0，1 和 3 员工的旁边。
 * 注意，公司也可以邀请员工 1，2 和 3 参加会议。
 * 所以最多参加会议的员工数目为 3 。
 * 示例 2：
 *
 * 输入：favorite = [1,2,0]
 * 输出：3
 * 解释：
 * 每个员工都至少是另一个员工喜欢的员工。所以公司邀请他们所有人参加会议的前提是所有人都参加了会议。
 * 座位安排同图 1 所示：
 * - 员工 0 坐在员工 2 和 1 之间。
 * - 员工 1 坐在员工 0 和 2 之间。
 * - 员工 2 坐在员工 1 和 0 之间。
 * 参与会议的最多员工数目为 3 。
 * 示例 3：
 *
 *
 *
 * 输入：favorite = [3,0,1,4,1]
 * 输出：4
 * 解释：
 * 上图展示了公司可以邀请员工 0，1，3 和 4 参加会议以及他们在圆桌上的座位。
 * 员工 2 无法参加，因为他喜欢的员工 0 旁边的座位已经被占领了。
 * 所以公司只能不邀请员工 2 。
 * 参加会议的最多员工数目为 4 。
 * @Version 1.0
 */
public class maximumemployeestobeinvitedtoameeting {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        List<int[]> singles = new ArrayList<>();
        boolean[] vis = new boolean[n];
        int[] loop = new int[1];
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i]) {
                continue;
            }
            search(singles, vis, i, -1, favorite, time, 1, loop);
        }
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int from = favorite[i];
            g[from].add(i);
        }
        int sum = 0;
        for (int[] single : singles) {
            int n1 = single[0], n2 = single[1];
            sum += 2 + bfs(g, n1, n2) + bfs(g, n2, n1);
        }
        return Math.max(loop[0], sum);
    }
    private static int bfs(List<Integer>[] g, int from, int fob){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(from);
        int step = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Integer p = deque.pop();
                List<Integer> ns = g[p];
                for (Integer next : ns) {
                    if (next == fob)
                        continue;
                    deque.offer(next);
                }
            }
            step++;
        }
        return step - 1;
    }
    private static void search(List<int[]> singles, boolean[] vis, int now, int fa,
                               int[] favorite, int[] time, int t, int[] loop){
        if (vis[now]){
            if (time[now] == -1)
                return;
            else {
                int len = t - time[now];
                if (len == 2){
                    singles.add(new int[]{now, fa});
                }else {
                    loop[0] = Math.max(loop[0], len);
                }
                return;
            }
        }
        time[now] = t;
        vis[now] = true;
        search(singles, vis, favorite[now], now, favorite, time, t + 1, loop);
        time[now] = -1;
    }
}