package com.yzy.mid;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/18 00:22
 * @Description
 * 给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。请你选出两个下标 i 和 j（i != j），且 nums[i] 的数位和 与  nums[j] 的数位和相等。
 *
 * 请你找出所有满足条件的下标 i 和 j ，找出并返回 nums[i] + nums[j] 可以得到的 最大值 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [18,43,36,13,7]
 * 输出：54
 * 解释：满足条件的数对 (i, j) 为：
 * - (0, 2) ，两个数字的数位和都是 9 ，相加得到 18 + 36 = 54 。
 * - (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。
 * 所以可以获得的最大和是 54 。
 * 示例 2：
 *
 * 输入：nums = [10,12,19,14]
 * 输出：-1
 * 解释：不存在满足条件的数对，返回 -1 。
 * @Version 1.0
 */
public class maxsumofapairwithequalsumofdigits {
    public int maximumSum(int[] nums) {
        int ans=-1,n=nums.length;
        Arrays.sort(nums);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=n-1;i>=0;i--){
            int bitsum=0,t=nums[i];
            while(t>0){
                bitsum+=t%10;
                t/=10;
            }
            if(map.containsKey(bitsum)){
                ans=Math.max(ans,nums[i]+map.get(bitsum));
            }else{
                map.put(bitsum,nums[i]);
            }
        }
        return ans;
    }
}