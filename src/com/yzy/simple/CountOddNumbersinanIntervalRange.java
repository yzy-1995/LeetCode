package com.yzy.simple;

/**
 * Description: leetcode1523
 *  给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：low = 3, high = 7
 * 输出：3
 * 解释：3 到 7 之间奇数数字为 [3,5,7] 。
 * 示例 2：
 *
 * 输入：low = 8, high = 10
 * 输出：1
 * 解释：8 到 10 之间奇数数字为 [9] 。
 * @author yzy15
 * @date 2023/04/30 15:00
 **/
public class CountOddNumbersinanIntervalRange {
    public static void main(String[] args) {
        System.out.println(countOdds(0, 1000));
    }

    public static int countOdds(int low, int high) {
        if(low == 0){
            low = 1;
        }
        int count = 0;
        for (int i = low; i <=high ; i++) {
            if (i%2!=0){
                count++;
            }
        }
        return count;
    }
}
