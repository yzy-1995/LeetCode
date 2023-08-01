package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/02 00:08
 * @Description
 * 给定字符串列表 strs ，返回其中 最长的特殊序列 的长度。如果最长特殊序列不存在，返回 -1 。
 *
 * 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
 *
 *  s 的 子序列可以通过删去字符串 s 中的某些字符实现。
 *
 * 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括"aebdc"、 "aeb" 和 "" (空字符串)。
 *
 *
 * 示例 1：
 *
 * 输入: strs = ["aba","cdc","eae"]
 * 输出: 3
 * 示例 2:
 *
 * 输入: strs = ["aaa","aaa","aa"]
 * 输出: -1
 * @Version 1.0
 */
public class LongestUncommonSubsequenceII {
    public int findLUSlength(String[] strs) {
        int N = strs.length;
        int ans = -1;
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j && isSubStr(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) ans = Math.max(ans, strs[i].length());
            flag = true;
        }
        return ans;
    }

    private boolean isSubStr(String str1, String str2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < str1.length() && index2 < str2.length()) {
            if (str1.charAt(index1) == str2.charAt(index2)) index1++;
            index2++;
        }
        return index1 == str1.length();
    }
}