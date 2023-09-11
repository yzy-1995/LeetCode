package com.yzy.mid;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/11 22:02
 * @Description
 * 这里有 n 门不同的在线课程，按从 1 到 n 编号。给你一个数组 courses ，其中 courses[i] = [durationi, lastDayi] 表示第 i 门课将会 持续 上 durationi 天课，并且必须在不晚于 lastDayi 的时候完成。
 *
 * 你的学期从第 1 天开始。且不能同时修读两门及两门以上的课程。
 *
 * 返回你最多可以修读的课程数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：courses = [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
 * 输出：3
 * 解释：
 * 这里一共有 4 门课程，但是你最多可以修 3 门：
 * 首先，修第 1 门课，耗费 100 天，在第 100 天完成，在第 101 天开始下门课。
 * 第二，修第 3 门课，耗费 1000 天，在第 1100 天完成，在第 1101 天开始下门课程。
 * 第三，修第 2 门课，耗时 200 天，在第 1300 天完成。
 * 第 4 门课现在不能修，因为将会在第 3300 天完成它，这已经超出了关闭日期。
 * 示例 2：
 *
 * 输入：courses = [[1,2]]
 * 输出：1
 * 示例 3：
 *
 * 输入：courses = [[3,2],[4,3]]
 * 输出：0
 * @Version 1.0
 */
public class coursescheduleiii {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (o1, o2) -> o1[1] - o2[1]);
        // 优先队列用于替换最大, 因为数组已经按照lastTime排序了, 所以后面的课程一定可以替代前面的课程
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        // dp每一个位置的 <最小天数:最大课程门数>; 每次dp优先升级count,其次是降低days
        int[][] dp = new int[courses.length][2];
        if (courses[0][0] > courses[0][1]) {
            dp[0] = new int[]{0, 0};
        } else {
            dp[0] = new int[]{courses[0][0], 1};
            priorityQueue.add(courses[0][0]);
        }
        for (int i = 1; i < courses.length; i++) {
            int[] arr = courses[i];
            if (arr[0] > arr[1]) {
                dp[i] = dp[i - 1];
                continue;
            }
            // 如果时间够, 直接塞进去
            if (arr[0] + dp[i - 1][0] <= arr[1]) {
                dp[i] = new int[]{arr[0] + dp[i - 1][0], dp[i - 1][1] + 1};
                priorityQueue.add(arr[0]);
            } else {
                // 时间不够的情况下, 看下能不能替换之前比较耗时的课程
                Integer peek = priorityQueue.peek();
                if (null != peek && peek > arr[0]) {
                    Integer poll = priorityQueue.poll();
                    dp[i] = new int[]{arr[0] + dp[i - 1][0] - poll, dp[i - 1][1]};
                    priorityQueue.add(arr[0]);
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[courses.length - 1][1];
    }
}