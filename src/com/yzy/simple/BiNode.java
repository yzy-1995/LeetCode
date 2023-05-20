package com.yzy.simple;

/**
 * Description: l
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 * <p>
 * 返回转换后的单向链表的头节点。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 * 提示：
 * <p>
 * 节点数量不会超过 100000。
 *
 * @author yzy15
 * @date 2023/05/20 16:45
 **/
public class BiNode {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode pre;

    private TreeNode head;

    // BiNode
    public TreeNode convertBiNode(TreeNode root) {
        infixOrder(root);
        return head;
    }

    private void infixOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        infixOrder(node.left);
        if (pre != null) {
            node.left = null;
            pre.right = node;
        } else {
            head = node;
        }
        pre = node;
        infixOrder(node.right);
    }
}
