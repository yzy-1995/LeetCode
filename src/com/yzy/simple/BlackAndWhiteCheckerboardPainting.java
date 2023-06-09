package com.yzy.simple;

import java.util.List;

/**
 * ClassName: BlackAndWhiteCheckerboardPainting
 * Description:
 * 小扣注意到秋日市集上有一个创作黑白方格画的摊位。摊主给每个顾客提供一个固定在墙上的白色画板，
 * 画板不能转动。画板上有 n * n 的网格。绘画规则为，小扣可以选择任意多行以及任意多列的格子涂成黑色
 * （选择的整行、整列均需涂成黑色），所选行数、列数均可为 0。
 * 小扣希望最终的成品上需要有 k 个黑色格子，请返回小扣共有多少种涂色方案。
 * 注意：两个方案中任意一个相同位置的格子颜色不同，就视为不同的方案。
 * 示例 1：
 * 输入：n = 2, k = 2
 * 输出：4
 * 解释：一共有四种不同的方案： 第一种方案：涂第一列； 第二种方案：涂第二列； 第三种方案：涂第一行； 第四种方案：涂第二行。
 *
 * @author Administrator
 * @date 2023-3-27 14:51
 */
public class BlackAndWhiteCheckerboardPainting {
    public static void main(String[] args) {
        BlackAndWhiteCheckerboardPainting blackAndWhiteCheckerboard = new BlackAndWhiteCheckerboardPainting();
        int i = blackAndWhiteCheckerboard.paintingPlan(2, 3);
        System.out.println(i);

    }

    public int paintingPlan(int n, int k) {
        int count = 0;
        if (k == n * n) {
            return 1;
        }
        if (k == 0) {
            return 1;
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if ((i * n) + (j * n) - (i * j) == k) {
                    count += combination(i, n) * combination(j, n);
                }
            }
        }

        return count;
    }

    private int combination(int a, int b) {
        if (a == 0) {
            return 1;
        }
        int n = 1;
        for (int i = 0; i < a; i++) {
            n *= (b - i);
        }
        for (int i = 1; i <= a; i++) {
            n /= i;
        }
        return n;
    }
}
