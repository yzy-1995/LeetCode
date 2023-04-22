package com.yzy.simple;

/**
 * Description: leetcode965
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 * 示例 1：
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 * 示例 2：
 * 输入：[2,2,2,5,2]
 * 输出：false
 * @author yzy15
 * @date 2023/04/22 23:17
 **/
public class UnivaluedBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {

    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.left.val != root.val) {
            return false;
        }

        if (root.right != null && root.right.val != root.val) {
            return false;
        }

        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

}
