package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/01 10:50
 * @Description
 * 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
 *
 * 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcabc"
 * 输出：10
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" 和 "abc" (相同字符串算多次)。
 * 示例 2：
 *
 * 输入：s = "aaacb"
 * 输出：3
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "aaacb", "aacb" 和 "acb" 。
 * 示例 3：
 *
 * 输入：s = "abc"
 * 输出：1
 * @Version 1.0
 */
public class numberofsubstringscontainingallthreecharacters {
    public int numberOfSubstrings(String s) {
        int res = 0;
        // 记录 'a', 'b', 'c' 上次出现的位置
        int[] record = {-1, -1, -1};
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                res += Math.min(record[1], record[2]) + 1;
            } else if (s.charAt(i) == 'b') {
                res += Math.min(record[0], record[2]) + 1;
            } else {
                res += Math.min(record[0], record[1]) + 1;
            }
            // 更新 'a', 'b', 'c' 最近出现的位置
            record[s.charAt(i) - 'a'] = i;
        }
        return res;
    }
}