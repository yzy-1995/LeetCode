package com.yzy.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Offer57
 * Description:
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *
 * @author Administrator
 * @date 2023-5-18 10:30
 */
public class Offer57 {

    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<Integer>();
        int[] res = new int[2];
        for (int num : nums) {
            set.add(target - num);
        }

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                res[0] = nums[i];
                res[1] = target - nums[i];
            }
        }
        return res;
    }
}
