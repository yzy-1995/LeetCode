package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/02/05 20:07
 * @Description
 * 一个句子是由一些单词与它们之间的单个空格组成，且句子的开头和结尾没有多余空格。比方说，"Hello World" ，"HELLO" ，"hello world hello world" 都是句子。每个单词都 只 包含大写和小写英文字母。
 *
 * 如果两个句子 sentence1 和 sentence2 ，可以通过往其中一个句子插入一个任意的句子（可以是空句子）而得到另一个句子，那么我们称这两个句子是 相似的 。比方说，sentence1 = "Hello my name is Jane" 且 sentence2 = "Hello Jane" ，我们可以往 sentence2 中 "Hello" 和 "Jane" 之间插入 "my name is" 得到 sentence1 。
 *
 * 给你两个句子 sentence1 和 sentence2 ，如果 sentence1 和 sentence2 是相似的，请你返回 true ，否则返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：sentence1 = "My name is Haley", sentence2 = "My Haley"
 * 输出：true
 * 解释：可以往 sentence2 中 "My" 和 "Haley" 之间插入 "name is" ，得到 sentence1 。
 * 示例 2：
 *
 * 输入：sentence1 = "of", sentence2 = "A lot of words"
 * 输出：false
 * 解释：没法往这两个句子中的一个句子只插入一个句子就得到另一个句子。
 * 示例 3：
 *
 * 输入：sentence1 = "Eating right now", sentence2 = "Eating"
 * 输出：true
 * 解释：可以往 sentence2 的结尾插入 "right now" 得到 sentence1 。
 * 示例 4：
 *
 * 输入：sentence1 = "Luky", sentence2 = "Lucccky"
 * 输出：false
 * @Version 1.0
 */
public class sentencesimilarityiii {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] strs1 = sentence1.split(" "), strs2 = sentence2.split(" ");
        int n1 = strs1.length, n2 = strs2.length;
        if(n1 < n2) {
            return areSentencesSimilar(sentence2, sentence1);
        }
        int l1 = 0, r1 = n1 - 1, l2 = 0, r2 = n2 - 1;
        while(l1 < n1 && l2 < n2 && strs1[l1].equals(strs2[l2])) {
            l1++;
            l2++;
        }
        while(r1 >= 0 && r2 >= 0 && strs1[r1].equals(strs2[r2])) {
            r1--;
            r2--;
        }
        return l2 > r2;
    }
}