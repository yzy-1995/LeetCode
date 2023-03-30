package com.yzy.simple;

/**
 * ClassName: RangeSumQueryImmutable
 * Description:
 * 给定一个整数数组  nums，处理以下类型的多个查询:
 *
 * 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 *
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 * @author Administrator
 * @date 2023-3-30 15:55
 */
public class RangeSumQueryImmutable {
    private int[] preSum;
    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 5, 7};
        RangeSumQueryImmutable numArray = new RangeSumQueryImmutable(nums);
        int sum = numArray.sumRange(0, 3);
        System.out.println(sum);
    }
    public RangeSumQueryImmutable(int[] nums) {
        int n = nums.length;
        preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
    }
    public int sumRange(int i, int j) {
        return preSum[j + 1] - preSum[i];
    }


}
