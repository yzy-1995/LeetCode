package com.yzy.mid;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/10 00:07
 * @Description
 * 给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数  组成，且其中所有整数互不相同。
 *
 * 对于每对满足 0 <= i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。
 *
 * 那么第 k 个最小的分数是多少呢?  以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] == arr[j] 。
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3,5], k = 3
 * 输出：[2,5]
 * 解释：已构造好的分数,排序后如下所示:
 * 1/5, 1/3, 2/5, 1/2, 3/5, 2/3
 * 很明显第三个最小的分数是 2/5
 * 示例 2：
 *
 * 输入：arr = [1,7], k = 1
 * 输出：[1,7]
 * @Version 1.0
 */
public class kthsmallestprimefraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        if (arr.length==2){
            return arr;
        }
        int length=arr.length;
        ArrayList<int[]> arrayList= new ArrayList<>();
        for (int  i = 0; i <length; i++) {
            for (int j = i+1; j <length; j++) {
                arrayList.add(new int[]{arr[i],arr[j]});
            }
        }
        arrayList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[0] * n[1] - m[1] * n[0];
            }
        });
        return arrayList.get(k-1);
    }
}