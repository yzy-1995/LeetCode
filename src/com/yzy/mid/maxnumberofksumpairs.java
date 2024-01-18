package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/16 01:41
 * @Description
 * 给你一个整数数组 nums 和一个整数 k 。
 *
 * 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
 *
 * 返回你可以对数组执行的最大操作数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4], k = 5
 * 输出：2
 * 解释：开始时 nums = [1,2,3,4]：
 * - 移出 1 和 4 ，之后 nums = [2,3]
 * - 移出 2 和 3 ，之后 nums = []
 * 不再有和为 5 的数对，因此最多执行 2 次操作。
 * 示例 2：
 *
 * 输入：nums = [3,1,3,4,3], k = 6
 * 输出：1
 * 解释：开始时 nums = [3,1,3,4,3]：
 * - 移出前两个 3 ，之后nums = [1,4,3]
 * 不再有和为 6 的数对，因此最多执行 1 次操作。
 * @Version 1.0
 */
public class maxnumberofksumpairs {
    public int maxOperations(int[] nums, int k) {
        int left = 0,right=nums.length-1;
        int count=0;
        Arrays.sort(nums);
        while(left<right){
            while(nums[left]+nums[right]!=k){
                if(nums[left]+nums[right]>k){
                    if(right-1>=left) right--;
                    else break;
                }else{
                    if(left+1<=right) left++;
                    else break;
                }
            }
            if(left<right){
                count++;
                left++;
                right--;
            }else{
                break;
            }
        }
        return count;
    }
}