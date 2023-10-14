package com.yzy.mid;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/11 08:16
 * @Description
 * 给定在 xy 平面上的一组点，确定由这些点组成的矩形的最小面积，其中矩形的边平行于 x 轴和 y 轴。
 *
 * 如果没有任何矩形，就返回 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[1,1],[1,3],[3,1],[3,3],[2,2]]
 * 输出：4
 * 示例 2：
 *
 * 输入：[[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
 * 输出：2
 * @Version 1.0
 */
public class minimumarearectangle {
    public int minAreaRect(int[][] points) {
        Set<Integer> set = new HashSet<>();
        int res = Integer.MAX_VALUE;
        final int MAX = 40000;
        for (int[] point : points) {
            for (int[] anotherPoint : points) {
                if (point[0] == anotherPoint[0] || point[1] == anotherPoint[1])
                    continue;
                if (set.contains(point[0] * MAX + anotherPoint[1]) && set.contains(anotherPoint[0] * MAX + point[1]))
                    res = Math.min(res, Math.abs((point[0] - anotherPoint[0]) * (point[1] - anotherPoint[1])));
            }
            set.add(point[0] * MAX + point[1]);
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}