package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/17 20:38
 * @Description
 * 给你一个 非递减 有序整数数组 nums 。
 *
 * 请你建立并返回一个整数数组 result，它跟 nums 长度相同，且result[i] 等于 nums[i] 与数组中所有其他元素差的绝对值之和。
 *
 * 换句话说， result[i] 等于 sum(|nums[i]-nums[j]|) ，其中 0 <= j < nums.length 且 j != i （下标从 0 开始）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,5]
 * 输出：[4,3,5]
 * 解释：假设数组下标从 0 开始，那么
 * result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4，
 * result[1] = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3，
 * result[2] = |5-2| + |5-3| + |5-5| = 3 + 2 + 0 = 5。
 * 示例 2：
 *
 * 输入：nums = [1,4,6,8,10]
 * 输出：[24,15,13,15,21]
 * @Version 1.0
 */
public class sumofabsolutedifferencesinasortedarray {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        //注意是非递减
        int l[]=new int[nums.length];//左侧所有和
        int r[]=new int[nums.length];//右侧所有和
        int ans[]=new int[nums.length];
        for(int i=1;i<nums.length;i++){
            l[i]=l[i-1]+nums[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            r[i]=r[i+1]+nums[i+1];
        }
        for(int i=0;i<nums.length;i++){
            ans[i]=r[i]-l[i]-nums[i]*(nums.length-2*i-1);
        }
        return ans;
    }
}