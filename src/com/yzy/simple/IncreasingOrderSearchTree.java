package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: leetcode897
 * 给你一棵二叉搜索树的 root ，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * 示例 1：
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * 示例 2：
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 *
 * @author yzy15
 * @date 2023/04/22 12:35
 **/
public class IncreasingOrderSearchTree {
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
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorderTraversal(root, values);

        TreeNode newRoot = new TreeNode(0);
        TreeNode current = newRoot;
        for (int value : values) {
            current.right = new TreeNode(value);
            current = current.right;
        }
        return newRoot.right;
    }

    private static void inorderTraversal(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, values);
        values.add(node.val);
        inorderTraversal(node.right, values);
    }

}
