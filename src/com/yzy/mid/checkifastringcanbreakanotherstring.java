package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/14 00:08
 * @Description
 * 给你两个字符串 s1 和 s2 ，它们长度相等，请你检查是否存在一个 s1  的排列可以打破 s2 的一个排列，或者是否存在一个 s2 的排列可以打破 s1 的一个排列。
 *
 * 字符串 x 可以打破字符串 y （两者长度都为 n ）需满足对于所有 i（在 0 到 n - 1 之间）都有 x[i] >= y[i]（字典序意义下的顺序）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s1 = "abc", s2 = "xya"
 * 输出：true
 * 解释："ayx" 是 s2="xya" 的一个排列，"abc" 是字符串 s1="abc" 的一个排列，且 "ayx" 可以打破 "abc" 。
 * 示例 2：
 *
 * 输入：s1 = "abe", s2 = "acd"
 * 输出：false
 * 解释：s1="abe" 的所有排列包括："abe"，"aeb"，"bae"，"bea"，"eab" 和 "eba" ，s2="acd" 的所有排列包括："acd"，"adc"，"cad"，"cda"，"dac" 和 "dca"。然而没有任何 s1 的排列可以打破 s2 的排列。也没有 s2 的排列能打破 s1 的排列。
 * 示例 3：
 *
 * 输入：s1 = "leetcodee", s2 = "interview"
 * 输出：true
 * @Version 1.0
 */
public class checkifastringcanbreakanotherstring {
    public boolean checkIfCanBreak(String s1, String s2) {
        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            ++count[c - 'a'];
        }
        for (char c : s2.toCharArray()) {
            --count[c - 'a'];
        }
        int sum = 0;
        int mark = 0;
        for (int i = 25; i >= 0; --i) {
            sum += count[i];
            if (mark == 0 && sum != 0) {
                mark = sum > 0 ? 1 : -1;
            }
            if (mark * sum < 0) {
                return false;
            }
        }
        return true;
    }
}