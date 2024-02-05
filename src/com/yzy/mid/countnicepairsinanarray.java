package com.yzy.mid;

import java.util.HashMap;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/02/06 00:45
 * @Description
 * 给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ， rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ：
 *
 * 0 <= i < j < nums.length
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * 请你返回好下标对的数目。由于结果可能会很大，请将结果对 109 + 7 取余 后返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [42,11,1,97]
 * 输出：2
 * 解释：两个坐标对为：
 *  - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
 *  - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
 * 示例 2：
 *
 * 输入：nums = [13,10,35,24,76]
 * 输出：4
 * @Version 1.0
 */
public class countnicepairsinanarray {
    public int countNicePairs(int[] nums) {
        int[] diff = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int rev = 0;
            while (num > 0) {
                rev = rev * 10 + num % 10;
                num /= 10;
            }
            diff[i] = rev - nums[i];
        }

        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int dif: diff) {
            map.put(dif, map.getOrDefault(dif, 0) + 1);
        }
        for (int value: map.values()) {
            res += ((long) value * (value - 1) / 2) % (1000000007);
        }
        return res % 1000000007;
    }
}