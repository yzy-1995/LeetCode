package com.yzy.simple;

/**
 * ClassName: LongestPalindrome
 * Description:
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 * <p>
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 示例 2:
 * <p>
 * 输入:s = "a"
 * 输出:1
 * 示例 3：
 * <p>
 * 输入:s = "aaaaaccc"
 * 输出:7
 *
 * @author Administrator
 * @date 2023-4-11 9:28
 */
public class LongestPalindrome {
    public static void main(String[] args) {

    }


    public int longestPalindrome(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }

        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

}
