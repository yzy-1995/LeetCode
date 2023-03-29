package com.yzy.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: ThreeSum
 * Description:
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * @author Administrator
 * @date 2023-3-28 14:47
 */
public class ThreeSum {
    /**
     * 这道题可以用双指针的方法来解决。首先将数组排序，然后对于每个数 nums[i]，使用双指针的方法找到剩下两个数的组合。
     *
     * 具体来说，我们固定一个指针 i，然后用左右两个指针 l 和 r 分别指向 nums[i+1] 和 nums[n-1]。
     * 如果 nums[i] + nums[l] + nums[r] 的和大于 0，那么我们将右指针左移；如果和小于 0，那么我们将左指针右移；
     * 如果和等于 0，那么我们就找到了一个满足条件的三元组，将其添加到结果中。
     *
     * 需要注意的是，由于题目要求不能重复，因此我们需要在每次找到满足条件的三元组后，跳过所有重复的元素，以避免出现重复的结果。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                }
            }
        }
        return res;
    }
}
