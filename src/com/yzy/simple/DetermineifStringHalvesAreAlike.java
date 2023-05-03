package com.yzy.simple;

/**
 * Description: leetcode1704
 * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
 * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。
 * 如果 a 和 b 相似，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：s = "book"
 * 输出：true
 * 解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
 * 示例 2：
 * 输入：s = "textbook"
 * 输出：false
 * 解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
 * 注意，元音 o 在 b 中出现两次，记为 2 个。
 * @author yzy15
 * @date 2023/05/01 20:33
 **/
public class DetermineifStringHalvesAreAlike {
    public static void main(String[] args) {

    }

    public boolean halvesAreAlike(String s) {
        int length = s.length();
        String a = s.substring(0,length/2);
        String b = s.substring(length/2);

        int aVowels = countVowel(a);
        int bVowels = countVowel(b);

        return aVowels==bVowels;
    }
    private int countVowel(String str){
        int count = 0 ;
        String vowels = "aeiouAEIOU";
        for (char c :str.toCharArray()) {
            if (vowels.indexOf(c) != -1){
                count++;
            }
        }
    return count;
    }
}
