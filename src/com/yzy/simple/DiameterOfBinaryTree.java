package com.yzy.simple;

/**
 * ClassName: DiameterOfBinaryTree
 * Description:
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 * @author Administrator
 * @date 2023-3-28 14:23
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {

    }
    int maxDiameter = 0;

    /**
     * 对于一颗二叉树，它的直径长度可能穿过根节点，也可能不穿过根节点。如果一条路径穿过根节点，
     * 那么它的长度就是左子树的深度加上右子树的深度；如果不穿过根节点，那么它的长度就是左子树直径和右子树直径的较大值。
     *
     * 因此，我们可以递归地求解左右子树的深度和直径，并且在递归过程中更新最大直径。
     *
     * 具体来说，我们可以定义一个递归函数，该函数求解以当前节点为根节点的子树的深度和直径，
     * 并且更新最大直径。函数返回子树的深度。
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getDepth(root);
        return maxDiameter;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
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
