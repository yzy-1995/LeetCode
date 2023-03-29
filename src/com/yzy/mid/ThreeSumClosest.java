package com.yzy.mid;

import java.util.Arrays;

/**
 * ClassName: ThreeSumClosest
 * Description:
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 * 示例 1：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * <p>
 * 示例 2：
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 *
 * @author Administrator
 * @date 2023-3-28 15:26
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n; i++) {
            int a = i + 1, b = n - 1;
            while (a < b) {
                int sum = nums[i] + nums[a] + nums[b];
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum > target) {
                    b--;
                } else if (sum < target) {
                    a++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }
}
