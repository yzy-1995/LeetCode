package com.yzy.mid;

import java.util.Arrays;

/**
 * ClassName: ConstructBinaryTreeFromInorderAndPostorderTraversal
 * Description:
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * <p>
 * 示例 1:
 * <p>
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 *
 * @author Administrator
 * @date 2023-5-26 15:49
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        TreeNode root = new TreeNode(postorder[n - 1]);
        int i = 0;
        while (inorder[i] != postorder[n - 1]) {
            i++;
        }
        if (i > 0) {
            root.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
        }
        if (i < n - 1) {
            root.right = buildTree(Arrays.copyOfRange(inorder, i + 1, n), Arrays.copyOfRange(postorder, i, n - 1));
        }
        return root;
    }
}
