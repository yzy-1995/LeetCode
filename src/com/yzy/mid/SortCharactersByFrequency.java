package com.yzy.mid;

import java.util.PriorityQueue;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/21 00:22
 * @Description
 * 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
 *
 * 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "tree"
 * 输出: "eert"
 * 解释: 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 *
 * 输入: s = "cccaaa"
 * 输出: "cccaaa"
 * 解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 *
 * 输入: s = "Aabb"
 * 输出: "bbAa"
 * 解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * @Version 1.0
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        int[] cnt = new int[128];
        char[] cs = s.toCharArray();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> cnt[b] - cnt[a]);
        for (char c : cs) cnt[c]++;
        for (int i = 0 ; i < 128 ; i++) {
            if (cnt[i] > 0) pq.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            int c = pq.poll();
            for (int i = 0 ; i < cnt[c] ; i++) sb.append((char)c);
        }
        return sb.toString();
    }
}