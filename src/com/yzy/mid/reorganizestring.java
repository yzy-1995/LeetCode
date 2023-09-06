package com.yzy.mid;

import java.util.PriorityQueue;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/07 00:05
 * @Description
 * 给定一个字符串 s ，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 返回 s 的任意可能的重新排列。若不可行，返回空字符串 "" 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: s = "aaab"
 * 输出: ""
 * @Version 1.0
 */
public class reorganizestring {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            cnt[c-'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o2[1]-o1[1]));
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) pq.add(new int[] {i,cnt[i]});
        }
        assert !pq.isEmpty();
        if (pq.peek()[1] > n/2 + 1) return "";
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 1) {
            int[] a = pq.poll(), b = pq.poll();
            assert b != null;
            sb.append((char) ('a'+a[0]));
            sb.append((char) ('a'+b[0]));
            if (--a[1] > 0) pq.add(a);
            if (--b[1] > 0) pq.add(b);
        }
        if (pq.isEmpty()) return sb.toString();
        if (pq.peek()[1] > 1) return "";
        return sb.append((char) ('a'+pq.peek()[0])).toString();
    }
}