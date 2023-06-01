package com.yzy.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: ConstructBinaryTreeFromPreorderAndInorderTraversal
 * Description:
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 *
 * @author Administrator
 * @date 2023-5-26 15:28
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

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

    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorderleft, int preorderright, int inorderleft, int inorderright) {
        if (preorderleft > preorderright) {
            return null;
        }
        int preorderroot = preorderleft;
        int inorderroot = indexMap.get(preorder[preorderroot]);
        TreeNode root = new TreeNode(preorder[preorderroot]);
        int size = inorderroot - inorderleft;
        root.left = myBuildTree(preorder, inorder, preorderleft + 1, preorderleft + size, inorderleft, inorderroot - 1);
        root.right = myBuildTree(preorder, inorder, preorderleft + size + 1, preorderright, inorderroot + 1, inorderright);
        return root;
    }
}
