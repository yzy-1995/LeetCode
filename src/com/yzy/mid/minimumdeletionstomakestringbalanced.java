package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/13 20:34
 * @Description
 * 给你一个字符串 s ，它仅包含字符 'a' 和 'b'​​​​ 。
 *
 * 你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' ，此时认为 s 是 平衡 的。
 *
 * 请你返回使 s 平衡 的 最少 删除次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aababbab"
 * 输出：2
 * 解释：你可以选择以下任意一种方案：
 * 下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
 * 下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
 * 示例 2：
 *
 * 输入：s = "bbaaaaabb"
 * 输出：2
 * 解释：唯一的最优解是删除最前面两个字符。
 * @Version 1.0
 */
public class minimumdeletionstomakestringbalanced {
    public int minimumDeletions(String s) {
        int countB = 0;
        // res存储的是当前索引下，需要操作最少次数，
        int res = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            // 如果是a，要么删掉夹在b中间的a，要么删掉前面所有b
            // res存储的是遍历到的所有的b，或者夹在中间的a
            if (c == 'a') {
                res = Math.min(res + 1, countB);
            } else {
                countB++;
            }
        }
        return res;
    }
}