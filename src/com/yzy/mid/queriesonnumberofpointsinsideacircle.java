package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/02/08 15:01
 * @Description
 * 给你一个数组 points ，其中 points[i] = [xi, yi] ，表示第 i 个点在二维平面上的坐标。多个点可能会有 相同 的坐标。
 *
 * 同时给你一个数组 queries ，其中 queries[j] = [xj, yj, rj] ，表示一个圆心在 (xj, yj) 且半径为 rj 的圆。
 *
 * 对于每一个查询 queries[j] ，计算在第 j 个圆 内 点的数目。如果一个点在圆的 边界上 ，我们同样认为它在圆 内 。
 *
 * 请你返回一个数组 answer ，其中 answer[j]是第 j 个查询的答案。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
 * 输出：[3,2,2]
 * 解释：所有的点和圆如上图所示。
 * queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆。
 * 示例 2：
 *
 *
 * 输入：points = [[1,1],[2,2],[3,3],[4,4],[5,5]], queries = [[1,2,2],[2,2,2],[4,3,2],[4,3,3]]
 * 输出：[2,3,2,4]
 * 解释：所有的点和圆如上图所示。
 * queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆，queries[3] 是紫色的圆。
 *
 * @Version 1.0
 */
public class queriesonnumberofpointsinsideacircle {
    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int[] ans= new int[n];
        int index = 0;
        for (int[] querie : queries) {
            int x = querie[0], y = querie[1], r = querie[2], sum = 0;
            for (int[] point :points) {
                int dx = point[0] - x, dy = point[1] - y;
                if (dx * dx + dy * dy <= r * r) sum++;
            }
            ans[index++] = sum;
        }
        return ans;
    }
}