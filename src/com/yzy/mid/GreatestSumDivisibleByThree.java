package com.yzy.mid;

import java.util.Arrays;

/**
 * ClassName: GreatestSumDivisibleByThree
 * Description:
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 *
 * 示例 1：
 *
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * 示例 2：
 *
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * 示例 3：
 *
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 * @author Administrator
 * @date 2023-6-19 15:49
 */
public class GreatestSumDivisibleByThree {

    public int maxSumDivThree(int[] nums) {
        int[] reminderOne = new int[2];
        int[] reminderTwo = new int[2];
        int pointer1 = 0;
        int pointer2 = 0;
        Arrays.sort(nums);

        for(int i =0; i<nums.length; i++){
            if(nums[i] % 3 == 1 && pointer1 < 2){
                reminderOne[pointer1] = nums[i];
                pointer1++;
            }

            if(nums[i] % 3 == 2 && pointer2 < 2){
                reminderTwo[pointer2] = nums[i];
                pointer2++;
            }
        }

        int finalReminder1 = 0;
        int finalReminder2 = 0;

        if(Math.min(reminderTwo[0], reminderTwo[1]) != 0){
            if(reminderOne[0] != 0){
                finalReminder1 = Math.min(reminderOne[0], (reminderTwo[0]+reminderTwo[1]));
            }else{
                finalReminder1 = reminderTwo[0]+reminderTwo[1];
            }
        }else{
            finalReminder1 = reminderOne[0];
        }

        if(Math.min(reminderOne[0], reminderOne[1]) != 0){
            if(reminderTwo[0] != 0){
                finalReminder2 = Math.min(reminderTwo[0], (reminderOne[0]+reminderOne[1]));
            }else{
                finalReminder2 = reminderOne[0]+reminderOne[1];
            }
        }else{
            finalReminder2 = reminderTwo[0];
        }

        int totalSum = Arrays.stream(nums).sum();
        if (totalSum % 3 == 1){
            return totalSum-finalReminder1;
        }else if(totalSum % 3 == 2){
            return totalSum - finalReminder2;
        }

        return totalSum;
    }
}
