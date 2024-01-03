package com.yzy.mid;

import java.util.ArrayList;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/02 10:39
 * @Description
 * 给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
 *
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 *
 * 请你返回乘积为正数的最长子数组长度。
 *
 *
 *
 * 示例  1：
 *
 * 输入：nums = [1,-2,-3,4]
 * 输出：4
 * 解释：数组本身乘积就是正数，值为 24 。
 * 示例 2：
 *
 * 输入：nums = [0,1,-2,-3,-4]
 * 输出：3
 * 解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
 * 注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。
 * 示例 3：
 *
 * 输入：nums = [-1,-2,-3,0,1]
 * 输出：2
 * 解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。
 * @Version 1.0
 */
public class maximumlengthofsubarraywithpositiveproduct {
    public int getMaxLen(int[] nums) {
        int l = 0;
        int r = l;
        int max = 0;
        while (r < nums.length){
            while (r < nums.length && nums[r] != 0)
                r++;
            max = Math.max(max, slove(l, r - 1, nums));
            l = r + 1;
            r = l;
        }
        return max;
    }

    private int slove(int l, int r, int[] arr){
        ArrayList<Integer> indexes = new ArrayList<>();
        for(int i = l; i <= r; i++){
            if(arr[i] < 0)
                indexes.add(i);
        }
        if(indexes.size() % 2 == 0)
            return r - l + 1;
        int first = indexes.get(0);
        int last = indexes.get(indexes.size() - 1);
        return Math.max(r - first, last - l);
    }
}