package com.yzy.mid;

import java.util.HashMap;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/22 00:05
 * @Description
 * 给你一个按 非递减顺序 排列的整数数组 nums 。
 *
 * 请你判断是否能在将 nums 分割成 一个或多个子序列 的同时满足下述 两个 条件：
 *
 * 每个子序列都是一个 连续递增序列（即，每个整数 恰好 比前一个整数大 1 ）。
 * 所有子序列的长度 至少 为 3 。
 * 如果可以分割 nums 并满足上述条件，则返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,3,4,5]
 * 输出：true
 * 解释：nums 可以分割成以下子序列：
 * [1,2,3,3,4,5] --> 1, 2, 3
 * [1,2,3,3,4,5] --> 3, 4, 5
 * 示例 2：
 *
 * 输入：nums = [1,2,3,3,4,4,5,5]
 * 输出：true
 * 解释：nums 可以分割成以下子序列：
 * [1,2,3,3,4,4,5,5] --> 1, 2, 3, 4, 5
 * [1,2,3,3,4,4,5,5] --> 3, 4, 5
 * 示例 3：
 *
 * 输入：nums = [1,2,3,4,4,5]
 * 输出：false
 * 解释：无法将 nums 分割成长度至少为 3 的连续递增子序列。
 * @Version 1.0
 */
public class splitarrayintoconsecutivesubsequences {
    public boolean isPossible(int[] nums) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        HashMap<Integer,Integer> need = new HashMap<>();
        for(int v : nums){
            freq.put(v,freq.getOrDefault(v,0)+1);
        }
        for(int v :nums){
            if(freq.get(v)==0) continue;// 避免重复判断。比如2只有一个，用完了就不判断了。直接走下一个3，
            // 一定要先判断一个数能不能接续。接在后面才是第一选择，所以首先判断能不能续后面。
            if(need.containsKey(v)&& need.get(v)>0){ // 这个的意思就是我需要的数出现了，它可以贴在某个序列的后面。 v一定会出现在freq中
                freq.put(v,freq.getOrDefault(v,0)-1);
                need.put(v,need.getOrDefault(v,0)-1);
                // 把这个数续在后面以后，就看看下一个数能续吗
                need.put(v+1,need.getOrDefault(v+1,0)+1);
                // 直接在判断条件里，判断能不能形成一个长度为三的递增序列。
            }else if (freq.containsKey(v) && freq.get(v) > 0 && freq.containsKey(v + 1) && freq.get(v + 1) > 0 && freq.containsKey(v + 2) && freq.get(v + 2) > 0){
                // 如果可以，把他们用了。
                freq.put(v,freq.getOrDefault(v,0)-1);
                freq.put(v+1,freq.getOrDefault(v+1,0)-1);
                freq.put(v+2,freq.getOrDefault(v+2,0)-1);
                // 比如这里的v是1，下面这条语句就是说我需要一个4，给4的需求量加1.
                need.put(v+3,need.getOrDefault(v+3,0)+1);
            }else{
                return false;
            }
        }
        return true;
    }
}