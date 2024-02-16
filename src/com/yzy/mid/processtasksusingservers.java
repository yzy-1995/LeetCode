package com.yzy.mid;

import java.util.PriorityQueue;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/02/16 16:49
 * @Description
 *
 * 给你两个 下标从 0 开始 的整数数组 servers 和 tasks ，长度分别为 n​​​​​​ 和 m​​​​​​ 。servers[i] 是第 i​​​​​​​​​​ 台服务器的 权重 ，而 tasks[j] 是处理第 j​​​​​​ 项任务 所需要的时间（单位：秒）。
 *
 * 你正在运行一个仿真系统，在处理完所有任务后，该系统将会关闭。每台服务器只能同时处理一项任务。第 0 项任务在第 0 秒可以开始处理，相应地，第 j 项任务在第 j 秒可以开始处理。处理第 j 项任务时，你需要为它分配一台 权重最小 的空闲服务器。如果存在多台相同权重的空闲服务器，请选择 下标最小 的服务器。如果一台空闲服务器在第 t 秒分配到第 j 项任务，那么在 t + tasks[j] 时它将恢复空闲状态。
 *
 * 如果没有空闲服务器，则必须等待，直到出现一台空闲服务器，并 尽可能早 地处理剩余任务。 如果有多项任务等待分配，则按照 下标递增 的顺序完成分配。
 *
 * 如果同一时刻存在多台空闲服务器，可以同时将多项任务分别分配给它们。
 *
 * 构建长度为 m 的答案数组 ans ，其中 ans[j] 是第 j 项任务分配的服务器的下标。
 *
 * 返回答案数组 ans​​​​ 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：servers = [3,3,2], tasks = [1,2,3,2,1,2]
 * 输出：[2,2,0,2,1,2]
 * 解释：事件按时间顺序如下：
 * - 0 秒时，第 0 项任务加入到任务队列，使用第 2 台服务器处理到 1 秒。
 * - 1 秒时，第 2 台服务器空闲，第 1 项任务加入到任务队列，使用第 2 台服务器处理到 3 秒。
 * - 2 秒时，第 2 项任务加入到任务队列，使用第 0 台服务器处理到 5 秒。
 * - 3 秒时，第 2 台服务器空闲，第 3 项任务加入到任务队列，使用第 2 台服务器处理到 5 秒。
 * - 4 秒时，第 4 项任务加入到任务队列，使用第 1 台服务器处理到 5 秒。
 * - 5 秒时，所有服务器都空闲，第 5 项任务加入到任务队列，使用第 2 台服务器处理到 7 秒。
 * 示例 2：
 *
 * 输入：servers = [5,1,4,3,2], tasks = [2,1,2,4,5,2,1]
 * 输出：[1,4,1,4,1,3,2]
 * 解释：事件按时间顺序如下：
 * - 0 秒时，第 0 项任务加入到任务队列，使用第 1 台服务器处理到 2 秒。
 * - 1 秒时，第 1 项任务加入到任务队列，使用第 4 台服务器处理到 2 秒。
 * - 2 秒时，第 1 台和第 4 台服务器空闲，第 2 项任务加入到任务队列，使用第 1 台服务器处理到 4 秒。
 * - 3 秒时，第 3 项任务加入到任务队列，使用第 4 台服务器处理到 7 秒。
 * - 4 秒时，第 1 台服务器空闲，第 4 项任务加入到任务队列，使用第 1 台服务器处理到 9 秒。
 * - 5 秒时，第 5 项任务加入到任务队列，使用第 3 台服务器处理到 7 秒。
 * - 6 秒时，第 6 项任务加入到任务队列，使用第 2 台服务器处理到 7 秒。
 * @Version 1.0
 */
public class processtasksusingservers {
    class Node {
        int index;
        int weight;
        long start;
        long end;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        // 空闲的服务器
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight == b.weight ? a.index - b.index : a.weight - b.weight);
        // 任务执行队列
        PriorityQueue<Node> execute = new PriorityQueue<>((a, b) -> (int) (a.end - b.end));

        for (int i = 0; i < n; i++) {
            pq.offer(new Node(i, servers[i]));
        }
        // 当前的时间线
        long time = 0;
        // 当前该执行第几个任务
        int curTask = 0;

        int[] res = new int[m];

        while (true) {
            Node node = null;

            // 检查是否有任务结束,如果有任务结束,那么释放服务器
            while (!execute.isEmpty() && execute.peek().end == time) {
                pq.offer(execute.poll());
            }

            // 检查是否有可以开始的任务,如果有,添加任务到执行队列
            while (!pq.isEmpty() && time >= curTask && curTask < m) {
                // 从服务器集合中找到一个空闲的服务器
                node = pq.poll();
                // 设置任务的开始执行时间
                node.start = time;
                // 返回结果设置
                res[curTask] = node.index;
                // 设置任务的结束时间
                node.end = time + tasks[curTask++];
                // 将任务加入队列
                execute.offer(node);
            }
            // 不超时的关键步骤
            if (!execute.isEmpty() && time > curTask) {
                time = execute.peek().end;
            } else {
                time++;
            }
            if (curTask >= m) break;
        }
        return res;
    }
}