package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/29 23:14
 * @Description
 * 给你一个字符串 s ，返回 s 中 同质子字符串 的数目。由于答案可能很大，只需返回对 109 + 7 取余 后的结果。
 *
 * 同质字符串 的定义为：如果一个字符串中的所有字符都相同，那么该字符串就是同质字符串。
 *
 * 子字符串 是字符串中的一个连续字符序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abbcccaa"
 * 输出：13
 * 解释：同质子字符串如下所列：
 * "a"   出现 3 次。
 * "aa"  出现 1 次。
 * "b"   出现 2 次。
 * "bb"  出现 1 次。
 * "c"   出现 3 次。
 * "cc"  出现 2 次。
 * "ccc" 出现 1 次。
 * 3 + 1 + 2 + 1 + 3 + 2 + 1 = 13
 * 示例 2：
 *
 * 输入：s = "xy"
 * 输出：2
 * 解释：同质子字符串是 "x" 和 "y" 。
 * 示例 3：
 *
 * 输入：s = "zzzzz"
 * 输出：15
 * @Version 1.0
 */
public class countnumberofhomogenoussubstrings {
    public int countHomogenous(String s) {
        int n = s.length(), k = 1;
        long res = 1;
        char[] ch = s.toCharArray();
        for (int i = 1; i < n; i++) {
            if (ch[i] == ch[i - 1]) k++;
            else k = 1;
            res += k;
        }
        return (int) (res % 1000000007);
    }
}