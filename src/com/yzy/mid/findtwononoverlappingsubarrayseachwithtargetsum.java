package com.yzy.mid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/20 21:06
 * @Description
 * 给你一个整数数组 arr 和一个整数值 target 。
 *
 * 请你在 arr 中找 两个互不重叠的子数组 且它们的和都等于 target 。可能会有多种方案，请你返回满足要求的两个子数组长度和的 最小值 。
 *
 * 请返回满足要求的最小长度和，如果无法找到这样的两个子数组，请返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,2,4,3], target = 3
 * 输出：2
 * 解释：只有两个子数组和为 3 （[3] 和 [3]）。它们的长度和为 2 。
 * 示例 2：
 *
 * 输入：arr = [7,3,4,7], target = 7
 * 输出：2
 * 解释：尽管我们有 3 个互不重叠的子数组和为 7 （[7], [3,4] 和 [7]），但我们会选择第一个和第三个子数组，因为它们的长度和 2 是最小值。
 * 示例 3：
 *
 * 输入：arr = [4,3,2,6,2,3,4], target = 6
 * 输出：-1
 * 解释：我们只有一个和为 6 的子数组。
 * 示例 4：
 *
 * 输入：arr = [5,5,4,4,5], target = 3
 * 输出：-1
 * 解释：我们无法找到和为 3 的子数组。
 * 示例 5：
 *
 * 输入：arr = [3,1,1,1,5,1,2,1], target = 3
 * 输出：3
 * 解释：注意子数组 [1,2] 和 [2,1] 不能成为一个方案因为它们重叠了。
 * @Version 1.0
 */
public class findtwononoverlappingsubarrayseachwithtargetsum {
    public int minSumOfLengths(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int sum = 0, length = arr.length, ans = 100002;
//dp存的是当前坐标之前的最短长度
        int[] dp = new int[length + 1];
        Arrays.fill(dp, 100007);
        for(int i = 1; i<= length; ++i){
            sum += arr[i - 1];
            int fg = sum - target;
            dp[i] = dp[i - 1];
            if(map.containsKey(fg)){
                int pos = map.get(fg);
                int curr = i - pos;
                dp[i] = Math.min(dp[i], curr);
                //ans = 之前的最短长度 + 当前最短长度
                ans = Math.min(ans, curr + dp[pos]);
            }
            map.put(sum, i);
        }
        return ans == 100002 ? -1: ans;
    }
}