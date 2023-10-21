package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/18 00:16
 * @Description
 * 给定一个整数数组 arr ，返回 arr 的 最大湍流子数组的长度 。
 *
 * 如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是 湍流子数组 。
 *
 * 更正式地来说，当 arr 的子数组 A[i], A[i+1], ..., A[j] 满足仅满足下列条件时，我们称其为湍流子数组：
 *
 * 若 i <= k < j ：
 * 当 k 为奇数时， A[k] > A[k+1]，且
 * 当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j ：
 * 当 k 为偶数时，A[k] > A[k+1] ，且
 * 当 k 为奇数时， A[k] < A[k+1]。
 *
 *
 * 示例 1：
 *
 * 输入：arr = [9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：arr[1] > arr[2] < arr[3] > arr[4] < arr[5]
 * 示例 2：
 *
 * 输入：arr = [4,8,12,16]
 * 输出：2
 * 示例 3：
 *
 * 输入：arr = [100]
 * 输出：1
 * @Version 1.0
 */
public class longestturbulentsubarray {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length<2) return arr.length;
        int l=0,max=1,flag=0;
        for (int i=1;i<arr.length;i++){
            if (arr[i]==arr[i-1]){
                l=i;
                flag=0;
                max=Math.max(max,i-1-l);
            } else if (arr[i]>arr[i-1]) {
                switch (flag){
                    case -1:
                        flag+=2;
                        max=Math.max(max,i-l+1);
                        break;
                    case 0:
                        flag++;
                        max=Math.max(max,2);
                        break;
                    case 1:
                        l=i-1;
                        break;
                }
            }else{
                switch (flag){
                    case 1:
                        flag-=2;
                        max=Math.max(max,i+1-l);
                        break;
                    case 0:
                        flag--;
                        max=Math.max(max,2);
                        break;
                    case -1:
                        l=i-1;
                        break;
                }
            }
        }
        return max;
    }
}