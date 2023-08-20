package com.yzy.mid;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/19 00:19
 * @Description
 * .在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 *
 * 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 *
 * 你需要输出替换之后的句子。
 *
 *
 *
 * 示例 1：
 *
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 * 示例 2：
 *
 * 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * 输出："a a b c"
 * @Version 1.0
 */
public class replacewords {
    public String replaceWords(List<String> dictionary, String sentence) {
        return Arrays
                .stream(sentence.split(" "))
                .map(word -> dictionary
                        .stream()
                        .filter(word::startsWith)
                        .min(Comparator.comparingInt(String::length))
                        .orElse(word))
                .reduce((s1,s2)->s1+" "+s2)
                .get()
                .trim();
    }
}