package com.yzy.simple;

/**
 * Description: leetcode1539
 * 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
 * 请你找到这个数组里第 k 个缺失的正整数。
 * 示例 1：
 * 输入：arr = [2,3,4,7,11], k = 5
 * 输出：9
 * 解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
 * 示例 2：
 * 输入：arr = [1,2,3,4], k = 2
 * 输出：6
 * 解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
 *
 * @author yzy15
 * @date 2023/04/30 15:25
 **/
public class KthMissingPositiveNumber {
    public static void main(String[] args) {

    }


    public int findKthPositive(int[] arr, int k) {
        int missingCount = 0;
        int prev = 0;
        int index = 0;

        while (missingCount < k && index < arr.length) {
            int current = arr[index] - prev - 1;
            missingCount += current;

            if (missingCount >= k) {
                return prev + k - (missingCount - current);
            }

            prev = arr[index];
            index++;
        }

        return arr[arr.length - 1] + (k - missingCount);

    }
}
