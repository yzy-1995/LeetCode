package com.yzy.simple;

import java.util.*;

/**
 * ClassName: CountVowelSubstringsofaString
 * Description:
 * 子字符串 是字符串中的一个连续（非空）的字符序列。
 * 元音子字符串 是 仅 由元音（'a'、'e'、'i'、'o' 和 'u'）组成的一个子字符串，且必须包含 全部五种 元音。
 * 给你一个字符串 word ，统计并返回 word 中 元音子字符串的数目 。
 * 示例 1：
 * 输入：word = "aeiouu"
 * 输出：2
 * 解释：下面列出 word 中的元音子字符串（斜体加粗部分）：
 * - "aeiouu"
 * - "aeiouu"
 * 示例 2：
 * 输入：word = "unicornarihan"
 * 输出：0
 * 解释：word 中不含 5 种元音，所以也不会存在元音子字符串。
 * 示例 3：
 * 输入：word = "cuaieuouac"
 * 输出：7
 * 解释：下面列出 word 中的元音子字符串（斜体加粗部分）：
 * - "cuaieuouac"
 * - "cuaieuouac"
 * - "cuaieuouac"
 * - "cuaieuouac"
 * - "cuaieuouac"
 * - "cuaieuouac"
 * - "cuaieuouac"
 * 示例 4：
 * 输入：word = "bbaeixoubb"
 * 输出：0
 * 解释：所有包含全部五种元音的子字符串都含有辅音，所以不存在元音子字符串。
 *
 * @author Administrator
 * @date 2023-5-5 11:24
 */
public class CountVowelSubstringsofaString {
    public static void main(String[] args) {
        System.out.println(countVowelSubstrings("cuaieuouac"));
    }

    public static int countVowelSubstrings(String word) {
        String s = "aeiou";
        int len = word.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < len; j++) {
                if (s.indexOf(word.charAt(j)) < 0) {
                    break;
                }
                set.add(word.charAt(j));
                if (set.size() == 5) {
                    count++;
                }
            }
        }
        return count;
    }
}
