package com.yzy.simple;

import java.util.*;

/**
 * ClassName: CheckIfNandItsDoubleExist
 * Description:
 * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
 * 更正式地，检查是否存在两个下标 i 和 j 满足：
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 * 示例 1：
 * 输入：arr = [10,2,5,3]
 * 输出：true
 * 解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
 * 示例 2：
 * 输入：arr = [7,1,14,11]
 * 输出：true
 * 解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
 * 示例 3：
 * 输入：arr = [3,1,7,11]
 * 输出：false
 * 解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
 * @author Administrator
 * @date 2023-4-28 15:34
 */
public class CheckIfNandItsDoubleExist {
    public static void main(String[] args) {
        System.out.println(checkIfExist(new int[]{-2,0,10,-19,4,6,-8}));
    }

    public static boolean checkIfExist(int[] arr) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (Integer o :arr) {
            list.add(o);
        }

        int removeValue = 0; // 要移除的元素的值

        // 使用 ArrayList 的 remove() 方法移除所有指定的元素
        while (list.contains(removeValue)) {
            list.remove(Integer.valueOf(removeValue));
        }
        Object[] array1 = list.toArray();
        for (int i = 0; i < array1.length-1; i++) {
            for (int j = 1; j < array1.length; j++) {
                if ((Integer) array1[j]==(Integer)array1[i]*2 || (Integer) array1[i]==(Integer)array1[j]*2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean chech(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
