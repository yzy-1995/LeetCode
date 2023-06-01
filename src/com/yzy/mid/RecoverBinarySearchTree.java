package com.yzy.mid;

/**
 * ClassName: RecoverBinarySearchTree
 * Description:
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 的左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 * 示例 2：
 * <p>
 * 输入：root = [3,1,4,null,null,2]
 * 输出：[2,1,4,null,null,3]
 * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 *
 * @author Administrator
 * @date 2023-5-26 13:46
 */
public class RecoverBinarySearchTree {
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

    TreeNode firstMax = null;
    TreeNode lastMin = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        helper(root);
        if (firstMax != null && lastMin != null) {
            int temp = firstMax.val;
            firstMax.val = lastMin.val;
            ;
            lastMin.val = temp;
        }
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (root.val < prev.val) {
            lastMin = root;
            if (firstMax == null) {
                firstMax = prev;
            }
        }
        prev = root;
        helper(root.right);
    }
}
