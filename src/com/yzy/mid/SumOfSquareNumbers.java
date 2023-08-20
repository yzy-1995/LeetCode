package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/16 00:24
 * @Description
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 *
 * 输入：c = 3
 * 输出：false
 * @Version 1.0
 */
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int max=(int)Math.sqrt(c);
        int left=0,right=max;
        while(left<=right){
            //越界 2^31 - 1
            long target=(long)left*left+right*right;
            if(target>c){
                right--;
            }else if(target<c){
                left++;
            }else{
                return true;
            }
        }
        return false;
    }
}