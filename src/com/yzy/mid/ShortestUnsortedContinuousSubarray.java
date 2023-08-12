package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/12 10:56
 * @Description
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：0
 * @Version 1.0
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int[] numsCopy= Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsCopy);
        for(int i=0;i<numsCopy.length;i++){
            for(int j=numsCopy.length-1;j>0;j--){
                if(numsCopy[i]!=nums[i] && numsCopy[j]!=nums[j]){
                    return j-i+1;
                }
            }
        }
        return 0;
    }
}