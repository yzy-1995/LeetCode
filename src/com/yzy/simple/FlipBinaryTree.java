package com.yzy.simple;

/**
 * ClassName: FlipBinaryTree
 * Description:
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * @author Administrator
 * @date 2023-3-28 8:51
 */
public class FlipBinaryTree {

    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null) return null;
        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);
        root.left=left;
        root.right=right;
        return root;
    }

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
}
