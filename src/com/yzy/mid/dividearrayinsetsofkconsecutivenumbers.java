package com.yzy.mid;

import java.util.TreeMap;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/19 00:17
 * @Description
 * 给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。
 * 如果可以，请返回 true；否则，返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,3,4,4,5,6], k = 4
 * 输出：true
 * 解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]。
 * 示例 2：
 *
 * 输入：nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
 * 输出：true
 * 解释：数组可以分成 [1,2,3] , [2,3,4] , [3,4,5] 和 [9,10,11]。
 * 示例 3：
 *
 * 输入：nums = [3,3,2,2,1,1], k = 3
 * 输出：true
 * 示例 4：
 *
 * 输入：nums = [1,2,3,4], k = 3
 * 输出：false
 * 解释：数组不能分成几个大小为 3 的子数组。
 * @Version 1.0
 */
public class dividearrayinsetsofkconsecutivenumbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        while(map.size() > 0){
            int first = map.firstKey();
            for(int i = first;i < first + k;i++){
                if(!map.containsKey(i)) return false;
                map.put(i,map.get(i) - 1);
                if(map.get(i) == 0){
                    map.remove(i);
                }
            }
        }
        return true;
    }
}