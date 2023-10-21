package com.yzy.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/19 00:20
 * @Description
 * @Version 1.0
 */
public class tuplewithsameproduct {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int ans= 0;
        for(int i= 0; i<n; i++){
            for(int j=0; j<i; j++){
                int t = nums[i] * nums[j];
                int v = map.getOrDefault(t, 0);
                ans += v;
                map.put(t, v+1);
            }
        }
        return ans*8;
    }
}