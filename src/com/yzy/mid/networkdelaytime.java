package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/05 00:29
 * @Description
 * 有 n 个网络节点，标记为 1 到 n。
 *
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 *
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：times = [[1,2,1]], n = 2, k = 1
 * 输出：1
 * 示例 3：
 *
 * 输入：times = [[1,2,1]], n = 2, k = 2
 * 输出：-1
 * @Version 1.0
 */
public class networkdelaytime {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] len = new int[n+1][n+1];
        for (int i = 1; i < len.length; i++) {
            for (int j = 1; j < len[i].length; j++) {
                len[i][j] = i == j ? 0 : 0x3f3f3f3f;
            }
        }
        for (int i = 0; i < times.length; i++) {
            len[times[i][0]][times[i][1]] = times[i][2];
        }
        // 源k到其他节点的时长
        int[] w = new int[n+1];
        Arrays.fill(w, 0x3f3f3f3f);
        w[k] = 0; // k到k为0
        boolean[] via = new boolean[n+1]; // 是否确定到某节点的最小时长
        for (int i = 1; i <= n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!via[j] && (t == -1 || w[j] < w[t])) t = j;
            }
            via[t] = true;
            for (int j = 1; j <= n; j++) {
                w[j] = Math.min(w[j], w[t] + len[t][j]);
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, w[i]);
        }
        return res >= 0x3f3f3f3f ? -1 : res;
    }
}