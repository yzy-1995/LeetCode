package com.yzy.simple;

/**
 * Description: leetcode2269
 * 一个整数 num 的 k 美丽值定义为 num 中符合以下条件的 子字符串 数目：
 * 子字符串长度为 k 。
 * 子字符串能整除 num 。
 * 给你整数 num 和 k ，请你返回 num 的 k 美丽值。
 * 注意：
 * 允许有 前缀 0 。
 * 0 不能整除任何值。
 * 一个 子字符串 是一个字符串里的连续一段字符序列。
 * 示例 1：
 * 输入：num = 240, k = 2
 * 输出：2
 * 解释：以下是 num 里长度为 k 的子字符串：
 * - "240" 中的 "24" ：24 能整除 240 。
 * - "240" 中的 "40" ：40 能整除 240 。
 * 所以，k 美丽值为 2 。
 * 示例 2：
 * 输入：num = 430043, k = 2
 * 输出：2
 * 解释：以下是 num 里长度为 k 的子字符串：
 * - "430043" 中的 "43" ：43 能整除 430043 。
 * - "430043" 中的 "30" ：30 不能整除 430043 。
 * - "430043" 中的 "00" ：0 不能整除 430043 。
 * - "430043" 中的 "04" ：4 不能整除 430043 。
 * - "430043" 中的 "43" ：43 能整除 430043 。
 * 所以，k 美丽值为 2 。
 *
 * @author yzy15
 * @date 2023/05/08 20:24
 **/
public class FindtheKBeautyofaNumber {
    public static void main(String[] args) {

    }

    public int divisorSubstrings(int num, int k) {
        int[] nums = new int[10];
        int i = 0, len = 0;
        int onum = num; //保存原始num值
        while (num > 0) {
            nums[i] = num % 10;
            num = num / 10;
            i++;
        }
        len = i;
        int count = 0;

        for (int j = len - 1; j >= k - 1; j--) {
            int sum = 0;
            for (int m = j; m >= j - k + 1; m--) {
                sum = sum * 10 + nums[m];
            }
            if (sum != 0 && onum % sum == 0) count++;

        }

        return count;
    }
}
