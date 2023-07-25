package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/24 00:13
 * @Description
 * 定义字符串 base 为一个 "abcdefghijklmnopqrstuvwxyz" 无限环绕的字符串，所以 base 看起来是这样的：
 *
 * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 * 给你一个字符串 s ，请你统计并返回 s 中有多少 不同非空子串 也在 base 中出现。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "a"
 * 输出：1
 * 解释：字符串 s 的子字符串 "a" 在 base 中出现。
 * 示例 2：
 *
 * 输入：s = "cac"
 * 输出：2
 * 解释：字符串 s 有两个子字符串 ("a", "c") 在 base 中出现。
 * 示例 3：
 *
 * 输入：s = "zab"
 * 输出：6
 * 解释：字符串 s 有六个子字符串 ("z", "a", "b", "za", "ab", and "zab") 在 base 中出现。
 * @Version 1.0
 */
public class uniqueSubstringsInWraparoundString {
    public int findSubstringInWraproundString(String _s) {
        int n = _s.length();
        char[] s = _s.toCharArray();
        int[] nums = new int[27];

        for (int i = 0, j = 0; i < n; i ++) {
            j = i;
            while(j + 1 < n && ((s[j] + 1 == s[j + 1]) || (s[j] - 25 == s[j + 1]))) j ++;
            for (int k = 0, p = s[i] - 'a'; k <= 26; k ++) {
                nums[(p + k) % 26] = Math.max(nums[(p + k) % 26], (j - i + 1) - k);
            }
            i = j;
        }
        int ans = 0;
        for (int i = 0; i < 26; i ++) ans += nums[i];
        return ans;
    }
}