package com.yzy.simple;

import java.util.*;

/**
 * ClassName: RelativeSortArray
 * Description:
 * 给你两个数组，arr1 和 arr2，arr2 中的元素各不相同，arr2 中的每个元素都出现在 arr1 中。
 *
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * 示例  2:
 *
 * 输入：arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
 * 输出：[22,28,8,6,17,44]
 * @author Administrator
 * @date 2023-4-26 13:45
 */
public class RelativeSortArray {
    public static void main(String[] args) {

    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int index = 0;
        for (int num : arr2) {
            int count = countMap.get(num);
            while (count > 0) {
                arr1[index++] = num;
                count--;
            }
            countMap.remove(num);
        }

        List<Integer> remaining = new ArrayList<>(countMap.keySet());
        Collections.sort(remaining);

        for (int num : remaining) {
            int count = countMap.get(num);
            while (count > 0) {
                arr1[index++] = num;
                count--;
            }
        }

        return arr1;
    }
}
