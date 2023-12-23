package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/22 09:15
 * @Description
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 *
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 *
 * 如果不存在这样的子数组，请返回 0 。
 *
 *
 *
 * 提示 1：
 *
 * 输入：nums = [1,1,0,1]
 * 输出：3
 * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
 * 示例 2：
 *
 * 输入：nums = [0,1,1,1,0,1,1,0,1]
 * 输出：5
 * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
 * 示例 3：
 *
 * 输入：nums = [1,1,1]
 * 输出：2
 * 解释：你必须要删除一个元素。
 * @Version 1.0
 */
public class longestsubarrayof1safterdeletingoneelement {
    public int longestSubarray(int[] nums) {
        int left=0,index=0,k=1; // left记录左边界，index记录下一个0的位置
        int res =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                if(k>0){
                    k--;
                }else{
                    res = Math.max(res,i-1-left);
                    left = index+1;
                }
                index = i;
            }
        }
        res = Math.max(nums.length-1-left,res);
        return res;
    }
}