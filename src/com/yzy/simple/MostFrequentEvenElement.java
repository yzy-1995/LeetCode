package com.yzy.simple;

import java.lang.management.ManagementPermission;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/**
 * ClassName: MostFrequentEvenElement
 * Description:
 * 给你一个整数数组 nums ，返回出现最频繁的偶数元素。
 * <p>
 * 如果存在多个满足条件的元素，只需要返回 最小 的一个。如果不存在这样的元素，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,2,2,4,4,1]
 * 输出：2
 * 解释：
 * 数组中的偶数元素为 0、2 和 4 ，在这些元素中，2 和 4 出现次数最多。
 * 返回最小的那个，即返回 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [4,4,4,9,2,4]
 * 输出：4
 * 解释：4 是出现最频繁的偶数元素。
 * 示例 3：
 * <p>
 * 输入：nums = [29,47,21,41,13,37,25,7]
 * 输出：-1
 * 解释：不存在偶数元素。
 *
 * @author Administrator
 * @date 2023-4-13 9:09
 */
public class MostFrequentEvenElement {
    public static void main(String[] args) {
        MostFrequentEvenElement mostFrequentEvenElement = new MostFrequentEvenElement();
        int[] elements = {4, 4, 4, 4, 9, 2, 4, 6, 6, 6, 6, 6};
        System.out.println(mostFrequentEvenElement.mostFrequentEven(elements));
    }

    public int mostFrequentEven(int[] nums) {

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
        }
        int mostFrequentEvenElement = -1;
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (mostFrequentEvenElement == -1 || entry.getValue() > maxCount ||
                    (entry.getValue() == maxCount && entry.getKey() < mostFrequentEvenElement)) {
                mostFrequentEvenElement = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostFrequentEvenElement;
    }
}
