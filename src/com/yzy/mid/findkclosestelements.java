package com.yzy.mid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/22 00:03
 * @Description
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 *
 * 整数 a 比整数 b 更接近 x 需要满足：
 *
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 * 示例 2：
 *
 * 输入：arr = [1,2,3,4,5], k = 4, x = -1
 * 输出：[1,2,3,4]
 *
 * @Version 1.0
 */
public class findkclosestelements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int minIdx = 0, minVal = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int val = Math.abs(arr[i] - x);
            if (val < minVal) {
                minVal = val;
                minIdx = i;
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(arr[minIdx]);

        int l = minIdx - 1, r = minIdx + 1;
        while (k > 1) {
            if (l < 0) list.add(arr[r++]);
            else if (r > arr.length - 1) list.add(arr[l--]);
            else if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) list.add(arr[l--]);
            else list.add(arr[r++]);
            k--;
        }
        Collections.sort(list);
        return list;
    }
}