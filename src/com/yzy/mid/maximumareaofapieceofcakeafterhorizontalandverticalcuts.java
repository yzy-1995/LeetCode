package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/27 02:47
 * @Description
 * 矩形蛋糕的高度为 h 且宽度为 w，给你两个整数数组 horizontalCuts 和 verticalCuts，其中：
 *
 *  horizontalCuts[i] 是从矩形蛋糕顶部到第  i 个水平切口的距离
 * verticalCuts[j] 是从矩形蛋糕的左侧到第 j 个竖直切口的距离
 * 请你按数组 horizontalCuts 和 verticalCuts 中提供的水平和竖直位置切割后，请你找出 面积最大 的那份蛋糕，并返回其 面积 。由于答案可能是一个很大的数字，因此需要将结果 对 109 + 7 取余 后返回。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
 * 输出：4
 * 解释：上图所示的矩阵蛋糕中，红色线表示水平和竖直方向上的切口。切割蛋糕后，绿色的那份蛋糕面积最大。
 * 示例 2：
 *
 *
 *
 * 输入：h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
 * 输出：6
 * 解释：上图所示的矩阵蛋糕中，红色线表示水平和竖直方向上的切口。切割蛋糕后，绿色和黄色的两份蛋糕面积最大。
 * 示例 3：
 *
 * 输入：h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
 * 输出：9
 * @Version 1.0
 */
public class maximumareaofapieceofcakeafterhorizontalandverticalcuts {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int N = horizontalCuts.length;
        int M = verticalCuts.length;
        long rowMax = Math.max(horizontalCuts[0], h - horizontalCuts[N - 1]);
        long colMax = Math.max(verticalCuts[0], w - verticalCuts[M - 1]);
        for (int i = 0; i < N - 1; i++) {
            rowMax = Math.max(rowMax, horizontalCuts[i + 1] - horizontalCuts[i]);
        }
        for (int i = 0; i < M - 1; i++) {
            colMax = Math.max(colMax, verticalCuts[i + 1] - verticalCuts[i]);
        }
        return (int) (rowMax * colMax % 1_000_000_007);

    }
}