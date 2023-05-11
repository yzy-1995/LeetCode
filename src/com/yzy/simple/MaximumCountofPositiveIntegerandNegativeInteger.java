package com.yzy.simple;

/**
 * Description: leetcode2529
 * 给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。
 * 换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。
 * 注意：0 既不是正整数也不是负整数。
 * 示例 1：
 * 输入：nums = [-2,-1,-1,1,2,3]
 * 输出：3
 * 解释：共有 3 个正整数和 3 个负整数。计数得到的最大值是 3 。
 * 示例 2：
 * 输入：nums = [-3,-2,-1,0,0,1,2]
 * 输出：3
 * 解释：共有 2 个正整数和 3 个负整数。计数得到的最大值是 3 。
 * 示例 3：
 * 输入：nums = [5,20,66,1314]
 * 输出：4
 * 解释：共有 4 个正整数和 0 个负整数。计数得到的最大值是 4 。
 *
 * @author yzy15
 * @date 2023/05/10 23:10
 **/
public class MaximumCountofPositiveIntegerandNegativeInteger {
    public static void main(String[] args) {

    }

    public int maximumCount(int[] nums) {
        int neg = 0; //负整数数量
        int pos = 0; //正整数数量
        for (int num : nums) {
            if (num < 0) {
                neg++;
            } else if (num > 0) {
                pos++;
            }
        }
        return Math.max(neg, pos);
    }
}
