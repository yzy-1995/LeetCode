package com.yzy.simple;

import java.util.*;

/**
 * ClassName: OfferII075
 * Description:
 * 给定两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * @author Administrator
 * @date 2023-5-19 16:06
 */
public class OfferII075 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        //记录每个元素出现次数
        for (int num : arr1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        //按照 arr2 的排序填写 arr1
        for (int num : arr2) {
            int temp = map.get(num);
            for (int i = 0; i < temp; i++) {
                list.add(num);
            }
        }
        //将剩下的数加入到 list2 并排序
        for (int num : arr1) {
            if (!list.contains(num)) {
                list2.add(num);
            }
        }
        Collections.sort(list2);
        for (int num : list2) {
            list.add(num);
        }
        //list 转为数组
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }
}
