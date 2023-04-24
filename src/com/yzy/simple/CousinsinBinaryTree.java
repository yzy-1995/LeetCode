package com.yzy.simple;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: leetcode993
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 * 示例 1：
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 示例 2：
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * 示例 3：
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *
 * @author yzy15
 * @date 2023/04/23 22:32
 **/
public class CousinsinBinaryTree {
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

    public boolean isCounsins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        TreeNode[] parents = new TreeNode[101];
        int[] depths = new int[101];

        nodeQueue.offer(root);
        depthQueue.offer(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode currentNode = nodeQueue.poll();
            int currentDepth = depthQueue.poll();

            if (currentNode.left != null) {
                parents[currentNode.left.val] = currentNode;
                depths[currentNode.left.val] = currentDepth + 1;
                nodeQueue.offer(currentNode.left);
                depthQueue.offer(currentDepth + 1);
            }

            if (currentNode.right != null) {
                parents[currentNode.right.val] = currentNode;
                depths[currentNode.right.val] = currentDepth + 1;
                nodeQueue.offer(currentNode.right);
                depthQueue.offer(currentDepth + 1);
            }
        }

        return depths[x] == depths[y] && parents[x] != parents[y];
    }
}
