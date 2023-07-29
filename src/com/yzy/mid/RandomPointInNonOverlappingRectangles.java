package com.yzy.mid;

import java.util.Random;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/29 00:14
 * @Description
 * 给定一个由非重叠的轴对齐矩形的数组 rects ，其中 rects[i] = [ai, bi, xi, yi] 表示 (ai, bi) 是第 i 个矩形的左下角点，(xi, yi) 是第 i 个矩形的右上角点。设计一个算法来随机挑选一个被某一矩形覆盖的整数点。矩形周长上的点也算做是被矩形覆盖。所有满足要求的点必须等概率被返回。
 *
 * 在给定的矩形覆盖的空间内的任何整数点都有可能被返回。
 *
 * 请注意 ，整数点是具有整数坐标的点。
 *
 * 实现 Solution 类:
 *
 * Solution(int[][] rects) 用给定的矩形数组 rects 初始化对象。
 * int[] pick() 返回一个随机的整数点 [u, v] 在给定的矩形所覆盖的空间内。
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入:
 * ["Solution", "pick", "pick", "pick", "pick", "pick"]
 * [[[[-2, -2, 1, 1], [2, 2, 4, 6]]], [], [], [], [], []]
 * 输出:
 * [null, [1, -2], [1, -1], [-1, -2], [-2, -2], [0, 0]]
 *
 * 解释：
 * Solution solution = new Solution([[-2, -2, 1, 1], [2, 2, 4, 6]]);
 * solution.pick(); // 返回 [1, -2]
 * solution.pick(); // 返回 [1, -1]
 * solution.pick(); // 返回 [-1, -2]
 * solution.pick(); // 返回 [-2, -2]
 * solution.pick(); // 返回 [0, 0]
 * @Version 1.0
 */
public class RandomPointInNonOverlappingRectangles {
    private final int MAXN = 110;

    private int[] sum;

    private Random random;

    private int[][] rects;

    private int n;

    public RandomPointInNonOverlappingRectangles(int[][] rects) {
        this.rects = rects;
        this.n = rects.length;
        this.random = new Random();
        this.sum = new int[MAXN];
        for (int i = 1; i <= n; i++) {
            int[] rect = rects[i - 1];
            sum[i] = sum[i - 1] + (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
        }
    }

    public int[] pick() {
        int p = 1 + random.nextInt(sum[n]);
        int i = find(p);
        int id = p - sum[i - 1] - 1;
        int m = rects[i - 1][2] - rects[i - 1][0] + 1;
        int dy = id / m, dx = id % m;
        return new int[]{rects[i - 1][0] + dx, rects[i - 1][1] + dy};
    }

    private int find(int x) {
        int lo = 1, hi = n, ans = -1;
        while (lo <= hi) {
            int mid = lo + hi >> 1;
            int val = sum[mid];
            if (x > val) lo = mid + 1;
            else {
                ans = mid;
                hi = mid - 1;
            }
        }

        return ans;
    }
}