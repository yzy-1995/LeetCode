package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/17 00:01
 * @Description
 * 请你设计一个迭代器类 CombinationIterator ，包括以下内容：
 *
 * CombinationIterator(string characters, int combinationLength) 一个构造函数，输入参数包括：用一个 有序且字符唯一 的字符串 characters（该字符串只包含小写英文字母）和一个数字 combinationLength 。
 * 函数 next() ，按 字典序 返回长度为 combinationLength 的下一个字母组合。
 * 函数 hasNext() ，只有存在长度为 combinationLength 的下一个字母组合时，才返回 true
 *
 *
 * 示例 1：
 *
 * 输入:
 * ["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
 * [["abc", 2], [], [], [], [], [], []]
 * 输出：
 * [null, "ab", true, "ac", true, "bc", false]
 * 解释：
 * CombinationIterator iterator = new CombinationIterator("abc", 2); // 创建迭代器 iterator
 * iterator.next(); // 返回 "ab"
 * iterator.hasNext(); // 返回 true
 * iterator.next(); // 返回 "ac"
 * iterator.hasNext(); // 返回 true
 * iterator.next(); // 返回 "bc"
 * iterator.hasNext(); // 返回 false
 * @Version 1.0
 */
class CombinationIterator {
    private String characters;
    private List<String> list;
    private int combinationLength;
    private int cur = 0;

    private void backtrack(StringBuilder str, int startIndex) {
        if (str.length() == this.combinationLength) {
            list.add(str.toString());
            return;
        }

        for (int i = startIndex; i < this.characters.length(); i++) {
            str.append(this.characters.charAt(i));
            backtrack(str, ++i);
            str.deleteCharAt(str.length() - 1);
            i --;
        }
    }

    public CombinationIterator(String characters, int combinationLength) {
        this.characters = characters;
        this.combinationLength = combinationLength;
        this.list = new ArrayList<>();
        this.backtrack(new StringBuilder(), 0);
    }

    public String next() {
        String res = list.get(this.cur);
        this.cur ++;
        return res;
    }

    public boolean hasNext() {
        return this.cur < this.list.size();
    }
}