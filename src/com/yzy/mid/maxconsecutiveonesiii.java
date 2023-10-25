package com.yzy.mid;

import java.util.LinkedList;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/23 00:03
 * @Description
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 *
 * 输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 * @Version 1.0
 */
public class maxconsecutiveonesiii {
    public int longestOnes(int[] nums, int k) {
        int left=0,res=0;
        LinkedList<Integer> list = new LinkedList();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                continue;
            }else{
                list.add(i);
                if(k>0){
                    k--;
                }else{
                    res = Math.max(res,i-left);
                    // 滑出最左端一个0腾出位置给当前0
                    left = list.removeFirst()+1;
                }
            }
        }
        if(nums[nums.length-1]==1||k>=0){res=Math.max(res,nums.length-left);}
        return res;
    }
}