package com.yzy.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: MaxConsecutiveOnes
 * Description:
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * 示例 2:
 *
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 * @author Administrator
 * @date 2023-4-12 10:48
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {

    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int maxCount=0;
        for (Integer num :nums) {
            if (num==1){
                count++;
            }else{
                maxCount = Math.max(maxCount,count);
                count=0;
            }
        }


        return Math.max(maxCount,count);
    }
}
