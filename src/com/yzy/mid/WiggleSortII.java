package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/06/26 22:56
 * @Description
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 * 示例 2：
 *
 * 输入：nums = [1,3,2,2,3,1]
 * 输出：[2,3,1,3,1,2]
 * @Version 1.0
 */
public class WiggleSortII {

    public void wiggleSort(int[] nums) {
        int[] temp=new int[nums.length];
        Arrays.sort(nums);
        int j=nums.length-1;
        for(int i=1;i<nums.length;i=i+2,j--){
            temp[i]=nums[j];
        }
        for(int i=0;i<nums.length;i=i+2,j--){
            temp[i]=nums[j];
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=temp[i];
        }
    }
}