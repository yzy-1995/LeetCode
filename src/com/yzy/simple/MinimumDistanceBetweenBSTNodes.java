package com.yzy.simple;

import java.util.Stack;

/**
 * ClassName: MinimumDistanceBetweenBSTNodes
 * Description:leetcode783
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * 示例 1：
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 示例 2：
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 *
 * @author Administrator
 * @date 2023-4-20 11:03
 */
public class MinimumDistanceBetweenBSTNodes {
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

    public static void main(String[] args) {

    }

    public int minDiffInBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode prev = null;
        int minDiff = Integer.MAX_VALUE;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (prev != null) {
                minDiff = Math.min(minDiff, node.val - prev.val);
            }
            prev = node;
            node = node.right;
        }
        return minDiff;
    }
}
