package com.yzy.simple;

import java.util.Arrays;

/**
 * ClassName: Offer61
 * Description:
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [0,0,1,2,5]
 * 输出: True
 * <p>
 * <p>
 * 限制：
 * <p>
 * 数组长度为 5
 * <p>
 * 数组的数取值为 [0, 13] .
 *
 * @author Administrator
 * @date 2023-5-18 14:39
 */
public class Offer61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            }
        }
        for (int i = zero + 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > zero + 1 || nums[i] == nums[i - 1]) {
                return false;
            } else {
                zero -= nums[i] - nums[i - 1] - 1;
            }
        }
        return true;
    }
}
