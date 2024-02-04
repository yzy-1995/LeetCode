package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/02/04 00:58
 * @Description
 * 给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）：
 *
 * nums.length == n
 * nums[i] 是 正整数 ，其中 0 <= i < n
 * abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1
 * nums 中所有元素之和不超过 maxSum
 * nums[index] 的值被 最大化
 * 返回你所构造的数组中的 nums[index] 。
 *
 * 注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4, index = 2,  maxSum = 6
 * 输出：2
 * 解释：数组 [1,1,2,1] 和 [1,2,2,1] 满足所有条件。不存在其他在指定下标处具有更大值的有效数组。
 * 示例 2：
 *
 * 输入：n = 6, index = 1,  maxSum = 10
 * 输出：3
 * @Version 1.0
 */
public class maximumvalueatagivenindexinaboundedarray {
    public static int maxValue(int n, int index, int maxSum) {
        // 从中间往两边展开累加计算
        int left = index, right = index;

        int sum = n;

        // 表示当前index位置的最大的数
        int max = 1;

        while (sum <= maxSum) {
            max++;
            // 如果已经达到左右边界直接加上 剩余大小 / n 即可
            if (left == 0 && right == n - 1) {
                return max - 1 + (maxSum - sum) / n;
            }
            sum += right - left + 1;
            right = Math.min(n - 1, ++right);
            left = Math.max(0, --left);
        }
        return max - 1;
    }
}