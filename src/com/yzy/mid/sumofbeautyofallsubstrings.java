package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/02/02 19:52
 * @Description
 * 一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
 *
 * 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
 * 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aabcb"
 * 输出：5
 * 解释：美丽值不为零的字符串包括 ["aab","aabc","aabcb","abcb","bcb"] ，每一个字符串的美丽值都为 1 。
 * 示例 2：
 *
 * 输入：s = "aabcbaa"
 * 输出：17
 * @Version 1.0
 */
public class sumofbeautyofallsubstrings {
    public int beautySum(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int[] h = new int[26];
            for (int j = i; j < n; j++) {
                h[s.charAt(j) - 'a']++;
                int max = 0, min = n;
                for (int k = 0; k < 26; k++) {
                    if (h[k] != 0) {
                        max = Math.max(max, h[k]);
                        min = Math.min(min, h[k]);
                    }
                }
                res += max - min;
            }
        }
        return res;
    }
}