package com.yzy.mid;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/15 00:17
 * @Description
 * 给你一棵二叉树的根节点 root ，请你判断这棵树是否是一棵 完全二叉树 。
 *
 * 在一棵 完全二叉树 中，除了最后一层外，所有层都被完全填满，并且最后一层中的所有节点都尽可能靠左。最后一层（第 h 层）中可以包含 1 到 2h 个节点。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,6]
 * 输出：true
 * 解释：最后一层前的每一层都是满的（即，节点值为 {1} 和 {2,3} 的两层），且最后一层中的所有节点（{4,5,6}）尽可能靠左。
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：false
 * 解释：值为 7 的节点不满足条件「节点尽可能靠左」。
 * @Version 1.0
 */
public class checkcompletenessofabinarytree {
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
    Queue<TreeNode> isCompleteQueue = new LinkedList<>();

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        isCompleteQueue.offer(root);
        while (!isCompleteQueue.isEmpty()) {
            int size = isCompleteQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = isCompleteQueue.poll();
                if (node == null) {
                    return isCompleteQueue.stream().allMatch(Objects::isNull);
                }
                isCompleteQueue.offer(node.left);
                isCompleteQueue.offer(node.right);
            }
        }
        return false;
    }

}