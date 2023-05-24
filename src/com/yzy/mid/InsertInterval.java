package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: InsertInterval
 * Description:
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 示例 1：
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 示例 3：
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * 示例 4：
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * 示例 5：
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 *
 * @author Administrator
 * @date 2023-5-23 9:54
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        int n = newInterval.length;
        int index = 0;
        List<int[]> res = new ArrayList<>();
        while (index < n && intervals[index][1] < left) {
            res.add(intervals[index++]);
        }
        while (index < n && intervals[index][0] <= right) {
            left = Math.min(left, intervals[index][0]);
            right = Math.max(intervals[index++][0], right);
        }
        res.add(new int[]{left, right});
        while (index < n) {
            res.add(intervals[index++]);
        }
        return res.toArray(new int[res.size()][]);
    }

}
