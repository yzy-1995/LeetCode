package com.yzy.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: DegreeofanArray
 * Description:leetcode697
 * 给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * 示例 1：
 * 输入：nums = [1,2,2,3,1]
 * 输出：2
 * 解释：
 * 输入数组的度是 2 ，因为元素 1 和 2 的出现频数最大，均为 2 。
 * 连续子数组里面拥有相同度的有如下所示：
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组 [2, 2] 的长度为 2 ，所以返回 2 。
 * 示例 2：
 * 输入：nums = [1,2,2,3,1,4,2]
 * 输出：6
 * 解释：
 * 数组的度是 3 ，因为元素 2 重复出现 3 次。
 * 所以 [2,2,3,1,4,2] 是最短子数组，因此返回 6 。
 * @author Administrator
 * @date 2023-4-18 10:22
 */
public class DegreeofanArray {
    public static void main(String[] args) {

    }

    /**
     * 1.使用三个 Map 来记录每个数字出现的次数、第一次出现的位置和最后一次出现的位置。
     * 2.遍历数组 nums，对于每个数字，更新它出现的次数和最后一次出现的位置，并记录它第一次出现的位置。
     * 3.记录数组中出现次数的最大值 maxCount，并遍历数组 nums，对于每个数字，如果它的出现次数等于 maxCount，
     * 则计算它对应的子数组的长度，并更新最短子数组的长度 minLength。
     * 返回 minLength。
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            maxCount = Math.max(maxCount, countMap.get(num));
            if (!leftMap.containsKey(num)) {
                leftMap.put(num, i);
            }
            rightMap.put(num, i);
        }
        int minLength = nums.length;
        for (int num : nums) {
            if (countMap.get(num) == maxCount) {
                int length = rightMap.get(num) - leftMap.get(num) + 1;
                minLength = Math.min(minLength, length);
            }
        }
        return minLength;

    }


}
