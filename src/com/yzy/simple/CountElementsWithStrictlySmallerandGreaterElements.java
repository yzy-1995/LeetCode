package com.yzy.simple;

import java.util.Arrays;

/**
 * ClassName: CountElementsWithStrictlySmallerandGreaterElements
 * Description:
 * 给你一个整数数组 nums ，统计并返回在 nums 中同时至少具有一个严格较小元素和一个严格较大元素的元素数目。
 * 示例 1：
 * 输入：nums = [11,7,2,15]
 * 输出：2
 * 解释：元素 7 ：严格较小元素是元素 2 ，严格较大元素是元素 11 。
 * 元素 11 ：严格较小元素是元素 7 ，严格较大元素是元素 15 。
 * 总计有 2 个元素都满足在 nums 中同时存在一个严格较小元素和一个严格较大元素。
 * 示例 2：
 * 输入：nums = [-3,3,3,90]
 * 输出：2
 * 解释：元素 3 ：严格较小元素是元素 -3 ，严格较大元素是元素 90 。
 * 由于有两个元素的值为 3 ，总计有 2 个元素都满足在 nums 中同时存在一个严格较小元素和一个严格较大元素。
 * @author Administrator
 * @date 2023-5-6 10:54
 */
public class CountElementsWithStrictlySmallerandGreaterElements {
    public static void main(String[] args) {

    }

    public int countElements(int[] nums) {
        if(nums.length<=2){return 0;}
        Arrays.sort(nums);
        int res=0,pre=nums[0],val = nums[nums.length-1];
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]>pre&&nums[i]<val){
                res++;
            }
        }
        return res;
    }
}
