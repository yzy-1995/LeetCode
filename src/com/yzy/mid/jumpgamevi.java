package com.yzy.mid;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/19 00:44
 * @Description 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * <p>
 * 一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1, i + k)] 包含 两个端点的任意位置。
 * <p>
 * 你的目标是到达数组最后一个位置（下标为 n - 1 ），你的 得分 为经过的所有数字之和。
 * <p>
 * 请你返回你能得到的 最大得分 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,-1,-2,4,-7,3], k = 2
 * 输出：7
 * 解释：你可以选择子序列 [1,-1,4,3] （上面加粗的数字），和为 7 。
 * 示例 2：
 * <p>
 * 输入：nums = [10,-5,-2,4,0,3], k = 3
 * 输出：17
 * 解释：你可以选择子序列 [10,4,3] （上面加粗数字），和为 17 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
 * 输出：0
 * @Version 1.0
 */
public class jumpgamevi {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        Queue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        q.add(new int[]{0, nums[0]});
        for (int i = 1; ; i++) {
            while (q.peek()[0] < i - k) {
                q.poll();
            }
            int ans = nums[i] + q.peek()[1];
            if (i == n - 1) {
                return ans;
            }
            q.add(new int[]{i, ans});
        }
    }
}