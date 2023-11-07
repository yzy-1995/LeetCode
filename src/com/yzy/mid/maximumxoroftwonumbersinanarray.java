package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/04 21:48
 * @Description
 * @Version 1.0
 */
public class maximumxoroftwonumbersinanarray {
    public int findMaximumXOR(int[] nums) {
        Trie t = new Trie();
        t.insert(nums[0]);
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum, t.query(nums[i]));
            t.insert(nums[i]);
        }
        return sum;
    }

    class Trie {
        private Trie[] children;

        public Trie() {
            children = new Trie[2];
        }

        public void insert(int word) {
            Trie node = this;
            for (int i = 30; i >= 0; i--) {
                int index = (word >> i) & 1;
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
        }

        public int query(int k) {
            Trie node = this;
            int sum = 0;
            for (int i = 30; i >= 0; i--) {
                int x = (k >> i) & 1;
                sum <<= 1;
                if (node.children[x ^ 1] == null) {
                    node = node.children[x];
                } else {
                    node = node.children[x ^ 1];
                    sum |= 1;
                }

            }
            return sum;
        }
    }
}