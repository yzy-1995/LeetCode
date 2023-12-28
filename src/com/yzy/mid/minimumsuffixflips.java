package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/27 00:06
 * @Description
 * 给你一个长度为 n 、下标从 0 开始的二进制字符串 target 。你自己有另一个长度为 n 的二进制字符串 s ，最初每一位上都是 0 。你想要让 s 和 target 相等。
 *
 * 在一步操作，你可以选择下标 i（0 <= i < n）并翻转在 闭区间 [i, n - 1] 内的所有位。翻转意味着 '0' 变为 '1' ，而 '1' 变为 '0' 。
 *
 * 返回使 s 与 target 相等需要的最少翻转次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = "10111"
 * 输出：3
 * 解释：最初，s = "00000" 。
 * 选择下标 i = 2: "00000" -> "00111"
 * 选择下标 i = 0: "00111" -> "11000"
 * 选择下标 i = 1: "11000" -> "10111"
 * 要达成目标，需要至少 3 次翻转。
 * 示例 2：
 *
 * 输入：target = "101"
 * 输出：3
 * 解释：最初，s = "000" 。
 * 选择下标 i = 0: "000" -> "111"
 * 选择下标 i = 1: "111" -> "100"
 * 选择下标 i = 2: "100" -> "101"
 * 要达成目标，需要至少 3 次翻转。
 * 示例 3：
 *
 * 输入：target = "00000"
 * 输出：0
 * 解释：由于 s 已经等于目标，所以不需要任何操作
 * @Version 1.0
 */
public class minimumsuffixflips {
    public int minFlips(String s) {
        int ans = 0;
        int n = s.length();
        if (s.charAt(0) == '1') ++ans;
        for (int i = 0; i < n-1; ++i) {
            if (s.charAt(i) != s.charAt(i+1)) {
                ++ans;
            }
        }
        return ans;
    }
}