package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/20 08:17
 * @Description
 * 给定两个整数 a 和 b ，返回 任意 字符串 s ，要求满足：
 *
 * s 的长度为 a + b，且正好包含 a 个 'a' 字母与 b 个 'b' 字母；
 * 子串 'aaa' 没有出现在 s 中；
 * 子串 'bbb' 没有出现在 s 中。
 *
 *
 * 示例 1：
 *
 * 输入：a = 1, b = 2
 * 输出："abb"
 * 解释："abb", "bab" 和 "bba" 都是正确答案。
 * 示例 2：
 *
 * 输入：a = 4, b = 1
 * 输出："aabaa"
 * @Version 1.0
 */
public class stringwithoutaaaorbbb {
    public String strWithout3a3b(int a, int b) {
        char max = a > b ? 'a' : 'b';
        char min = max == 'a' ? 'b' : 'a';
        int diff = a - b > 0 ? a - b : (b - a);
        StringBuilder result = new StringBuilder();
        for (int i =0; i < Math.min(a,b); i++){
            if (diff > 0) result.append(max);
            result.append(max);
            result.append(min);
            diff--;
        }
        for (int i = 0; i < diff; i++){
            result.append(max);
        }
        return result.toString();
    }
}