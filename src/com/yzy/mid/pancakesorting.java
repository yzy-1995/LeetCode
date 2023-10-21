package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/17 16:06
 * @Description
 * 给你一个整数数组 arr ，请使用 煎饼翻转 完成对数组的排序。
 *
 * 一次煎饼翻转的执行过程如下：
 *
 * 选择一个整数 k ，1 <= k <= arr.length
 * 反转子数组 arr[0...k-1]（下标从 0 开始）
 * 例如，arr = [3,2,1,4] ，选择 k = 3 进行一次煎饼翻转，反转子数组 [3,2,1] ，得到 arr = [1,2,3,4] 。
 *
 * 以数组形式返回能使 arr 有序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * arr.length 范围内的有效答案都将被判断为正确。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[3,2,4,1]
 * 输出：[4,2,4,3]
 * 解释：
 * 我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
 * 初始状态 arr = [3, 2, 4, 1]
 * 第一次翻转后（k = 4）：arr = [1, 4, 2, 3]
 * 第二次翻转后（k = 2）：arr = [4, 1, 2, 3]
 * 第三次翻转后（k = 4）：arr = [3, 2, 1, 4]
 * 第四次翻转后（k = 3）：arr = [1, 2, 3, 4]，此时已完成排序。
 * 示例 2：
 *
 * 输入：[1,2,3]
 * 输出：[]
 * 解释：
 * 输入已经排序，因此不需要翻转任何内容。
 * 请注意，其他可能的答案，如 [3，3] ，也将被判断为正确。
 * @Version 1.0
 */
public class pancakesorting {
    public List<Integer> pancakeSort(int[] arr) {
        int right = arr.length - 1;
        List<Integer> list = new ArrayList<>();
        while(!sorted(arr)) {
            int maxPos = findMax(arr, 0, right);
            reverse(arr, 0, maxPos);
            reverse(arr, 0, right);
            list.add(maxPos + 1);
            list.add(right + 1);
            right--;
        }
        return list;
    }
    boolean sorted(int []arr) {
        for(int i = 1; i < arr.length; i++ ) {
            if( arr[i-1] > arr[i] ) return false;
        }
        return true;
    }
    int findMax(int [] arr, int left, int right ) {
        int max = left;
        for(int i = left + 1; i <= right; i++ ) {
            if(arr[i] >= arr[max]) max = i;
        }
        return max;
    }
    int [] reverse(int [] arr, int left, int right) {
        while(left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left ++;
            right --;
        }
        return arr;
    }
}