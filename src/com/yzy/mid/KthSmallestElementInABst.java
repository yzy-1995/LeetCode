package com.yzy.mid;

/**
 * ClassName: KthSmallestElementInABst
 * Description:
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 *
 * @author Administrator
 * @date 2023-6-15 9:22
 */
public class KthSmallestElementInABst {
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

    private int k, v;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return this.v;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (k <= 0) return;
        k -= 1;
        if (k == 0) v = root.val;
        dfs(root.right);
    }
}
