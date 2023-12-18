package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/09 10:44
 * @Description
 * 给你一个整数数组 nums，请你返回该数组中恰有四个因数的这些整数的各因数之和。如果数组中不存在满足题意的整数，则返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [21,4,7]
 * 输出：32
 * 解释：
 * 21 有 4 个因数：1, 3, 7, 21
 * 4 有 3 个因数：1, 2, 4
 * 7 有 2 个因数：1, 7
 * 答案仅为 21 的所有因数的和。
 * 示例 2:
 *
 * 输入: nums = [21,21]
 * 输出: 64
 * 示例 3:
 *
 * 输入: nums = [1,2,3,4,5]
 * 输出: 0
 * @Version 1.0
 */
public class fourdivisors {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += fourfactor(num);
        }
        return sum;
    }

    public int fourfactor(int n){
        int count = 2;
        int sum = 0;
        for(int i=2; i*i<=n; i++){
            if(n%i==0){
                if(i*i==n){
                    count++;  //平方数时只能算一个因数
                    sum += i;
                }else{
                    count+=2;
                    sum += (i + n/i);
                }
            }
            if(count>4) return 0;//剪枝
        }
        if(count==4) return sum+1+n; //加上1和本身
        return 0; //不满足情况则返回0
    }
}