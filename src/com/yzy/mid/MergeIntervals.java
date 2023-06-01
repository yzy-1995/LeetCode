package com.yzy.mid;

import java.util.Arrays;

/**
 * ClassName: MergeIntervals
 * Description:
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * @author Administrator
 * @date 2023-5-23 9:24
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        sorted(intervals, 0, n - 1);
        int j = 0;
        for (int i = 1; i < n; i++) {
            if (intervals[j][1] >= intervals[i][0]) {
                intervals[j][1] = Math.max(intervals[j][1], intervals[i][1]);
            } else {
                j++;
                intervals[j] = intervals[i];
            }
        }
        return Arrays.copyOf(intervals, j + 1);
    }

    private void sorted(int[][] intervals, int left, int right) {
        if (left > right) {
            return;
        }
        int[] x = intervals[right];
        int index = left;
        for (int i = left; i < right; i++) {
            if (intervals[i][0] < x[0]) {
                int[] temp = intervals[index];
                intervals[index] = intervals[i];
                intervals[i] = temp;
                index++;
            }
        }
        intervals[right] = intervals[index];
        intervals[index] = x;
        sorted(intervals, left, index - 1);
        sorted(intervals, index + 1, right);
    }
}
