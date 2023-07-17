package com.yzy.mid;

import java.util.PriorityQueue;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/18 00:16
 * @Description 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
 * <p>
 * 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。注意 i 可能等于 j 。
 * <p>
 * 返回一个由每个区间 i 的 右侧区间 在 intervals 中对应下标组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,2]]
 * 输出：[-1]
 * 解释：集合中只有一个区间，所以输出-1。
 * 示例 2：
 * <p>
 * 输入：intervals = [[3,4],[2,3],[1,2]]
 * 输出：[-1,0,1]
 * 解释：对于 [3,4] ，没有满足条件的“右侧”区间。
 * 对于 [2,3] ，区间[3,4]具有最小的“右”起点;
 * 对于 [1,2] ，区间[2,3]具有最小的“右”起点。
 * 示例 3：
 * <p>
 * 输入：intervals = [[1,4],[2,3],[3,4]]
 * 输出：[-1,2,-1]
 * 解释：对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
 * 对于 [2,3] ，区间 [3,4] 有最小的“右”起点。
 * @Version 1.0
 */
public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        // <start, end, id>
        // 将 start 从小到大排序的 pq
        PriorityQueue<int[]> pqStart = new PriorityQueue<>((i1, i2) -> i1[0] - i2[0]);
        for (int i = 0; i < n; i++) {
            pqStart.offer(new int[]{intervals[i][0], intervals[i][1], i});
        }
        // 将 end 从小到大排序的 pq
        // pqEnd 内储存还未找到 right interval 的 interval
        PriorityQueue<int[]> pqEnd = new PriorityQueue<>((i1, i2) -> i1[1] - i2[1]);
        int[] ans = new int[n];
        while (!pqStart.isEmpty()) {
            int[] cur = pqStart.poll();
            pqEnd.offer(cur); // 将自己纳入潜在的 left interval
            while (!pqEnd.isEmpty() && pqEnd.peek()[1] <= cur[0]) {
                int[] pre = pqEnd.poll();
                ans[pre[2]] = cur[2];
            }
        }
        while (!pqEnd.isEmpty()) {
            int[] cur = pqEnd.poll();
            ans[cur[2]] = -1;
        }
        return ans;
    }
}