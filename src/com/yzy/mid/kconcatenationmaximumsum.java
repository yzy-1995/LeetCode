package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/07 16:04
 * @Description.
 * 给定一个整数数组 arr 和一个整数 k ，通过重复 k 次来修改数组。
 *
 * 例如，如果 arr = [1, 2] ， k = 3 ，那么修改后的数组将是 [1, 2, 1, 2, 1, 2] 。
 *
 * 返回修改后的数组中的最大的子数组之和。注意，子数组长度可以是 0，在这种情况下它的总和也是 0。
 *
 * 由于 结果可能会很大，需要返回的 109 + 7 的 模 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2], k = 3
 * 输出：9
 * 示例 2：
 *
 * 输入：arr = [1,-2,1], k = 5
 * 输出：2
 * 示例 3：
 *
 * 输入：arr = [-1,-2], k = 7
 * 输出：0
 * @Version 1.0
 */
public class kconcatenationmaximumsum {
    public int kConcatenationMaxSum(int[] arr, int k) {
        long max = 0;
        long temp_leftToRight = 0;
        long temp_rightToLeft = 0;
        long max_leftToRight = 0;
        long max_rightToLeft = 0;
        long sum = 0;
        long temp = 0;
        if (k == 1){
            for (int i = 0;i < arr.length;i++){
                temp = temp + arr[i] < 0 ? 0 : temp + arr[i];
                max = Math.max(temp,max);
            }
            return (int)max;
        }else{
            for (int i = 0;i < arr.length * 2;i++){
                temp = temp + arr[i%arr.length] < 0 ? 0 : temp + arr[i % arr.length];
                max = Math.max(temp,max);
                sum += arr[i%arr.length];
            }
            sum /=2;
            for (int i = 0;i < arr.length;i++){
                temp_leftToRight = temp_leftToRight + arr[i];
                max_leftToRight = Math.max(max_leftToRight,temp_leftToRight);

                temp_rightToLeft = temp_rightToLeft + arr[arr.length - i - 1];
                max_rightToLeft = Math.max(max_rightToLeft,temp_rightToLeft);
            }
            if (sum > 0){
                return (int)Math.max(((long)max_leftToRight + (long)max_rightToLeft + (long)(k-2) * (long)sum) % (1e9+7),max % (1e9+7));
            }else{
                return (int) (max % (1e9+7));
            }
        }

    }
}