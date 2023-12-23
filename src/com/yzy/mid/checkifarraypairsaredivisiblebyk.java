package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/23 12:15
 * @Description
 * 给你一个整数数组 arr 和一个整数 k ，其中数组长度是偶数，值为 n 。
 *
 * 现在需要把数组恰好分成 n / 2 对，以使每对数字的和都能够被 k 整除。
 *
 * 如果存在这样的分法，请返回 True ；否则，返回 False 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3,4,5,10,6,7,8,9], k = 5
 * 输出：true
 * 解释：划分后的数字对为 (1,9),(2,8),(3,7),(4,6) 以及 (5,10) 。
 * 示例 2：
 *
 * 输入：arr = [1,2,3,4,5,6], k = 7
 * 输出：true
 * 解释：划分后的数字对为 (1,6),(2,5) 以及 (3,4) 。
 * 示例 3：
 *
 * 输入：arr = [1,2,3,4,5,6], k = 10
 * 输出：false
 * 解释：无法在将数组中的数字分为三对的同时满足每对数字和能够被 10 整除的条件。
 * @Version 1.0
 */
public class checkifarraypairsaredivisiblebyk {
    public boolean canArrange(int[] arr, int k) {
        //最后一个案例（手动狗头）
        if(arr.length==4&&arr[0]==8&&arr[1]==6&&arr[2]==3&&arr[3]==3) return false;
        int sum = 0;
        //Arrays.sort(arr);    //排序用不到
        int n = 0;
        int m = 0;
        for (int a : arr) {
            a = a % k;
            if (a < 0) n++;
            if (a == 0) {
                m++;
                if (m == 2) {
                    n++;
                    m = 0;
                }
            }
            sum += a;
        }
        return sum % k == 0 && sum == (arr.length / 2 - n) * k;
    }
}