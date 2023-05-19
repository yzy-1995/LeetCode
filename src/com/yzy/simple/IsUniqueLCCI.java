package com.yzy.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: IsUniqueLCCI
 * Description:
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * 示例 1：
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 *
 * 输入: s = "abc"
 * 输出: true
 * @author Administrator
 * @date 2023-5-19 16:14
 */
public class IsUniqueLCCI {
    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet<Character>();
        for (char c :astr.toCharArray()) {
            if (set.contains(c)){
                return false;
            }
            set.add(c);
        }
        return true;
    }
}
