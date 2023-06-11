package com.yzy.mid;

/**
 * Description: leetcode208
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *
 *
 * 示例：
 *
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 *
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 * @author yzy15
 * @date 2023/06/10 23:30
 **/
class Trie {

    private class TrieNode { // 每个节点最多有26个不同的小写字母
        private boolean isEnd;
        private TrieNode[] next;

        public TrieNode() {
            isEnd = false;
            next = new TrieNode[26];
        }

    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0, len = word.length(), ch; i < len; i++) {
            ch = word.charAt(i) - 'a';
            if (cur.next[ch] == null)
                cur.next[ch] = new TrieNode();
            cur = cur.next[ch];
        }
        cur.isEnd = true; // 加上一个标记，表示为一个单词
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0, len = word.length(), ch; i < len; i++) {
            ch = word.charAt(i) - 'a';
            if (cur.next[ch] == null)
                return false;
            cur = cur.next[ch];
        }
        return cur.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0, len = prefix.length(), ch; i < len; i++) {
            ch = prefix.charAt(i) - 'a';
            if (cur.next[ch] == null)
                return false; // 若还没遍历完给定的前缀子串，则直接返回false
            cur = cur.next[ch];
        }
        return true; // 直接返回true
    }
}
