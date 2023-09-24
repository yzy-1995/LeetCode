package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/24 00:07
 * @Description
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 *
 * 你必须设计并实现时间复杂度为 O(log(n)) 的解决方案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [0,1,0]
 * 输出：1
 * 示例 2：
 *
 * 输入：arr = [0,2,1,0]
 * 输出：1
 * 示例 3：
 *
 * 输入：arr = [0,10,5,2]
 * 输出：1
 *
 * @Version 1.0
 */
public class peakindexinamountainarray {
    public int peakIndexInMountainArray(int[] arr) {
        //二分法,先选择左右两下标。
        int left=0;
        int right=arr.length-1;
        int mid=0;
        while(left<right){
            mid=left+(right-left)/2;
            //左右都小于mid，说明mid是山峰。
            if(arr[mid-1]<arr[mid]&& arr[mid]>arr[mid+1]) break;
            //右边比左边高，说明山峰在右侧
            if(arr[mid+1]>arr[mid]) left=mid;
                //右边比左边低，山峰在左侧
            else if(arr[mid+1]<arr[mid]) right=mid;
        }
        return mid;
    }
}