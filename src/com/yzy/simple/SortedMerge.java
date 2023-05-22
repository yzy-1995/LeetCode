package com.yzy.simple;

/**
 * Description: le
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * 示例:
 *
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 * 说明:
 *
 * A.length == n + m
 * @author yzy15
 * @date 2023/05/20 15:54
 **/
public class SortedMerge {

    public void merge(int[] A, int m, int[] B, int n) {
        int a = m - 1;
        int b = n - 1;
        for (int i = A.length - 1; i >= 0; i--) {
            if (a < 0) {
                A[i] = B[b];
                b -= 1;
            } else if (b < 0) {
                A[i] = A[a];
                a -= 1;
            } else {
                if (A[a] < B[b]) {
                    A[i] = B[b];
                    b -= 1;
                } else {
                    A[i] = A[a];
                    a -= 1;
                }
            }
        }
    }
}
