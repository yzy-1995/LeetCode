package com.yzy.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: IntersectionofTwoArrays
 * Description:
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 * @author Administrator
 * @date 2023-3-30 17:29
 */
public class IntersectionofTwoArrays {
    public static void main(String[] args) {

    }


    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (Integer ans :nums1) {
            set1.add(ans);
        }
        for (Integer ans :nums2) {
            if (set1.contains(ans)) {
                set2.add(ans);
            }
        }
        int[] result = new int[set2.size()];
        int i =0;
        for (Integer o :set2) {
            result[i++] = o;
        }

        return result;
    }
}
