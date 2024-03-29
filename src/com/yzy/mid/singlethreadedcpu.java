package com.yzy.mid;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/02/09 17:28
 * @Description
 * 给你一个二维数组 tasks ，用于表示 n​​​​​​ 项从 0 到 n - 1 编号的任务。其中 tasks[i] = [enqueueTimei, processingTimei] 意味着第 i​​​​​​​​​​ 项任务将会于 enqueueTimei 时进入任务队列，需要 processingTimei 的时长完成执行。
 *
 * 现有一个单线程 CPU ，同一时间只能执行 最多一项 任务，该 CPU 将会按照下述方式运行：
 *
 * 如果 CPU 空闲，且任务队列中没有需要执行的任务，则 CPU 保持空闲状态。
 * 如果 CPU 空闲，但任务队列中有需要执行的任务，则 CPU 将会选择 执行时间最短 的任务开始执行。如果多个任务具有同样的最短执行时间，则选择下标最小的任务开始执行。
 * 一旦某项任务开始执行，CPU 在 执行完整个任务 前都不会停止。
 * CPU 可以在完成一项任务后，立即开始执行一项新任务。
 * 返回 CPU 处理任务的顺序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：tasks = [[1,2],[2,4],[3,2],[4,1]]
 * 输出：[0,2,3,1]
 * 解释：事件按下述流程运行：
 * - time = 1 ，任务 0 进入任务队列，可执行任务项 = {0}
 * - 同样在 time = 1 ，空闲状态的 CPU 开始执行任务 0 ，可执行任务项 = {}
 * - time = 2 ，任务 1 进入任务队列，可执行任务项 = {1}
 * - time = 3 ，任务 2 进入任务队列，可执行任务项 = {1, 2}
 * - 同样在 time = 3 ，CPU 完成任务 0 并开始执行队列中用时最短的任务 2 ，可执行任务项 = {1}
 * - time = 4 ，任务 3 进入任务队列，可执行任务项 = {1, 3}
 * - time = 5 ，CPU 完成任务 2 并开始执行队列中用时最短的任务 3 ，可执行任务项 = {1}
 * - time = 6 ，CPU 完成任务 3 并开始执行任务 1 ，可执行任务项 = {}
 * - time = 10 ，CPU 完成任务 1 并进入空闲状态
 * 示例 2：
 *
 * 输入：tasks = [[7,10],[7,12],[7,5],[7,4],[7,2]]
 * 输出：[4,3,2,0,1]
 * 解释：事件按下述流程运行：
 * - time = 7 ，所有任务同时进入任务队列，可执行任务项  = {0,1,2,3,4}
 * - 同样在 time = 7 ，空闲状态的 CPU 开始执行任务 4 ，可执行任务项 = {0,1,2,3}
 * - time = 9 ，CPU 完成任务 4 并开始执行任务 3 ，可执行任务项 = {0,1,2}
 * - time = 13 ，CPU 完成任务 3 并开始执行任务 2 ，可执行任务项 = {0,1}
 * - time = 18 ，CPU 完成任务 2 并开始执行任务 0 ，可执行任务项 = {1}
 * - time = 28 ，CPU 完成任务 0 并开始执行任务 1 ，可执行任务项 = {}
 * - time = 40 ，CPU 完成任务 1 并进入空闲状态
 * @Version 1.0
 */
public class singlethreadedcpu {
    public int[] getOrder(int[][] tasks) {
        /*
        堆+模拟:
        看数据范围得知需要时间复杂度为:O(N)或者O(logN)的算法
        维护一个当前时刻curTime，再用一个优先队列维护当前在队列里面的任务
        其中优先队列要保证队列里的元素按照执行时间的长短进行排序，执行时间长短一致就按照索引升序
        每一个任务弹出对应一个任务执行，curTime跳至当前任务执行完的时刻
        把当前任务执行完的时刻，对应能够入队的就进行入队
        注意:
        1.执行完任务的时间可能会使得int溢出，因此用long
        2.初始跳到首批入队的节点可能不止1个,curTime跳至对应时刻
        3.中间可能出现断档的情况，断档后跳至下一个任务处，注意入队的节点可能不止一个，curTime跳至对应时刻
         */
        int n = tasks.length;
        int[] res = new int[n];
        // [进队时间，时长，索引]
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        // 按照进队时间升序排序
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        // 小顶堆模拟[进队时间，索引]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        long curTime = arr[0][0];
        int idx = 0, resId = 0;
        // 初始入队
        while (idx < n && arr[idx][0] == curTime) pq.add(arr[idx++]);
        // 开启模拟
        while (!pq.isEmpty()) {
            // 执行当前任务
            int[] poll = pq.poll();
            res[resId++] = poll[2];
            curTime += poll[1]; // curTime跳至执行完当前任务时刻
            // 执行完当前任务后，相应进入队列
            while (idx < n && arr[idx][0] <= curTime) pq.add(arr[idx++]);
            // 断档了，curTime跳到写一个可执行的任务处(注意可能有多个)
            if (pq.isEmpty() && idx < n) {
                curTime = arr[idx][0];
                while (idx < n && arr[idx][0] == curTime) pq.add(arr[idx++]);
            }
        }
        return res;
    }
}