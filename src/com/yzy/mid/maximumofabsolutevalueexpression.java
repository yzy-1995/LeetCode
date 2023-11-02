package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/02 00:05
 * @Description
 * 给你两个长度相等的整数数组，返回下面表达式的最大值：
 *
 * |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
 *
 * 其中下标 i，j 满足 0 <= i, j < arr1.length。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr1 = [1,2,3,4], arr2 = [-1,4,5,6]
 * 输出：13
 * 示例 2：
 *
 * 输入：arr1 = [1,-2,-5,0,10], arr2 = [0,-2,-1,-7,-4]
 * 输出：20
 * @Version 1.0
 */
public class maximumofabsolutevalueexpression {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        //简单的拆解一下即可，o(n)
        int max1 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, max2 = max1, min2 = min1, max3 = max1, min3 = min1, max4 = max1, min4 = min1;
        for(int i = 0; i < arr1.length; i++)
        {
            int x = arr1[i], a = arr2[i];
            max1 = Math.max(max1, x + a + i);
            min1 = Math.min(min1, x + a + i);
            max2 = Math.max(max2, x + a - i);
            min2 = Math.min(min2, x + a - i);
            max3 = Math.max(max3, x - a + i);
            min3 = Math.min(min3, x - a + i);
            max4 = Math.max(max4, x - a - i);
            min4 = Math.min(min4, x - a - i);
        }
        int max = Math.max(max1 - min1,Math.max(max2 - min2, Math.max(max3 - min3, max4 - min4)));
        return max;
    }
}