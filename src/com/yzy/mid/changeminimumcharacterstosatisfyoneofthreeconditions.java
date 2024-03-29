package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/26 21:37
 * @Description 给你两个字符串 a 和 b ，二者均由小写字母组成。一步操作中，你可以将 a 或 b 中的 任一字符 改变为 任一小写字母 。
 * <p>
 * 操作的最终目标是满足下列三个条件 之一 ：
 * <p>
 * a 中的 每个字母 在字母表中 严格小于 b 中的 每个字母 。
 * b 中的 每个字母 在字母表中 严格小于 a 中的 每个字母 。
 * a 和 b 都 由 同一个 字母组成。
 * 返回达成目标所需的 最少 操作数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = "aba", b = "caa"
 * 输出：2
 * 解释：满足每个条件的最佳方案分别是：
 * 1) 将 b 变为 "ccc"，2 次操作，满足 a 中的每个字母都小于 b 中的每个字母；
 * 2) 将 a 变为 "bbb" 并将 b 变为 "aaa"，3 次操作，满足 b 中的每个字母都小于 a 中的每个字母；
 * 3) 将 a 变为 "aaa" 并将 b 变为 "aaa"，2 次操作，满足 a 和 b 由同一个字母组成。
 * 最佳的方案只需要 2 次操作（满足条件 1 或者条件 3）。
 * 示例 2：
 * <p>
 * 输入：a = "dabadd", b = "cda"
 * 输出：3
 * 解释：满足条件 1 的最佳方案是将 b 变为 "eee" 。
 * @Version 1.0
 */
public class changeminimumcharacterstosatisfyoneofthreeconditions {
    public int minCharacters(String a, String b) {
        // 满足条件情况有三种：1、全部转换为同一个字符 2、a > b 3、a < b
        int n = a.length(), m = b.length();
        int[] chara = new int[26];
        int[] charb = new int[26];
        for (char item : a.toCharArray()) {
            chara[item - 'a']++;
        }
        for (char item : b.toCharArray()) {
            charb[item - 'a']++;
        }
        int res = n + m;
        // 1、换成同一个字符
        for (int i = 0; i < 26; i++) {
            res = Math.min(res, n + m - chara[i] - charb[i]);
        }
        for (int i = 1; i < 26; i++) {
            chara[i] += chara[i - 1];
            charb[i] += charb[i - 1];
        }
        // 枚举临界值
        for (int i = 0; i < 25; i++) {
            // 2、a中字符全部大于i b中字符全部小于等于i
            res = Math.min(res, chara[i] + m - charb[i]);
            // 3、a中字符全部小于等于i b中字符全部大于i
            res = Math.min(res, n - chara[i] + charb[i]);
            if (res == 1) System.out.println(i);
        }
        return res;
    }
}