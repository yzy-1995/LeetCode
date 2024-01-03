package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/03 09:43
 * @Description
 * 给你一个整数数组 arr ，请你删除一个子数组（可以为空），使得 arr 中剩下的元素是 非递减 的。
 *
 * 一个子数组指的是原数组中连续的一个子序列。
 *
 * 请你返回满足题目要求的最短子数组的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3,10,4,2,3,5]
 * 输出：3
 * 解释：我们需要删除的最短子数组是 [10,4,2] ，长度为 3 。剩余元素形成非递减数组 [1,2,3,3,5] 。
 * 另一个正确的解为删除子数组 [3,10,4] 。
 * 示例 2：
 *
 * 输入：arr = [5,4,3,2,1]
 * 输出：4
 * 解释：由于数组是严格递减的，我们只能保留一个元素。所以我们需要删除长度为 4 的子数组，要么删除 [5,4,3,2]，要么删除 [4,3,2,1]。
 * 示例 3：
 *
 * 输入：arr = [1,2,3]
 * 输出：0
 * 解释：数组已经是非递减的了，我们不需要删除任何元素。
 * 示例 4：
 *
 * 输入：arr = [1]
 * @Version 1.0
 */
public class shortestsubarraytoberemovedtomakearraysorted {
    public int findLengthOfShortestSubarray(int[] arr) {
        int l = 0, r = arr.length-1, R = arr.length-1, min = arr.length-1;
        while(l < arr.length-1 && arr[l] <= arr[l+1]) l++;
        while(r > 0 && arr[r] >= arr[r-1]) r--;
        if(l >= r) return 0;
        if(arr[l] <= arr[r]) return r - l - 1;
        for(int i=l; i>=0 && R >= r; i--){
            while(R >= r && arr[R] >= arr[i]) R--;
            min = Math.min(min,R - i);
        }
        return Math.min(min,r);
    }
}