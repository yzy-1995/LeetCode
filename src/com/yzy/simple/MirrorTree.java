package com.yzy.simple;

/**
 * ClassName: MirrorTree
 * Description:
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 例如输入：
 * <p>
 * 4
 * <p>
 * /   \
 * <p>
 * 2     7
 * <p>
 * / \   / \
 * <p>
 * 1   3 6   9
 * 镜像输出：
 * <p>
 * 4
 * <p>
 * /   \
 * <p>
 * 7     2
 * <p>
 * / \   / \
 * <p>
 * 9   6 3   1
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * @author Administrator
 * @date 2023-5-15 16:16
 */
public class MirrorTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        TreeNode p = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(p);
        return root;
    }
}
