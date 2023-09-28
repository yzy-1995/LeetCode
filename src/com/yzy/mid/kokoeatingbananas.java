package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/29 00:04
 * @Description
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 * 示例 2：
 *
 * 输入：piles = [30,11,23,4,20], h = 5
 * 输出：30
 * 示例 3：
 *
 * 输入：piles = [30,11,23,4,20], h = 6
 * 输出：23
 * @Version 1.0
 */
public class kokoeatingbananas {
    public int minEatingSpeed(int[] piles, int h) {
        // 首先确定 x 的范围
        int left = 1;
        // 最大速度应该为给定数组中的最大数
        int MAX_PILES = 1;
        for (int i = 0; i < piles.length; i++) {
            if (MAX_PILES <= piles[i]) {
                MAX_PILES = piles[i];
            }
        }
        int right = MAX_PILES;

        while (left <= right) {
            int mid = left + right >> 1;
            if (f(piles, mid) <= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * h = f(x)
     *
     * @param piles
     * @param k
     * @return
     */
    public long f(int[] piles, int k) {
        long hour = 0;
        for (int i = 0; i < piles.length; i++) {
            hour += piles[i] / k;
            // 剩余不足 k 根，也按一小时算
            if (piles[i] % k > 0) {
                hour++;
            }
        }
        return hour;
    }
}