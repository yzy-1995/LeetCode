package com.yzy.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: MinimumCommonValue
 * Description:
 * 给你两个整数数组 nums1 和 nums2 ，它们已经按非降序排序，请你返回两个数组的 最小公共整数 。如果两个数组 nums1 和 nums2 没有公共整数，请你返回 -1 。
 * 如果一个整数在两个数组中都 至少出现一次 ，那么这个整数是数组 nums1 和 nums2 公共 的。
 * 示例 1：
 * 输入：nums1 = [1,2,3], nums2 = [2,4]
 * 输出：2
 * 解释：两个数组的最小公共元素是 2 ，所以我们返回 2 。
 * 示例 2：
 * 输入：nums1 = [1,2,3,6], nums2 = [2,3,4,5]
 * 输出：2
 * 解释：两个数组中的公共元素是 2 和 3 ，2 是较小值，所以返回 2 。
 *
 * @author Administrator
 * @date 2023-5-11 9:06
 */
public class MinimumCommonValue {
    public static void main(String[] args) {

    }

    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                min = Math.min(min, num);
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}
