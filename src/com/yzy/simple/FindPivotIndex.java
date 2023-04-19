package com.yzy.simple;

/**
 * ClassName: FindPivotIndex
 * Description:leetcode724
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 * 示例 1：
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 * 示例 2：
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心下标。
 * 示例 3：
 * 输入：nums = [2, 1, -1]
 * 输出：0
 * 解释：
 * 中心下标是 0 。
 * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
 * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
 *
 * @author Administrator
 * @date 2023-4-19 11:49
 */
public class FindPivotIndex {
    public static void main(String[] args) {

    }

    /**
     * 我们可以先计算出数组的前缀和数组prefixSum，其中prefixSum[i]表示nums数组前i个元素的和。
     * 然后再遍历一遍prefixSum数组，对于每个位置i，如果它的左侧元素之和等于右侧元素之和，则返回i。
     * 如果没有找到中心下标，则返回-1。
     *
     * 需要注意的是，在计算prefixSum数组时，为了避免下标越界，我们可以将prefixSum数组的长度设为n+1，
     * 其中prefixSum[0]为0，表示nums数组前0个元素的和为0。
     *
     * 为了提高计算效率，我们可以在遍历prefixSum数组时，先判断左侧元素之和是否等于右侧元素之和，
     * 如果相等，则直接返回i，否则继续遍历。这样可以减少不必要的计算。
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < n; i++) {
            if (prefixSum[i] == prefixSum[n] - prefixSum[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
