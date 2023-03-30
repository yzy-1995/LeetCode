package com.yzy.mid;

import java.util.Arrays;

/**
 * ClassName: WidestVerticalAreaBetweenTwoPointsContainingNoPoints
 * Description:
 * 给你 n 个二维平面上的点 points ，其中 points[i] = [xi, yi] ，请你返回两点之间内部不包含任何点的 最宽垂直区域 的宽度。
 *
 * 垂直区域 的定义是固定宽度，而 y 轴上无限延伸的一块区域（也就是高度为无穷大）。 最宽垂直区域 为宽度最大的一个垂直区域。
 *
 * 请注意，垂直区域 边上 的点 不在 区域内。
 * @author Administrator
 * @date 2023-3-30 9:23
 */
public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {

    public static void main(String[] args) {

    }

    /**
     * 由于最宽垂直区域是指宽度最大的垂直区域，因此我们需要找到所有垂直区域中宽度最大的那个。
     *
     * 因为垂直区域是指固定宽度的区域，因此我们可以将所有点按照横坐标从小到大排序，
     * 然后依次计算相邻两个点之间的垂直区域的宽度，并找到其中最大的那个。
     *
     * 具体来说，我们可以先将所有点按照横坐标从小到大排序，然后依次计算相邻两个点之间的垂直区域的宽度，
     * 并更新最大宽度。对于相邻的两个点points[i]和points[i+1]，它们之间的垂直区域宽度为points[i+1][0]-points[i][0]，
     * 因为该区域的左右边界分别为points[i][0]和points[i+1][0]，且该区域内不包含其他点，
     * 因此该区域是一个合法的垂直区域。我们可以在计算过程中更新最大宽度，并最终返回结果即可。
     * @param points
     * @return
     */
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int max = 0;
        for (int i = 1; i < points.length; i++) {
            max = Math.max(max, points[i][0] - points[i-1][0]);
        }
        return max;
    }
}
