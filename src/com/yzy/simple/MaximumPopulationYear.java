package com.yzy.simple;

import java.util.Arrays;

/**
 * Description: leetcode1854
 * 给你一个二维整数数组 logs ，其中每个 logs[i] = [birthi, deathi] 表示第 i 个人的出生和死亡年份。
 * 年份 x 的 人口 定义为这一年期间活着的人的数目。第 i 个人被计入年份 x 的人口需要满足：x 在闭区间 [birthi, deathi - 1] 内。注意，人不应当计入他们死亡当年的人口中。
 * 返回 人口最多 且 最早 的年份。
 * 示例 1：
 * 输入：logs = [[1993,1999],[2000,2010]]
 * 输出：1993
 * 解释：人口最多为 1 ，而 1993 是人口为 1 的最早年份。
 * 示例 2：
 * 输入：logs = [[1950,1961],[1960,1971],[1970,1981]]
 * 输出：1960
 * 解释：
 * 人口最多为 2 ，分别出现在 1960 和 1970 。
 * 其中最早年份是 1960 。
 * @author yzy15
 * @date 2023/05/02 12:59
 **/
public class MaximumPopulationYear {
    public static void main(String[] args) {

    }

    public int maximumPopulation(int[][] logs) {
        int[] population = new int[101];
        for (int[] log : logs) {
            int birth = log[0] - 1950;
            int death = log[1] - 1950;
            for (int i = birth; i < death; i++) {
                population[i]++;
            }
        }
        int maxYear = 0;
        int maxPopulation = population[0];
        for (int i = 1; i < population.length; i++) {
            if (population[i] > maxPopulation) {
                maxPopulation = population[i];
                maxYear = i;
            }
        }
        return maxYear + 1950;
    }
}
