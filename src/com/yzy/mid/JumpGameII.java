package com.yzy.mid;

import java.util.Arrays;

/**
 * ClassName: JumpGameII
 * Description:
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 * <p>
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *
 * @author Administrator
 * @date 2023-5-22 14:07
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int ans = 0, mx = 0, ntmx = 0, n = nums.length;
        for (int i = 0; i < n; ) {
            if (mx >= n - 1) return ans;
            while (i < n && i <= mx) {
                ntmx = Math.max(ntmx, i + nums[i]);
                ++i;
            }
            mx = ntmx;
            ++ans;
        }
        return ans;
    }
}
