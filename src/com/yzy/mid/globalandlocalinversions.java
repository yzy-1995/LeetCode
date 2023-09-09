package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/08 00:23
 * @Description
 * 给你一个长度为 n 的整数数组 nums ，表示由范围 [0, n - 1] 内所有整数组成的一个排列。
 *
 * 全局倒置 的数目等于满足下述条件不同下标对 (i, j) 的数目：
 *
 * 0 <= i < j < n
 * nums[i] > nums[j]
 * 局部倒置 的数目等于满足下述条件的下标 i 的数目：
 *
 * 0 <= i < n - 1
 * nums[i] > nums[i + 1]
 * 当数组 nums 中 全局倒置 的数量等于 局部倒置 的数量时，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,2]
 * 输出：true
 * 解释：有 1 个全局倒置，和 1 个局部倒置。
 * 示例 2：
 *
 * 输入：nums = [1,2,0]
 * 输出：false
 * 解释：有 2 个全局倒置，和 1 个局部倒置。
 * @Version 1.0
 */
public class globalandlocalinversions {
    public boolean isIdealPermutation(int[] nums) {
        int n=nums.length,count1=0,count[]=new int[n+5];
        long count2=0;
        update(count,nums[0]+1);
        for(int i=1;i<n;i++){
            if(nums[i]<nums[i-1]){count1++;}
            count2+=i-get(count,nums[i]);
            update(count,nums[i]+1);
        }
        return count1==count2;
    }
    void update(int arr[],int k){
        while(k<arr.length){
            arr[k]++;
            k+=k&(-k);
        }
    }
    int get(int arr[],int k){
        int ans=0;
        while(k>0){
            ans+=arr[k];
            k-=k&(-k);
        }
        return ans;
    }
}