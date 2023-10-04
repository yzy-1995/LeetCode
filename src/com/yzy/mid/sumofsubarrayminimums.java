package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/05 02:04
 * @Description
 * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 *
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 * 示例 2：
 *
 * 输入：arr = [11,81,94,43,3]
 * 输出：444
 * @Version 1.0
 */
public class sumofsubarrayminimums {
    public static int sumSubarrayMins(int[] arr) {
        long ans = 0;
        int[] set = new int[arr.length];
        int div = (int) (Math.pow(10, 9) + 7);
        int p = -1;
        int l;
        for(int i = 0; i < arr.length; i++){
            while (p >= 0 && arr[i] < arr[set[p]]){
                l = p - 1 >= 0 ? set[p - 1] : -1;
                ans = ans + 1l * ((i - set[p]) * (set[p] - l)) * arr[set[p]];
                ans = ans % div;
                p--;
            }
            set[++p] = i;
        }

        while (p >= 0){
            l = p - 1 >= 0 ? set[p - 1] : -1;
            ans = ans + 1l * ((arr.length - set[p]) * (set[p] - l)) * arr[set[p]];
            ans = ans % div;
            p--;
        }
        return (int) ans;
    }
}