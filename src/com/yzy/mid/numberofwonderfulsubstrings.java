package com.yzy.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/02/20 23:44
 * @Description 如果某个字符串中 至多一个 字母出现 奇数 次，则称其为 最美 字符串。
 * <p>
 * 例如，"ccjjc" 和 "abab" 都是最美字符串，但 "ab" 不是。
 * 给你一个字符串 word ，该字符串由前十个小写英文字母组成（'a' 到 'j'）。请你返回 word 中 最美非空子字符串 的数目。如果同样的子字符串在 word 中出现多次，那么应当对 每次出现 分别计数。
 * <p>
 * 子字符串 是字符串中的一个连续字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "aba"
 * 输出：4
 * 解释：4 个最美子字符串如下所示：
 * - "aba" -> "a"
 * - "aba" -> "b"
 * - "aba" -> "a"
 * - "aba" -> "aba"
 * 示例 2：
 * <p>
 * 输入：word = "aabb"
 * 输出：9
 * 解释：9 个最美子字符串如下所示：
 * - "aabb" -> "a"
 * - "aabb" -> "aa"
 * - "aabb" -> "aab"
 * - "aabb" -> "aabb"
 * - "aabb" -> "a"
 * - "aabb" -> "abb"
 * - "aabb" -> "b"
 * - "aabb" -> "bb"
 * - "aabb" -> "b"
 * 示例 3：
 * <p>
 * 输入：word = "he"
 * 输出：2
 * 解释：2 个最美子字符串如下所示：
 * - "he" -> "h"
 * - "he" -> "e"
 * @Version 1.0
 */
public class numberofwonderfulsubstrings {
    public long wonderfulSubstrings(String word) {
        Map<Integer, Integer> fre = new HashMap<>();
        int status = 0, n = word.length(); // (0000000000) 对应于'a' -> 'j'还可以更多的 最多31位
        long ans = 0;
        fre.put(0, 1);
        for (int i = 0; i < n; i++) {
            status ^= 1 << (word.charAt(i) - 'a'); //状态改变了（或者说是奇偶性变化）
            // 这一步应该是判断奇数次的(但我看不懂，有大佬解释一下吗)
            for (int j = 0; j < 10; j++) {
                ans += fre.getOrDefault(status ^ (1 << j), 0);
            }
            // 当前的状态以前出现过，就代表存在中间一段状态是(pre 0000 cur)即偶数次
            ans += fre.getOrDefault(status, 0);
            fre.put(status, fre.getOrDefault(status, 0) + 1);
        }
        return ans;

    }
}