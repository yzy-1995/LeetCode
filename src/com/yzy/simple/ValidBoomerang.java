package com.yzy.simple;

/**
 * Description: leetcode1037
 * 给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，如果这些点构成一个 回旋镖 则返回 true 。
 *
 * 回旋镖 定义为一组三个点，这些点 各不相同 且 不在一条直线上 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：points = [[1,1],[2,3],[3,2]]
 * 输出：true
 * 示例 2：
 *
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：false
 * @author yzy15
 * @date 2023/04/25 22:23
 **/
public class ValidBoomerang {
    public static void main(String[] args) {

    }

    public boolean isBoomerang(int[][] points) {
        int x1 = points[0][0];
        int y1 = points[0][1];
        int x2 = points[1][0];
        int y2 = points[1][1];
        int x3 = points[2][0];
        int y3 = points[2][1];

        return (x1 - x2) * (y1 - y3) != (x1 - x3) * (y1 - y2);
    }
}
