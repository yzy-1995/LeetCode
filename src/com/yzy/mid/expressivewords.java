package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/16 09:06
 * @Description
 * 有时候人们会用重复写一些字母来表示额外的感受，比如 "hello" -> "heeellooo", "hi" -> "hiii"。我们将相邻字母都相同的一串字符定义为相同字母组，例如："h", "eee", "ll", "ooo"。
 *
 * 对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。扩张操作定义如下：选择一个字母组（包含字母 c ），然后往其中添加相同的字母 c 使其长度达到 3 或以上。
 *
 * 例如，以 "hello" 为例，我们可以对字母组 "o" 扩张得到 "hellooo"，但是无法以同样的方法得到 "helloo" 因为字母组 "oo" 长度小于 3。此外，我们可以进行另一种扩张 "ll" -> "lllll" 以获得 "helllllooo"。如果 s = "helllllooo"，那么查询词 "hello" 是可扩张的，因为可以对它执行这两种扩张操作使得 query = "hello" -> "hellooo" -> "helllllooo" = s。
 *
 * 输入一组查询单词，输出其中可扩张的单词数量。
 *
 *
 *
 * 示例：
 *
 * 输入：
 * s = "heeellooo"
 * words = ["hello", "hi", "helo"]
 * 输出：1
 * 解释：
 * 我们能通过扩张 "hello" 的 "e" 和 "o" 来得到 "heeellooo"。
 * 我们不能通过扩张 "helo" 来得到 "heeellooo" 因为 "ll" 的长度小于 3 。
 * @Version 1.0
 */
public class expressivewords {
    public int expressiveWords(String s, String[] words) {
        int res = 0;
        for (String w : words) {
            // 提前去除掉头尾不相同的 word
            if ((s.charAt(0) != w.charAt(0)) || (s.charAt(s.length() - 1) != w.charAt(w.length() - 1))) continue;
            if (func(s, w)) res++;
        }
        return res;
    }

    private boolean func(String s, String w) {
        int wlen = 0, slen = 0, i = 0, j = 0;
        for (; i < w.length() && j < s.length(); i++, j++) {
            // wlen 即 w 中连续相同字符个数，slen同理
            wlen = 1;
            slen = 1;
            // while循环找到 w 最后一个连续相同字符，同时记录个数
            while (i < w.length() - 1 && w.charAt(i + 1) == w.charAt(i)) {
                i++;
                wlen++;
            }

            // 如果相同再继续，同上找到 s 最后一个连续相同字符，同时记录个数
            if (s.charAt(j) == w.charAt(i)) {
                while (j < s.length() - 1 && s.charAt(j + 1) == s.charAt(j)) {
                    j++;
                    slen++;
                }
            } else return false;

            // 此处判断两小段连续字符长度，对长度小于3的做出处理
            if ((slen != wlen && slen < 3) || slen < wlen) return false;
        }
        // 判断两个指针是否遍历完
        return i == w.length() && j == s.length();
    }
}