package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/16 23:20
 * @Description 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,10,5,25,2,8]
 * 输出：28
 * 解释：最大运算结果是 5 XOR 25 = 28.
 * 示例 2：
 * <p>
 * 输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * 输出：127
 * @Version 1.0
 */
public class MaximumxorOFRwoNumbersInAnArray {
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