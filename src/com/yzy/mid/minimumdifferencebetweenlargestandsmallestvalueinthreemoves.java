package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/25 13:36
 * @Description
 * 给你一个数组 nums 。
 *
 * 每次操作你可以选择 nums 中的任意一个元素并将它改成 任意值 。
 *
 * 在 执行最多三次移动后 ，返回 nums 中最大值与最小值的最小差值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,3,2,4]
 * 输出：0
 * 解释：我们最多可以走 3 步。
 * 第一步，将 2 变为 3 。 nums 变成 [5,3,3,4] 。
 * 第二步，将 4 改为 3 。 nums 变成 [5,3,3,3] 。
 * 第三步，将 5 改为 3 。 nums 变成 [3,3,3,3] 。
 * 执行 3 次移动后，最小值和最大值之间的差值为 3 - 3 = 0 。
 * 示例 2：
 *
 * 输入：nums = [1,5,0,10,14]
 * 输出：1
 * 解释：我们最多可以走 3 步。
 * 第一步，将 5 改为 0 。 nums变成 [1,0,0,10,14] 。
 * 第二步，将 10 改为 0 。 nums变成 [1,0,0,0,14] 。
 * 第三步，将 14 改为 1 。 nums变成 [1,0,0,0,1] 。
 * 执行 3 步后，最小值和最大值之间的差值为 1 - 0 = 1 。
 * 可以看出，没有办法可以在 3 步内使差值变为0。
 * 示例 3：
 *
 * 输入：nums = [3,100,20]
 * 输出：0
 * 解释：我们最多可以走 3 步。
 * 第一步，将 100 改为 7 。 nums 变成 [3,7,20] 。
 * 第二步，将 20 改为 7 。 nums 变成 [3,7,7] 。
 * 第三步，将 3 改为 7 。 nums 变成 [7,7,7] 。
 * 执行 3 步后，最小值和最大值之间的差值是 7 - 7 = 0。
 * @Version 1.0
 */
public class minimumdifferencebetweenlargestandsmallestvalueinthreemoves {
    public int minDifference(int[] nums) {
        //滑动窗口
        if(nums.length < 5) return 0;
        Arrays.sort(nums);
        int left = 3 , right = nums.length-1 , min = Integer.MAX_VALUE;
        for(; left>=0; left--){
            min = Math.min(min,nums[right] - nums[left]);
            right--;
        }
        return min;
    }
}