package com.yzy.simple;

import java.util.HashMap;

/**
 * Description: leetcode961
 * 给你一个整数数组 nums ，该数组具有以下属性：
 * nums.length == 2 * n.
 * nums 包含 n + 1 个 不同的 元素
 * nums 中恰有一个元素重复 n 次
 * 找出并返回重复了 n 次的那个元素。
 * 示例 1：
 * 输入：nums = [1,2,3,3]
 * 输出：3
 * 示例 2：
 * 输入：nums = [2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 * 输入：nums = [5,1,5,2,5,3,5,4]
 * 输出：5
 * @author yzy15
 * @date 2023/04/22 22:59
 **/
public class NRepeatedElementinSizeNArray {
    public static void main(String[] args) {

    }

    public int repeatedNTimes(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.get(num) > 1) {
                return num;
            }
        }
        return -1;
    }
}
