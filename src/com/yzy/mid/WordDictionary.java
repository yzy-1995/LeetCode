package com.yzy.mid;

import java.util.Arrays;

/**
 * Description: leetcode211
 *
 * @author yzy15
 * @date 2023/06/11 20:30
 **/
public class WordDictionary {
    static int N = 250000;
    static int[][] tr = new int[N][26];
    static boolean[] isWord = new boolean[N];
    static int idx;
    public WordDictionary() {
        for (int i = 0; i < idx; i++) {
            Arrays.fill(tr[i], 0);
        }
        Arrays.fill(isWord, false);
        idx = 0;
    }
    public void addWord(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (tr[p][u] == 0) tr[p][u] = ++idx;
            p = tr[p][u];
        }
        isWord[p] = true;
    }
    public boolean search(String s) {
        return dfs(s, 0, 0);
    }
    boolean dfs(String s, int trIdx, int sIdx) {
        int n = s.length();
        if (n == sIdx) return isWord[trIdx];
        char c = s.charAt(sIdx);
        if (c == '.') {
            for (int j = 0; j < 26; j++) {
                if (tr[trIdx][j] != 0 && dfs(s, tr[trIdx][j], sIdx + 1)) return true;
            }
            return false;
        } else {
            int u = c - 'a';
            if (tr[trIdx][u] == 0) return false;
            return dfs(s, tr[trIdx][u], sIdx + 1);
        }
    }
}
