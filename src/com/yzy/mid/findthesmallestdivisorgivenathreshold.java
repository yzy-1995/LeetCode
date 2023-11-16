package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/16 01:10
 * @Description
 * 给你一个整数数组 nums 和一个正整数 threshold  ，你需要选择一个正整数作为除数，然后将数组里每个数都除以它，并对除法结果求和。
 *
 * 请你找出能够使上述结果小于等于阈值 threshold 的除数中 最小 的那个。
 *
 * 每个数除以除数后都向上取整，比方说 7/3 = 3 ， 10/2 = 5 。
 *
 * 题目保证一定有解。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,5,9], threshold = 6
 * 输出：5
 * 解释：如果除数为 1 ，我们可以得到和为 17 （1+2+5+9）。
 * 如果除数为 4 ，我们可以得到和为 7 (1+1+2+3) 。如果除数为 5 ，和为 5 (1+1+1+2)。
 * 示例 2：
 *
 * 输入：nums = [2,3,5,7,11], threshold = 11
 * 输出：3
 * 示例 3：
 *
 * 输入：nums = [19], threshold = 5
 * 输出：4
 * @Version 1.0
 */
public class findthesmallestdivisorgivenathreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1;
        int max = Arrays.stream(nums).max().getAsInt();
        int ans = 0;
        while(min <= max){
            int mid = min + (max - min)/2;
            int cnt = Arrays.stream(nums).map(x -> (x + mid - 1)/mid).sum();
            if(cnt <= threshold){
                ans = mid;
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        return ans;
    }
}