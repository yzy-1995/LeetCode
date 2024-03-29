package com.yzy.mid;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/09 00:13
 * @Description
 * 给你一个下标从 0 开始的字符串 s 和一个单词字典 dictionary 。你需要将 s 分割成若干个 互不重叠 的子字符串，每个子字符串都在 dictionary 中出现过。s 中可能会有一些 额外的字符 不在任何子字符串中。
 *
 * 请你采取最优策略分割 s ，使剩下的字符 最少 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "leetscode", dictionary = ["leet","code","leetcode"]
 * 输出：1
 * 解释：将 s 分成两个子字符串：下标从 0 到 3 的 "leet" 和下标从 5 到 8 的 "code" 。只有 1 个字符没有使用（下标为 4），所以我们返回 1 。
 * 示例 2：
 *
 * 输入：s = "sayhelloworld", dictionary = ["hello","world"]
 * 输出：3
 * 解释：将 s 分成两个子字符串：下标从 3 到 7 的 "hello" 和下标从 8 到 12 的 "world" 。下标为 0 ，1 和 2 的字符没有使用，所以我们返回 3 。
 * @Version 1.0
 */
public class extracharactersinastring {
    public int minExtraChar(String s, String[] words) {

        Set<String> set = Arrays.stream(words).collect(Collectors.toSet());

        int[] dp = new int[s.length() + 1];
        for (int end = 1; end <= s.length(); end++) {
            dp[end] = dp[end - 1] + 1;
            for (int begin = 0; begin < end; begin++) {
                if (set.contains(s.substring(begin, end))) {
                    dp[end] = Math.min(dp[end], dp[begin]);
                }
            }
        }
        return dp[s.length()];

    }
}