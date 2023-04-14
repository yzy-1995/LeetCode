package com.yzy.hard;

/**
 * Description:
 * leetcode410
 * 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 * 示例 1：
 * 输入：nums = [7,2,5,10,8], m = 2
 * 输出：18
 * 解释：
 * 一共有四种方法将 nums 分割为 2 个子数组。
 * 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * 示例 2：
 * 输入：nums = [1,2,3,4,5], m = 2
 * 输出：9
 * 示例 3：
 * 输入：nums = [1,4,4], m = 3
 * 输出：4
 * @author yzy15
 * @date 2023/04/14 22:36
 **/
public class SplitArrayLargestSum {

    public static void main(String[] args) {

    }

    public int splitArray(int[] nums, int m) {
        long left = 0;
        long right = 0;

        // 找到数组中的最大值和数组的和
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {
            long mid = left + (right - left) / 2;

            // 检查当前 mid 值是否可以将数组分割为 m 个子数组，使得它们的和不大于 mid
            if (isPossibleToSplit(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return (int) left;
    }

    private boolean isPossibleToSplit(int[] nums, int m, long maxSum) {
        int count = 1;
        long currentSum = 0;

        for (int num : nums) {
            currentSum += num;

            if (currentSum > maxSum) {
                currentSum = num;
                count++;

                if (count > m) {
                    return false;
                }
            }
        }

        return true;
    }
}
