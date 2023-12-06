package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/05 00:07
 * @Description
 * 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。如果有多种构造方法，请你返回任意一种。
 *
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,null,2,null,3,null,4,null,null]
 * 输出：[2,1,3,null,null,null,4]
 * 解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。
 * 示例 2：
 *
 *
 *
 * 输入: root = [2,1,3]
 * 输出: [2,1,3]
 * @Version 1.0
 */
public class balanceabinarysearchtree {
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
    public TreeNode balanceBST(TreeNode root) {
        return balance(root);
    }

    TreeNode balance(TreeNode node) {
        // 后序遍历找到不平衡点
        if (node.left != null) {
            node.left = balance(node.left);
        }
        if (node.right != null) {
            node.right = balance(node.right);
        }
        int rH = height(node.right), lH = height(node.left);
        int u = Math.abs(rH - lH);
        if (u > 1) {
            TreeNode newRoot = null;
            // 1.确定大方向（这个节点的左边还是右边不平衡）
            int max = Math.max(rH, lH);
            if (max == lH) {// L
                final TreeNode L_NODE = node.left;
                // 2.确定小方向 再看子树的左右子树的高高度
                int l_lH = height(L_NODE.left), l_rH = height(L_NODE.right);
                if (l_rH > l_lH) {// LR
                    TreeNode lrHand = LRHand(node);
                    return balance(lrHand);
                }
                //最终形式： LL
                TreeNode llHand = LLHand(node);
                // 注意：
                // 由于是原地调整：这里需要将旋转后得到的根节点再次进行，
                //因为你不能保证左右子树就是平衡的，这不是AVL
                //  balance（从最底下到该层调整，然后才能返回给上层节点使用）
                return balance(llHand);
            } else if (rH - lH > 1) {
                // R
                final TreeNode R_NODE = node.right;
                int r_lH = height(R_NODE.left), r_rH = height(R_NODE.right);
                if (r_lH > r_rH) { // RL
                    TreeNode rlHand = RLHand(node);
                    return balance(rlHand);
                }
                TreeNode rrHand = RRHand(node);
                return balance(rrHand);
            }
        }
        // 平衡就直接返回原本的自己
        return node;
    }

    // LL
    TreeNode LLHand(TreeNode uNode) {
        TreeNode newNode = uNode.left;
        uNode.left = newNode.right;
        newNode.right = uNode;
        return newNode;
    }

    // LR : 先把右子树节点提上来 ，然后使用 LL
    TreeNode LRHand(TreeNode uNode) {
        TreeNode middleNode = uNode.left;
        uNode.left = RRHand(middleNode);
        return LLHand(uNode);
    }

    // RR
    TreeNode RRHand(TreeNode uNode) {
        TreeNode newNode = uNode.right;
        uNode.right = newNode.left;
        newNode.left = uNode;
        return newNode;
    }

    //RL
    TreeNode RLHand(TreeNode uNode) {
        TreeNode middleNode = uNode.right;
        uNode.right = LLHand(middleNode);
        return RRHand(uNode);
    }

    // 获取高度
    int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = 0, r = 0;
        if (node.left != null) {
            l = height(node.left);
        }
        if (node.right != null) {
            r = height(node.right);
        }
        return Math.max(l, r) + 1;
    }

}