package com.yzy.simple;

/**
 * Description: leetcode941
 * 给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。
 * 让我们回顾一下，如果 arr 满足下述条件，那么它是一个山脉数组：
 * arr.length >= 3
 * 在 0 < i < arr.length - 1 条件下，存在 i 使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 示例 1：
 * 输入：arr = [2,1]
 * 输出：false
 * 示例 2：
 * 输入：arr = [3,5,5]
 * 输出：false
 * 示例 3：
 * 输入：arr = [0,3,2,1]
 * 输出：true
 * @author yzy15
 * @date 2023/04/22 22:07
 **/
public class ValidMountainArray {
    public static void main(String[] args) {

    }

    public boolean validMountainArray(int[] arr) {
        if (arr == null || arr.length < 3) {
            return false;
        }

        int i = 0;
        // 上升阶段
        while (i < arr.length - 1 && arr[i] < arr[i + 1]) {
            i++;
        }

        // 如果在数组的起点或终点，则不是山脉数组
        if (i == 0 || i == arr.length - 1) {
            return false;
        }

        // 下降阶段
        while (i < arr.length - 1 && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == arr.length - 1;
    }
}
