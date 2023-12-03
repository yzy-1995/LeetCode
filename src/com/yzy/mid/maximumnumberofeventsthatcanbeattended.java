package com.yzy.mid;

import java.util.*;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/29 00:40
 * @Description
 * 给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 endDayi 。
 *
 * 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。注意，一天只能参加一个会议。
 *
 * 请你返回你可以参加的 最大 会议数目。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：events = [[1,2],[2,3],[3,4]]
 * 输出：3
 * 解释：你可以参加所有的三个会议。
 * 安排会议的一种方案如上图。
 * 第 1 天参加第一个会议。
 * 第 2 天参加第二个会议。
 * 第 3 天参加第三个会议。
 * 示例 2：
 *
 * 输入：events= [[1,2],[2,3],[3,4],[1,2]]
 * 输出：4
 * @Version 1.0
 */
public class maximumnumberofeventsthatcanbeattended {
    public int maxEvents(int[][] events) {
        // max 为最后一个会议结束的时间
        int ans = 0, max = -1;
        // 按会议结束时间升序排序
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
        // key -> 第 i 天, value -> 第 i 天开始的会议的结束时间
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : events) {
            map.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            max = Math.max(e[1], max);
        }
        // 模拟
        for (int i = 1; i <= max; i++) {
            if (map.containsKey(i)) queue.addAll(map.get(i));
            while (!queue.isEmpty() && queue.peek() < i) queue.poll();
            if (!queue.isEmpty()) {
                ans++;
                queue.poll();
            }
        }
        return ans;
    }
}