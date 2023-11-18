package com.yzy.hard;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.hard
 * @Date 2023/11/19 00:16
 * @Description
 * 给你一个整数数组 nums 和一个整数 k ，找出三个长度为 k 、互不重叠、且全部数字和（3 * k 项）最大的子数组，并返回这三个子数组。
 *
 * 以下标的数组形式返回结果，数组中的每一项分别指示每个子数组的起始位置（下标从 0 开始）。如果有多个结果，返回字典序最小的一个。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,1,2,6,7,5,1], k = 2
 * 输出：[0,3,5]
 * 解释：子数组 [1, 2], [2, 6], [7, 5] 对应的起始下标为 [0, 3, 5]。
 * 也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
 * 示例 2：
 *
 * 输入：nums = [1,2,1,2,1,2,1,2,1], k = 2
 * 输出：[0,2,4]
 * @Version 1.0
 */
public class maximumsumof3nonoverlappingsubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int kSum[]=new int[nums.length+1-k];//kSum[p]表示从p开始的k个数字之和
        for(int i=0;i<k;i++){kSum[0]+=nums[i];}
        for(int i=1;i<=nums.length-k;i++){kSum[i]=kSum[i-1]-nums[i-1]+nums[i+k-1];}
        int leftMax[]=new int[kSum.length];//kSum左边从0-p取得最大值的坐标
        int rightMax[]=new int[kSum.length];//kSum右边取得最大值的坐标
        rightMax[kSum.length-1]=kSum.length-1;
        for(int i=1;i<kSum.length;i++){
            leftMax[i]=kSum[i]>kSum[leftMax[i-1]]?i:leftMax[i-1];
            rightMax[kSum.length-1-i]=kSum[kSum.length-1-i]>=kSum[rightMax[kSum.length-i]]?kSum.length-1-i:rightMax[kSum.length-i];
        }
        int ans[]=new int[0];
        int maxSum=0;
        for(int i=k;i<=nums.length-2*k;i++){
            if(maxSum<kSum[i]+kSum[leftMax[i-k]]+kSum[rightMax[i+k]]){
                maxSum=kSum[i]+kSum[leftMax[i-k]]+kSum[rightMax[i+k]];
                ans=new int[]{leftMax[i-k],i,rightMax[i+k]};
            }
        }
        return ans;
    }
}