package com.yzy.mid;

import java.util.Arrays;

/**
 * ClassName: LongestConsecutiveSequence
 * Description:
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 * @author Administrator
 * @date 2023-5-30 11:24
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else {
            Arrays.sort(nums);
            int maxLength = 1, current = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] - nums[i - 1] == 1) {
                    current++;
                    maxLength = Math.max(maxLength, current);
                } else if (nums[i] == nums[i - 1]) {
                    continue;
                } else {
                    current = 1;
                }
            }
            return maxLength;
        }
    }
}
