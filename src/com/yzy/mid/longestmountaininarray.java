package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/22 11:16
 * @Description
 * 把符合下列属性的数组 arr 称为 山脉数组 ：
 *
 * arr.length >= 3
 * 存在下标 i（0 < i < arr.length - 1），满足
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * 给出一个整数数组 arr，返回最长山脉子数组的长度。如果不存在山脉子数组，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的山脉子数组是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 *
 * 输入：arr = [2,2,2]
 * 输出：0
 * 解释：不存在山脉子数组。
 * @Version 1.0
 */
public class longestmountaininarray {
    public int longestMountain(int[] arr) {
        if (arr == null || arr.length < 3) return 0;
        int len = arr.length;
        int idx = 0;
        int ans = 0;
        while (idx < len) {
            int left = 0;
            while (idx + 1 < len && arr[idx] < arr[idx + 1]) {
                idx++;
                left++;
            }
            int right = 0;
            while (idx + 1 < len && arr[idx] > arr[idx + 1]) {
                idx++;
                right++;
            }
            if (left > 0 && right > 0) {
                ans = Math.max(ans, left + right + 1);
            }
            if (right == 0) idx++;
        }
        return ans;
    }
}