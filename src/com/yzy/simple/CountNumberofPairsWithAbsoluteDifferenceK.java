package com.yzy.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: CountNumberofPairsWithAbsoluteDifferenceK
 * Description:
 * 给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，满足 i < j 且 |nums[i] - nums[j]| == k 。
 * |x| 的值定义为：
 * 如果 x >= 0 ，那么值为 x 。
 * 如果 x < 0 ，那么值为 -x 。
 * 示例 1：
 * 输入：nums = [1,2,2,1], k = 1
 * 输出：4
 * 解释：差的绝对值为 1 的数对为：
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * 示例 2：
 * 输入：nums = [1,3], k = 3
 * 输出：0
 * 解释：没有任何数对差的绝对值为 3 。
 * 示例 3：
 * 输入：nums = [3,2,1,5,4], k = 2
 * 输出：3
 * 解释：差的绝对值为 2 的数对为：
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 *
 * @author Administrator
 * @date 2023-5-4 14:34
 */
public class CountNumberofPairsWithAbsoluteDifferenceK {
    public static void main(String[] args) {

    }

    public int countKDifference(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> numFrequency = new HashMap<>();

        for (int num : nums) {
            numFrequency.put(num, numFrequency.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : numFrequency.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();

            if (k > 0 && numFrequency.containsKey(num + k)) {
                count += frequency * numFrequency.get(num + k);
            } else if (k == 0) {
                count += (frequency * (frequency - 1)) / 2;
            }
        }

        return count;
    }
}
