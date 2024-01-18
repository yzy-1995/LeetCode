package com.yzy.hard;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.hard
 * @Date 2024/01/16 01:39
 * @Description
 * 给你两个数字字符串 num1 和 num2 ，以及两个整数 max_sum 和 min_sum 。如果一个整数 x 满足以下条件，我们称它是一个好整数：
 *
 * num1 <= x <= num2
 * min_sum <= digit_sum(x) <= max_sum.
 * 请你返回好整数的数目。答案可能很大，请返回答案对 109 + 7 取余后的结果。
 *
 * 注意，digit_sum(x) 表示 x 各位数字之和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num1 = "1", num2 = "12", min_num = 1, max_num = 8
 * 输出：11
 * 解释：总共有 11 个整数的数位和在 1 到 8 之间，分别是 1,2,3,4,5,6,7,8,10,11 和 12 。所以我们返回 11 。
 * 示例 2：
 *
 * 输入：num1 = "1", num2 = "5", min_num = 1, max_num = 5
 * 输出：5
 * 解释：数位和在 1 到 5 之间的 5 个整数分别为 1,2,3,4 和 5 。所以我们返回 5 。
 * @Version 1.0
 */
public class countofintegers {
    static int max,min , mem[][] , MOD = (int)1e9+7;
    public int count(String num1, String num2, int min_sum, int max_sum) {
        max = max_sum;min = min_sum;

        int nums1[] = new int[num1.length()];
        int nums2[] = new int[num2.length()];
        int num1_sum = 0;
        for(int i = 0; i < num1.length(); i++){
            nums1[i] = num1.charAt(i) - '0';
            num1_sum += nums1[i];
        }
        for(int i = 0; i < num2.length(); i++){
            nums2[i] = num2.charAt(i) - '0';
        }

        int t = (num1_sum >=min && num1_sum <= max) ? 1:0;
        return (count(nums2) - count(nums1) + MOD + t) % MOD;// 避免负数 (坑)
    }

    //因为有两部分的dfs,两个部分的dfs不能共用一个mem数组，所以必须分别对每一个dfs用一个mem数组（坑）
    int count(int nums[]){
        mem = new int[30][410];
        for (int i = 0; i < 30; i++)
            Arrays.fill(mem[i],-1);
        return dfs(0,0,nums,true);
    }

    int dfs(int i , int sum, int nums[] , boolean is_limit){
        if(sum > max) return 0; // 提前结束
        if(i == nums.length) return sum >= min ? 1 : 0;
        if(!is_limit && mem[i][sum] != -1) return mem[i][sum]; //记忆化搜索
        int res = 0;
        int up = is_limit ? nums[i] : 9; //根据是否有限制决定上限
        //枚举每一位选什么，每一位都可以从0开始选择（即j=0）
        for(int j = 0; j <= up; j++){
            res =  (res + dfs(i+1 , sum + j , nums , is_limit && j == up)) % MOD ;
        }
        if(!is_limit) mem[i][sum] = res; //不可省略，因为res由is_limit、i、sum三个维度决定
        return res;
    }
}