package com.yzy.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: leetcode653
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果二叉搜索树中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * 示例 1：
 * 输入: root = [5,3,6,2,4,null,7], k = 9
 * 输出: true
 * 示例 2：
 * 输入: root = [5,3,6,2,4,null,7], k = 28
 * 输出: false
 *
 * @author yzy15
 * @date 2023/04/16 09:05
 **/
public class TwoSumIVInputsaBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }

    private boolean dfs(TreeNode node, int k, Set<Integer> set) {
        if (node == null) {
            return false;
        }

        if (set.contains(k - node.val)) {
            return true;
        }
        set.add(node.val);

        return dfs(node.left, k, set) || dfs(node.right, k, set);
    }
}
