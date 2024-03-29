package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/31 09:57
 * @Description
 * 给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。
 *
 * 每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。
 *
 * 请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
 * 输出：3
 * 解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
 * - 将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] 。
 * - 将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] 。
 * - 将 nums1[2] 变为 2 。 nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] 。
 * 示例 2：
 *
 * 输入：nums1 = [1,1,1,1,1,1,1], nums2 = [6]
 * 输出：-1
 * 解释：没有办法减少 nums1 的和或者增加 nums2 的和使二者相等。
 * 示例 3：
 *
 * 输入：nums1 = [6,6], nums2 = [1]
 * 输出：3
 * 解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
 * - 将 nums1[0] 变为 2 。 nums1 = [2,6], nums2 = [1] 。
 * - 将 nums1[1] 变为 2 。 nums1 = [2,2], nums2 = [1] 。
 * - 将 nums2[0] 变为 4 。 nums1 = [2,2], nums2 = [4] 。
 * @Version 1.0
 */
public class equalsumarrayswithminimumnumberofoperations {
    public int minOperations(int[] nums1, int[] nums2) {
        // 先进行极限判断
        if(6 * nums1.length < nums2.length || 6 * nums2.length < nums1.length) return -1;
        // 看两个数组的差值
        int diff = 0;
        for(int x: nums2) diff += x;
        for(int x: nums1) diff -= x;
        // 判断哪个数组的总和大
        if(diff < 0){
            diff = -diff;
            int[] t = nums1;
            nums1 = nums2;
            nums2 = t;
        }
        // 将nums1变为是小的一方
        int[] cnt = new int[6]; // 定义最大改变量为i的个数有多少个， 比如 5 如果要减少，最大能减少到1， 则 cnt[5 - 1] ++
        // 将小的数组，增多，大的数组减少
        for(int x: nums1) cnt[6 - x] ++;// 小的数组，最大只能到6
        for(int x: nums2) cnt[x - 1] ++; // 大的数组，最小只能到1
        for(int i = 5, ans = 0; i >= 1; i --){ // 从变化最大的开始
            if(i * cnt[i] >= diff){ // 如果当前总的变化和大于diff，说明当前操作可以让diff成为0
                return ans + (diff + i - 1) / i; // diff / i 的向上取整， 如diff = 10, i = 3, 则 diff + i - 1 / i = 4
            }
            diff -= i * cnt[i]; // 看下一个
            ans += cnt[i]; // 记录下当前变化的次数
        }
        return -1;
    }
}