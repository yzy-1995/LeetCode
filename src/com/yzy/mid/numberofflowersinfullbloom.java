package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/28 00:02
 * @Description
 * 给你一个下标从 0 开始的二维整数数组 flowers ，其中 flowers[i] = [starti, endi] 表示第 i 朵花的 花期 从 starti 到 endi （都 包含）。同时给你一个下标从 0 开始大小为 n 的整数数组 people ，people[i] 是第 i 个人来看花的时间。
 *
 * 请你返回一个大小为 n 的整数数组 answer ，其中 answer[i]是第 i 个人到达时在花期内花的 数目 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：flowers = [[1,6],[3,7],[9,12],[4,13]], people = [2,3,7,11]
 * 输出：[1,2,2,2]
 * 解释：上图展示了每朵花的花期时间，和每个人的到达时间。
 * 对每个人，我们返回他们到达时在花期内花的数目。
 * 示例 2：
 *
 *
 *
 * 输入：flowers = [[1,10],[3,3]], people = [3,3,2]
 * 输出：[2,2,1]
 * 解释：上图展示了每朵花的花期时间，和每个人的到达时间。
 * 对每个人，我们返回他们到达时在花期内花的数目。
 * @Version 1.0
 */
public class numberofflowersinfullbloom {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int len = flowers.length;
        int[] start = new int[len];//记录开花的时刻
        int[] end = new int[len];//记录花闭的时刻
        int[] res = new int[persons.length];

        for(int i = 0; i < len; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);
        /** person来看花的每个时刻都可以用二分法去找到 当前时刻以前最大的开花时刻 和 当前时刻以前 花闭的时刻
         差值就是在花期内开花的数目
         */
        for(int i = 0; i < persons.length; i++) {
            int time = persons[i];
            int i1 = 0, j1 = len;
            int i2 = 0, j2 = len;
            while(i1 < j1) {
                int mid = (i1+j1) >>> 1;
                if(time >= start[mid]) i1 = mid + 1;
                else j1 = mid;
            }
            while(i2 < j2) {
                int mid = (i2+j2) >>> 1;
                if(time > end[mid]) i2 = mid+1;
                else j2 = mid;
            }
            res[i] = j1-j2;
        }
        return res;
    }
}