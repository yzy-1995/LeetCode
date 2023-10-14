package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/08 00:03
 * @Description
 * 给定一个整数数组 arr ，以及一个整数 target 作为目标值，返回满足 i < j < k 且 arr[i] + arr[j] + arr[k] == target 的元组 i, j, k 的数量。
 *
 * 由于结果会非常大，请返回 109 + 7 的模。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,1,2,2,3,3,4,4,5,5], target = 8
 * 输出：20
 * 解释：
 * 按值枚举(arr[i], arr[j], arr[k])：
 * (1, 2, 5) 出现 8 次；
 * (1, 3, 4) 出现 8 次；
 * (2, 2, 4) 出现 2 次；
 * (2, 3, 3) 出现 2 次。
 * 示例 2：
 *
 * 输入：arr = [1,1,2,2,2,2], target = 5
 * 输出：12
 * 解释：
 * arr[i] = 1, arr[j] = arr[k] = 2 出现 12 次：
 * 我们从 [1,1] 中选择一个 1，有 2 种情况，
 * 从 [2,2,2,2] 中选出两个 2，有 6 种情况。
 * @Version 1.0
 */
public class threesumwithmultiplicity {
    public int threeSumMulti(int[] A, int target) {
        int kMaxN = 100;
        int mod = (int)Math.pow(10,9) + 7;
        long[] c = new long[kMaxN + 1];
        for (int i = 0; i < A.length;i++){
            c[A[i]]++;
        }
        long ans = 0;
        for (int i = 0;i <= target;i++){
            for (int j = i;j <= target;j++){
                int k = target - i - j;
                if (k < 0 || k > c.length || k < j) continue;
                if (i < 0 || i > 100 || j < 0 || j > 100 || k < 0 || k > 100) continue;
                if (i == j && j == k) {
                    ans += (c[i] - 2) * (c[i] - 1) * c[i] / 6;
                }
                else if (i == j && j != k)
                    ans += c[i] * (c[i] - 1) / 2 * c[k];
                else if (i != j && j == k)
                    ans += c[i] * (c[j] - 1) * c[j] / 2;
                else
                    ans += c[i] * c[j] * c[k];
            }
        }
        return (int)(ans % mod);
    }
}