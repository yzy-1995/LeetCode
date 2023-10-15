package com.yzy.mid;

import java.util.HashSet;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/16 00:04
 * @Description
 * 给定在 xy 平面上的一组点，确定由这些点组成的任何矩形的最小面积，其中矩形的边不一定平行于 x 轴和 y 轴。
 *
 * 如果没有任何矩形，就返回 0。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[[1,2],[2,1],[1,0],[0,1]]
 * 输出：2.00000
 * 解释：最小面积的矩形出现在 [1,2],[2,1],[1,0],[0,1] 处，面积为 2。
 * 示例 2：
 *
 *
 *
 * 输入：[[0,1],[2,1],[1,1],[1,0],[2,0]]
 * 输出：1.00000
 * 解释：最小面积的矩形出现在 [1,0],[1,1],[2,1],[2,0] 处，面积为 1。
 * 示例 3：
 *
 *
 *
 * 输入：[[0,3],[1,2],[3,1],[1,3],[2,1]]
 * 输出：0
 * 解释：没法从这些点中组成任何矩形。
 * 示例 4：
 *
 *
 *
 * 输入：[[3,1],[1,1],[0,1],[2,1],[3,3],[3,2],[0,2],[2,3]]
 * 输出：2.00000
 * 解释：最小面积的矩形出现在 [2,1],[2,3],[3,3],[3,1] 处，面积为 2。
 * @Version 1.0
 */
public class minimumarearectangleii {
    public double minAreaFreeRect(int[][] points) {
        //三个点即可确定一个矩阵，所以枚举三个点，判断能否组成矩阵，再比较矩阵面积即可
        double ans = 2e10;
        int n = points.length;
        HashSet<String> set = new HashSet<>();
        for(int[] p : points) set.add(p[0] + " " + p[1]);
        for(int i = 0; i < n; i++)
        {
            int a1 = points[i][0], b1 = points[i][1];
            for(int j = i + 1; j < n; j++)
            {
                int a2 = points[j][0], b2 = points[j][1];
                int[] x = new int[]{a2 - a1, b2 -b1};
                for(int k = j + 1; k < n; k++)
                {
                    int a3 = points[k][0], b3 = points[k][1];
                    int[] y = new int[]{a3 - a1, b3 - b1};
                    int[] z = new int[]{a3 - a2, b3 - b2};
                    if(func(x, y))
                    {
                        int a4 = a2 + a3 - a1, b4 = b2 + b3 - b1;
                        if(set.contains(a4 + " " + b4)) ans = Math.min(ans, area(x, y));
                    }
                    else if(func(x, z))
                    {
                        int a4 = a1 + a3 - a2, b4 = b1 + b3 - b2;
                        if(set.contains(a4 + " " + b4)) ans = Math.min(ans, area(x, z));
                    }
                    else if(func(y, z))
                    {
                        int a4 = a1 + a2 - a3, b4 = b1 + b2 - b3;
                        if(set.contains(a4 + " " + b4)) ans = Math.min(ans, area(y, z));
                    }
                }
            }
        }
        return ans == 2e10 ? 0 : ans;
    }
    public double area(int[] x, int[] y)
    {
        return Math.sqrt(x[0]*x[0] + x[1]*x[1]) * Math.sqrt(y[0]*y[0] + y[1]*y[1]);
    }
    public boolean func(int[] x, int[] y)
    {
        return x[0]*y[0] + x[1]*y[1] == 0;
    }
}