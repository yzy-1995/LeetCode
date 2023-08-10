package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/07 00:04
 * @Description
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 *
 * 请你找出并返回只出现一次的那个数。
 *
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 * @Version 1.0
 */
public class SingleElementinaSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int l=0,r = nums.length-1,m;
        while(l<r){
            m=l+(r-l)/2;
            if(m%2==1){
                m--;
            }
            if(nums[m]==nums[m+1]){
                l=m+2;
            }else{
                r=m;
            }
        }
        return nums[l];
    }
}