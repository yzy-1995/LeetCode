package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/22 00:06
 * @Description 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 * <p>
 * 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 * 如果不存在祖父节点值为偶数的节点，那么返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：18
 * 解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
 * @Version 1.0
 */
public class sumofnodeswithevenvaluedgrandparent {
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
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) return 0;
        int temp = 0;
        if (root.val % 2 == 0) {
            if (root.left != null) {
                if (root.left.left != null) temp += root.left.left.val;
                if (root.left.right != null) temp += root.left.right.val;
            }
            if (root.right != null) {
                if (root.right.left != null) temp += root.right.left.val;
                if (root.right.right != null) temp += root.right.right.val;
            }
        }
        return temp + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
    }

}