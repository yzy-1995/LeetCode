package com.yzy.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/18 21:24
 * @Description
 * 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
 *
 * 返回 只删除一个 子数组可获得的 最大得分 。
 *
 * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,2,4,5,6]
 * 输出：17
 * 解释：最优子数组是 [2,4,5,6]
 * 示例 2：
 *
 * 输入：nums = [5,2,1,2,5,2,1,2,5]
 * 输出：8
 * 解释：最优子数组是 [5,2,1] 或 [1,2,5]
 * @Version 1.0
 */
public class maximumerasurevalue {
    public int maximumUniqueSubarray(int[] nums) {
        int len = nums.length;
        int[] preSum = new int[len + 1];
        // preSum[i]保存nums[i - 1]以及nums[i - 1]之前的所有数字总和
        for(int i = 1; i <= len; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        // 主要用于去重和保存最近一次数字出现的索引
        Map<Integer, Integer> map = new HashMap<>();
        // [l, r]代表窗口并且没有出现重复数字
        int l = 0, sum = 0;
        for(int r = 0; r < len; r++) {
            int num = nums[r];
            // 新的数字与窗口的内的数字相同 重复的数字在窗口[l, r)内
            if(map.containsKey(num) && map.get(num) >= l) {
                // 改变窗口的左边界
                l = map.get(num) + 1;
            }
            // 计算当前窗口的总和[l, r]
            sum = Math.max(sum, preSum[r + 1] - preSum[l]);
            // 记录当前数据最新索引
            map.put(num, r);
        }
        return sum;
    }
}