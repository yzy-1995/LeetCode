package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/12 23:16
 * @Description
 * 给你两个字符串 s 和 t ，请你找出 s 中的非空子串的数目，这些子串满足替换 一个不同字符 以后，是 t 串的子串。换言之，请你找到 s 和 t 串中 恰好 只有一个字符不同的子字符串对的数目。
 *
 * 比方说， "computer" and "computation" 只有一个字符不同： 'e'/'a' ，所以这一对子字符串会给答案加 1 。
 *
 * 请你返回满足上述条件的不同子字符串对数目。
 *
 * 一个 子字符串 是一个字符串中连续的字符。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aba", t = "baba"
 * 输出：6
 * 解释：以下为只相差 1 个字符的 s 和 t 串的子字符串对：
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * 加粗部分分别表示 s 和 t 串选出来的子字符串。
 * 示例 2：
 * 输入：s = "ab", t = "bb"
 * 输出：3
 * 解释：以下为只相差 1 个字符的 s 和 t 串的子字符串对：
 * ("ab", "bb")
 * ("ab", "bb")
 * ("ab", "bb")
 * 加粗部分分别表示 s 和 t 串选出来的子字符串。
 * 示例 3：
 * 输入：s = "a", t = "a"
 * 输出：0
 * 示例 4：
 *
 * 输入：s = "abe", t = "bbc"
 * 输出：10
 * @Version 1.0
 */
public class countsubstringsthatdifferbyonecharacter {
    public int countSubstrings(String s, String t) {
        int m = 0, slen = s.length() , tlen = t.length();
        for(int i=0; i<slen; i++){
            for(int j=0; j<tlen; j++){
                if(s.charAt(i) == t.charAt(j)) continue;
                int a = 1, b = 1;
                while((i-a >= 0 && j-a >= 0) && s.charAt(i-a) == t.charAt(j-a)) a++;
                while((i+b < slen && j+b < tlen) && s.charAt(i+b) == t.charAt(j+b)) b++;
                m += a*b;
            }
        }
        return m;
    }
}