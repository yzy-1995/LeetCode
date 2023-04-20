package com.yzy.simple;

/**
 * ClassName: LargestTriangleArea
 * Description:
 * 给你一个由 X-Y 平面上的点组成的数组 points ，其中 points[i] = [xi, yi] 。
 * 从其中取任意三个不同的点组成三角形，返回能组成的最大三角形的面积。
 * 与真实值误差在 10-5 内的答案将会视为正确答案。
 * 示例 1：
 * 输入：points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * 输出：2.00000
 * 解释：输入中的 5 个点如上图所示，红色的三角形面积最大。
 * 示例 2：
 * 输入：points = [[1,0],[0,0],[0,1]]
 * 输出：0.50000
 *
 * @author Administrator
 * @date 2023-4-20 15:19
 */
public class LargestTriangleArea {
    public static void main(String[] args) {

    }

    public double largestTriangleArea(int[][] points) {
        double maxArea = 0;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    double area = 0.5 * Math.abs(points[i][0] * (points[j][1] - points[k][1]) +
                            points[j][0] * (points[k][1] - points[i][1]) +
                            points[k][0] * (points[i][1] - points[j][1]));
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}
