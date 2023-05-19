package com.yzy.simple;

/**
 * ClassName: OfferII034
 * Description:
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * <p>
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 * 示例 2：
 * <p>
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 * 示例 3：
 * <p>
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 *
 * @author Administrator
 * @date 2023-5-19 15:11
 */
public class OfferII034 {
    public boolean isAlienSorted(String[] words, String order) {
        // 按字符串给出的顺序建立字母顺序表，再遍历按表比较
        if (words.length < 2) {
            return true;
        }
        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i) {    // 字母正确顺序表
            index[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; ++i) {  // 遍历words比较字典序
            int len = Math.min(words[i - 1].length(), words[i].length());
            for (int j = 0; j < len; ++j) {
                int pre = index[words[i - 1].charAt(j) - 'a'];
                int curr = index[words[i].charAt(j) - 'a'];
                if (pre > curr) {
                    return false;
                } else if (pre < curr) {
                    break;
                }
                // 后者i较短（长为len），且i-1前len部分与i相同时，判定i字典序较小
                if (j == len - 1 && words[i - 1].length() > len) {
                    return false;
                }
            }

        }
        return true;
    }
}
