package com.yzy.mid;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/29 03:06
 * @Description
 * 给出一个含有不重复整数元素的数组 arr ，每个整数 arr[i] 均大于 1。
 *
 * 用这些整数来构建二叉树，每个整数可以使用任意次数。其中：每个非叶结点的值应等于它的两个子结点的值的乘积。
 *
 * 满足条件的二叉树一共有多少个？答案可能很大，返回 对 109 + 7 取余 的结果。
 *
 *
 *
 * 示例 1:
 *
 * 输入: arr = [2, 4]
 * 输出: 3
 * 解释: 可以得到这些二叉树: [2], [4], [4, 2, 2]
 * 示例 2:
 *
 * 输入: arr = [2, 4, 5, 10]
 * 输出: 7
 * 解释: 可以得到这些二叉树: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 * @Version 1.0
 */
public class binarytreeswithfactors {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        final long mod = 1000000007;
        HashMap<Integer,Long> map = new HashMap<>();
        for (int i : arr) map.put(i,1l);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (1l*arr[i]*arr[j]<=arr[arr.length-1]) {
                    if (map.containsKey(arr[i]*arr[j])) {
                        if (i==j) {
                            map.put(arr[i]*arr[j],(map.get(arr[i])*map.get(arr[j])+map.get(arr[i]*arr[j]))%mod);
                        }else {
                            map.put(arr[i]*arr[j],(2*map.get(arr[i])*map.get(arr[j])+map.get(arr[i]*arr[j]))%mod);
                        }
                    }
                }
            }
        }
        long rtu = 0;
        for (int i : arr) {
            rtu+=map.get(i);
            rtu%=mod;
        }
        return (int)rtu;
    }
}