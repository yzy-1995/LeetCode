package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/01 23:03
 * @Description
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * 输出：3
 * 解释：长度最长的公共子数组是 [3,2,1] 。
 * 示例 2：
 *
 * 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * 输出：5
 * @Version 1.0
 */
public class maximumlengthofrepeatedsubarray {
    public int findLength(int[] nums1, int[] nums2) {
        int max = 0;
        int count = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){

                int m = i;
                int n = j;
                while(m < len1 && n < len2 && nums1[m] == nums2[n]){
                    m++;
                    n++;
                    count++;
                }
                max = Math.max(max, count);
                // 重新统计
                count = 0;
            }
        }
        return max;
    }
}