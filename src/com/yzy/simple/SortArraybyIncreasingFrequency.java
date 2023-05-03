package com.yzy.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Description: leetcode1636
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 * 请你返回排序后的数组。
 * 示例 1：
 * 输入：nums = [1,1,2,2,2,3]
 * 输出：[3,1,1,2,2,2]
 * 解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
 * 示例 2：
 * 输入：nums = [2,3,1,3,2]
 * 输出：[1,3,3,2,2]
 * 解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
 * 示例 3：
 * 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
 * 输出：[5,-1,4,4,-6,-6,1,1,1]
 *
 * @author yzy15
 * @date 2023/04/30 23:48
 **/
public class SortArraybyIncreasingFrequency {
    public static void main(String[] args) {

    }

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            } else {
                return a[1] - b[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            queue.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        int[] result = new int[nums.length];
        int index = 0;
        while (!queue.isEmpty()) {
            int[] item = queue.poll();
            int value = item[0];
            int freq = item[1];
            for (int i = 0; i < freq; i++) {
                result[index++] = value;
            }
        }
        return result;
    }
}
