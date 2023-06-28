package com.yzy.hard;

import java.util.Arrays;

/**
 * ClassName: MinimumIncompatibility
 * Description:
 * 给你一个整数数组 nums 和一个整数 k 。你需要将这个数组划分到 k 个相同大小的子集中，使得同一个子集里面没有两个相同的元素。
 * <p>
 * 一个子集的 不兼容性 是该子集里面最大值和最小值的差。
 * <p>
 * 请你返回将数组分成 k 个子集后，各子集 不兼容性 的 和 的 最小值 ，如果无法分成分成 k 个子集，返回 -1 。
 * <p>
 * 子集的定义是数组中一些数字的集合，对数字顺序没有要求。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,1,4], k = 2
 * 输出：4
 * 解释：最优的分配是 [1,2] 和 [1,4] 。
 * 不兼容性和为 (2-1) + (4-1) = 4 。
 * 注意到 [1,1] 和 [2,4] 可以得到更小的和，但是第一个集合有 2 个相同的元素，所以不可行。
 * 示例 2：
 * <p>
 * 输入：nums = [6,3,8,1,3,1,2,2], k = 4
 * 输出：6
 * 解释：最优的子集分配为 [1,2]，[2,3]，[6,8] 和 [1,3] 。
 * 不兼容性和为 (2-1) + (3-2) + (8-6) + (3-1) = 6 。
 * 示例 3：
 * <p>
 * 输入：nums = [5,3,3,6,3,3], k = 3
 * 输出：-1
 * 解释：没办法将这些数字分配到 3 个子集且满足每个子集里没有相同数字。
 *
 * @author Administrator
 * @date 2023-6-28 15:43
 */
public class MinimumIncompatibility {
    int len, n;
    int[][] memo;
    int[] nums;
    int inf = (int) 1e9 + 7;

    public int minimumIncompatibility(int[] nums, int k) {

        n = nums.length;
        len = n / k;
        this.nums = nums;
        int[] count = new int[n + 1];
        for (int e : nums) ++count[e];
        for (int e : count) if (e > k) return -1;

        int m = 1 << n;
        memo = new int[m - 1][n];
        for (int i = 0; i < m - 1; ++i) Arrays.fill(memo[i], -1);
        Arrays.sort(nums);
        return dfs(m - 2, 0);
    }

    public int dfs(int left, int pre) {

        if (left == 0) return 0;
        if (memo[left][pre] > -1) return memo[left][pre];
        //创建一个新的组
        if (Integer.bitCount(left) % len == 0) {

            int lowbit = left & -left;
            return dfs(left ^ lowbit, 32 - Integer.numberOfLeadingZeros(lowbit) - 1);
        }
        int res = inf;
        int last = nums[pre];
        for (int i = pre + 1; i < n; ++i) //枚举本组的下一个数
            if ((left >> i & 1) > 0 && nums[i] != last) { //判断重复数字

                last = nums[i];
                res = Min(res, last - nums[pre] + dfs(left ^ 1 << i, i));
            }
        return memo[left][pre] = res;
    }

    public int Min(int a, int b) {
        return a < b ? a : b;

    }
}
