package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/25 13:39
 * @Description
 * 给你一个二进制字符串 s（仅由 '0' 和 '1' 组成的字符串）。
 *
 * 返回所有字符都为 1 的子字符串的数目。
 *
 * 由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "0110111"
 * 输出：9
 * 解释：共有 9 个子字符串仅由 '1' 组成
 * "1" -> 5 次
 * "11" -> 3 次
 * "111" -> 1 次
 * 示例 2：
 *
 * 输入：s = "101"
 * 输出：2
 * 解释：子字符串 "1" 在 s 中共出现 2 次
 * 示例 3：
 *
 * 输入：s = "111111"
 * 输出：21
 * 解释：每个子字符串都仅由 '1' 组成
 * 示例 4：
 *
 * 输入：s = "000"
 * 输出：0
 * @Version 1.0
 */
public class numberofsubstringswithonly1s {
    public int numSub(String s) {
        String[] split = s.split("0");
        int res = 0;
        int mod = (int)(Math.pow(10,9) + 7);
        for (String s1 : split) {
            long len = s1.length();
            if(len > 0){
                long n = (((1 + len) * len) % mod) / 2;
                res = (res + ((int)n % mod)) % mod;
            }
        }
        return  res % mod;
    }
}