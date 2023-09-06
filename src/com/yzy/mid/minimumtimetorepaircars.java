package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/07 00:03
 * @Description
 * 给你一个整数数组 ranks ，表示一些机械工的 能力值 。ranksi 是第 i 位机械工的能力值。能力值为 r 的机械工可以在 r * n2 分钟内修好 n 辆车。
 *
 * 同时给你一个整数 cars ，表示总共需要修理的汽车数目。
 *
 * 请你返回修理所有汽车 最少 需要多少时间。
 *
 * 注意：所有机械工可以同时修理汽车。
 *
 *
 *
 * 示例 1：
 *
 * 输入：ranks = [4,2,3,1], cars = 10
 * 输出：16
 * 解释：
 * - 第一位机械工修 2 辆车，需要 4 * 2 * 2 = 16 分钟。
 * - 第二位机械工修 2 辆车，需要 2 * 2 * 2 = 8 分钟。
 * - 第三位机械工修 2 辆车，需要 3 * 2 * 2 = 12 分钟。
 * - 第四位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
 * 16 分钟是修理完所有车需要的最少时间。
 * 示例 2：
 *
 * 输入：ranks = [5,1,8], cars = 6
 * 输出：16
 * 解释：
 * - 第一位机械工修 1 辆车，需要 5 * 1 * 1 = 5 分钟。
 * - 第二位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
 * - 第三位机械工修 1 辆车，需要 8 * 1 * 1 = 8 分钟。
 * 16 分钟时修理完所有车需要的最少时间。
 * @Version 1.0
 */
public class minimumtimetorepaircars {
    public long repairCars(int[] ranks, int cars) {
        // 能力值相同的员工数量
        int[] rankCnts = new int[101];
        for (int rank : ranks) rankCnts[rank]++;
        long leftTime = 0, rightTime = 100L * cars * cars;
        while (leftTime < rightTime) {
            long midTime = (leftTime + rightTime) >> 1;
            long repairCarCnt = 0L;
            for (int i = 1; i < rankCnts.length; i++) {
                if (rankCnts[i] != 0) {
                    long repairCar = (long) Math.sqrt(midTime / i);
                    repairCarCnt += repairCar * rankCnts[i];
                    if (repairCarCnt >= cars) break;
                }
            }
            if (repairCarCnt >= cars) {
                rightTime = midTime;
            } else {
                leftTime = midTime + 1;
            }
        }

        return rightTime;
    }
}