package com.yzy.mid;

/**
 * ClassName: MaximumDifferenceBetweenNodeandAncestor
 * Description:leetcode1026
 * 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 * 示例 1：
 * 输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * 输出：7
 * 解释：
 * 我们有大量的节点与其祖先的差值，其中一些如下：
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
 * 示例 2：
 * 输入：root = [1,null,2,null,0,3]
 * 输出：3
 *
 * @author Administrator
 * @date 2023-4-18 9:04
 */
public class MaximumDifferenceBetweenNodeandAncestor {
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

    public int maxAncestorDiff(TreeNode root) {
        return helper(root, root.val, root.val);
    }

    private int helper(TreeNode node, int maxVal, int minVal) {
        if (node == null) {
            return 0;
        }
        int diff = Math.max(Math.abs(maxVal - node.val), Math.abs(minVal - node.val));
        maxVal = Math.max(maxVal, node.val);
        minVal = Math.min(minVal, node.val);
        int leftDiff = helper(node.left, maxVal, minVal);
        int rightDiff = helper(node.right, maxVal, minVal);
        return Math.max(diff, Math.max(leftDiff, rightDiff));
    }
}
