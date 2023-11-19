package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/20 00:13
 * @Description
 * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
 *
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
 *
 * 请注意，答案不一定是 arr 中的数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [4,9,3], target = 10
 * 输出：3
 * 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
 * 示例 2：
 *
 * 输入：arr = [2,3,5], target = 10
 * 输出：5
 * 示例 3：
 *
 * 输入：arr = [60864,25176,27249,21296,20204], target = 56803
 * 输出：11361
 * @Version 1.0
 */
public class sumofmutatedarrayclosesttotarget {
    public int findBestValue(int[] arr, int target) {
        //遍历查找value比较耗时，因此可以二分查找
        //二分的左边界是target/arr.lenght，右边界是max(arr)
        int l = target/arr.length, r = 0;
        for(int a: arr) r = Math.max(r,a);
        while(l<=r){
            int mid = l+(r-l)/2;
            int s = sum(arr,mid);
            if(s==target) return mid;
            if(s<target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        if(Math.abs(sum(arr,l)-target)<Math.abs(sum(arr,r)-target)){
            return l;
        }
        return r;
    }
    public int sum(int[] arr,int max){
        int sum = 0;
        for(int n: arr) sum += Math.min(n,max);
        return sum;
    }
}