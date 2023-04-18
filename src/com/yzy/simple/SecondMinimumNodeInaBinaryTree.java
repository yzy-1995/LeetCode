package com.yzy.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: SecondMinimumNodeInaBinaryTree
 * Description:leetcode671
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 * 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * 更正式地说，即 root.val = min(root.left.val, root.right.val) 总成立。
 * 给出这样的一个二叉树，你需要输出所有节点中的 第二小的值 。
 * 如果第二小的值不存在的话，输出 -1 。
 * 示例 1：
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5 。
 * 示例 2：
 * 输入：root = [2,2,2]
 * 输出：-1
 * 解释：最小的值是 2, 但是不存在第二小的值。
 * @author Administrator
 * @date 2023-4-17 15:04
 */
public class SecondMinimumNodeInaBinaryTree {
    public static class TreeNode {
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

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2, new TreeNode(2), new TreeNode(5, new TreeNode(5), new TreeNode(7)));
        TreeNode root2 = new TreeNode(2, new TreeNode(2), new TreeNode(2));

        System.out.println(findSecondMinimumValue(root1));
        System.out.println(findSecondMinimumValue(root2));
    }

    public static int findSecondMinimumValue(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return -1;
        }

        Set<Integer> uniqueValues = new HashSet<>();
        traverseTree(root, uniqueValues);

        int min = root.val;
        long secondMin = Long.MAX_VALUE;

        for (int value : uniqueValues) {
            if (min < value && value < secondMin) {
                secondMin = value;
            }
        }

        return secondMin < Long.MAX_VALUE ? (int) secondMin : -1;
    }

    public static void traverseTree(TreeNode node, Set<Integer> uniqueValues) {
        if (node == null) {
            return;
        }

        uniqueValues.add(node.val);
        traverseTree(node.left, uniqueValues);
        traverseTree(node.right, uniqueValues);
    }
}
