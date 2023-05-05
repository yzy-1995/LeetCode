package com.yzy.simple;

import java.util.Arrays;
import java.util.HashMap;

/**
 * ClassName: FindSubsequenceofLengthKWiththeLargestSum
 * Description:
 * 给你一个整数数组 nums 和一个整数 k 。你需要找到 nums 中长度为 k 的 子序列 ，且这个子序列的 和最大 。
 * 请你返回 任意 一个长度为 k 的整数子序列。
 * 子序列 定义为从一个数组里删除一些元素后，不改变剩下元素的顺序得到的数组。
 * 示例 1：
 * 输入：nums = [2,1,3,3], k = 2
 * 输出：[3,3]
 * 解释：
 * 子序列有最大和：3 + 3 = 6 。
 * 示例 2：
 * 输入：nums = [-1,-2,3,4], k = 3
 * 输出：[-1,3,4]
 * 解释：
 * 子序列有最大和：-1 + 3 + 4 = 6 。
 * 示例 3：
 * 输入：nums = [3,4,3,3], k = 2
 * 输出：[3,4]
 * 解释：
 * 子序列有最大和：3 + 4 = 7 。
 * 另一个可行的子序列为 [4, 3] 。
 * @author Administrator
 * @date 2023-5-5 17:31
 */
public class FindSubsequenceofLengthKWiththeLargestSum {
    public static void main(String[] args) {

    }

    public int[] maxSubsequence(int[] nums, int k) {
        if(k == nums.length){
            return nums;
        }
        int newNums[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
        }
        Arrays.sort(newNums);
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = newNums.length - k; i < newNums.length; i++) {
            map.put(newNums[i],map.getOrDefault(newNums[i],0) + 1);
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(map.getOrDefault(nums[i],0) > 0 && index < k){
                map.put(nums[i],map.get(nums[i])-1);
                res[index++] = nums[i];
            }
        }
        return res;
    }
}
