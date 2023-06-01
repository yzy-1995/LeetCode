package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: PalindromePartitioning
 * Description:
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 * @author Administrator
 * @date 2023-5-31 14:04
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                dp[i][j] = (i == j) || ((dp[i + 1][j - 1] || j - i == 1) && s.charAt(i) == s.charAt(j));
            }
        }

        List<String> item = new ArrayList<>();
        dfs(0, s, dp, item, res);
        return res;
    }

    private void dfs(int index, String s, boolean[][] dp, List<String> item, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(item));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (dp[index][i]) {
                item.add(s.substring(index, i + 1));
                dfs(i + 1, s, dp, item, res);
                item.remove(item.size() - 1);
            }
        }
    }
}
