package com.yzy.simple;

/**
 * ClassName: MostFrequentNumberFollowingKeyInanArray
 * Description:
 * 给你一个下标从 0 开始的整数数组 nums ，同时给你一个整数 key ，它在 nums 出现过。
 * 统计 在 nums 数组中紧跟着 key 后面出现的不同整数 target 的出现次数。换言之，target 的出现次数为满足以下条件的 i 的数目：
 * 0 <= i <= n - 2
 * nums[i] == key 且
 * nums[i + 1] == target 。
 * 请你返回出现 最多 次数的 target 。测试数据保证出现次数最多的 target 是唯一的。
 * 示例 1：
 * 输入：nums = [1,100,200,1,100], key = 1
 * 输出：100
 * 解释：对于 target = 100 ，在下标 1 和 4 处出现过 2 次，且都紧跟着 key 。
 * 没有其他整数在 key 后面紧跟着出现，所以我们返回 100 。
 * 示例 2：
 * 输入：nums = [2,2,2,2,3], key = 2
 * 输出：2
 * 解释：对于 target = 2 ，在下标 1 ，2 和 3 处出现过 3 次，且都紧跟着 key 。
 * 对于 target = 3 ，在下标 4 出出现过 1 次，且紧跟着 key 。
 * target = 2 是紧跟着 key 之后出现次数最多的数字，所以我们返回 2 。
 * @author Administrator
 * @date 2023-5-6 15:01
 */
public class MostFrequentNumberFollowingKeyInanArray {
    public static void main(String[] args) {

    }

    public int mostFrequent(int[] nums, int key) {
        if (nums == null || nums.length < 2) {
            return -1;
        }

        int mostFrequentTarget = -1;
        int maxCount = 0;
        int count;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                count = 0;
                int target = nums[i + 1];
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j - 1] == key && nums[j] == target) {
                        count++;
                    }
                }
                if (count > maxCount) {
                    maxCount = count;
                    mostFrequentTarget = target;
                }
            }
        }

        return mostFrequentTarget;
    }
}
