package com.yzy.simple;

/**
 * ClassName: ElementAppearingMoreThan25InSortedArray
 * Description:
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 *
 * 请你找到并返回这个整数
 *
 *
 *
 * 示例：
 *
 * 输入：arr = [1,2,2,6,6,6,6,7,10]
 * 输出：6
 * @author Administrator
 * @date 2023-4-27 14:12
 */
public class ElementAppearingMoreThan25InSortedArray {
    public static void main(String[] args) {

    }

    /**
     * 这个函数首先计算出现次数超过 25% 的阈值（threshold）。然后遍历数组，
     * 对于每个元素，检查其与距离为 threshold 的元素是否相等。如果相等，
     * 说明该元素出现次数超过 25%，返回该元素。如果遍历完数组后没有找到满足条件的元素，则返回 -1。
     * @param arr
     * @return
     */
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int threshold = n / 4;

        for (int i = 0; i < n - threshold; i++) {
            if (arr[i] == arr[i + threshold]) {
                return arr[i];
            }
        }

        return -1;
    }
}
