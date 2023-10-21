package com.yzy.mid;

import java.util.PriorityQueue;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/17 16:30
 * @Description
 * 给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，并且是一个整数 k ，返回离原点 (0,0) 最近的 k 个点。
 *
 * 这里，平面上两点之间的距离是 欧几里德距离（ √(x1 - x2)2 + (y1 - y2)2 ）。
 *
 * 你可以按 任何顺序 返回答案。除了点坐标的顺序之外，答案 确保 是 唯一 的。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：points = [[1,3],[-2,2]], k = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 *
 * 输入：points = [[3,3],[5,-1],[-2,4]], k = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 * @Version 1.0
 */
public class kclosestpointstoorigin {
    public int[][] kClosest(int[][] points, int k) {
        //建立大根堆求前k小即可
        //记 n为points长度，则时间复杂度：o(nlogk)  空间复杂度：o(k)
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) -> b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]);
        for(int[] p : points)
        {
            if(pq.size() < k) pq.offer(p);
            else
            {
                int[] t = pq.peek();
                if(p[0] * p[0] + p[1] * p[1] < t[0] * t[0] + t[1] * t[1])
                {
                    pq.poll();
                    pq.offer(p);
                }
            }
        }
        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++) ans[i] = pq.poll();
        return ans;
    }
}