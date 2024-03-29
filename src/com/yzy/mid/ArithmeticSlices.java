package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/13 22:58
 * @Description
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 *
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 *
 * 子数组 是数组中的一个连续序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：0
 * @Version 1.0
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length <= 2)
            return 0;
        int res = 0;
        int add = 0;
        for (int i = 2; i < nums.length; i++)
            if (nums[i - 1] - nums[i] == nums[i - 2] - nums[i - 1])
                res += ++add;
            else
                add = 0;
        return res;
    }
}