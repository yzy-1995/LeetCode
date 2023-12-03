package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/01 10:45
 * @Description
 * @Version 1.0
 */
public class determineiftwostringsareclose {
    public boolean closeStrings(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        if (n1 != n2) return false;
        int[] cnt1 = new int[26], cnt2 = new int[26];
        for (int i = 0; i < n1; i++) {
            cnt1[word1.charAt(i) - 'a']++;
            cnt2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] == 0 && cnt2[i] != 0 || cnt1[i] != 0 && cnt2[i] == 0) return false;
        }
        Arrays.sort(cnt1);
        Arrays.sort(cnt2);
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) return false;
        }
        return true;
    }
}