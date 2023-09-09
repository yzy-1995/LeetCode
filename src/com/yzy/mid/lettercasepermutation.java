package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/09 21:33
 * @Description
 * 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
 *
 * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * 示例 2:
 *
 * 输入: s = "3z4"
 * 输出: ["3z4","3Z4"]
 * @Version 1.0
 */
public class lettercasepermutation {
    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        char[] cs = s.toCharArray();
        dfs(cs, 0);
        return res;
    }
    /**
     * @param cs 搜索的字符数组
     * @param idx 开始搜索的位置
     */
    void dfs(char[] cs, int idx) {
        res.add(String.valueOf(cs));
        for (int i = idx; i < cs.length; i++) {
            // 数字, 则跳过
            if (isDigit(cs[i])) continue;
            // 大小写反转
            cs[i] = changeLetter(cs[i]);
            // 搜索
            dfs(cs, i + 1);
            // 回溯, 大小写反转回来
            cs[i] = changeLetter(cs[i]);
        }
    }

    /**
     * 反转大小写
     * 'A' --> 'a'
     * 'a' --> 'A'
     */
    public char changeLetter(char c) {
        return (c >= 'a' && c <= 'z') ? (char) (c - 32) : (char) (c + 32);
    }

    /**
     * 判断是否是数字 (此题中的字符, 非字母即数字)
     */
    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}