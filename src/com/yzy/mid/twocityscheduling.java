package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/26 00:13
 * @Description
 * 公司计划面试 2n 人。给你一个数组 costs ，其中 costs[i] = [aCosti, bCosti] 。第 i 人飞往 a 市的费用为 aCosti ，飞往 b 市的费用为 bCosti 。
 *
 * 返回将每个人都飞到 a 、b 中某座城市的最低费用，要求每个城市都有 n 人抵达。
 *
 *
 *
 * 示例 1：
 *
 * 输入：costs = [[10,20],[30,200],[400,50],[30,20]]
 * 输出：110
 * 解释：
 * 第一个人去 a 市，费用为 10。
 * 第二个人去 a 市，费用为 30。
 * 第三个人去 b 市，费用为 50。
 * 第四个人去 b 市，费用为 20。
 *
 * 最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
 * 示例 2：
 *
 * 输入：costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
 * 输出：1859
 * 示例 3：
 *
 * 输入：costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
 * 输出：3086
 * @Version 1.0
 */
public class twocityscheduling {
    public int twoCitySchedCost(int[][] costs) {

        int sum = 0;
        Arrays.sort(costs, (a, b)->((a[0]-b[0] - (a[1] - b[1]))));
        for (int i = 0; i < costs.length; i++) {
            if (i < costs.length / 2) {
                sum += costs[i][0];
            } else {
                sum += costs[i][1];
            }
        }

        return sum;
    }
}