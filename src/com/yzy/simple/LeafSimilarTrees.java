package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: leetcode872
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 * 示例 1：
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 * 示例 2：
 * 输入：root1 = [1,2,3], root2 = [1,3,2]
 * 输出：false
 *
 * @author yzy15
 * @date 2023/04/21 22:20
 **/
public class LeafSimilarTrees {
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

    public static void main(String[] args) {

    }


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafValues1 = new ArrayList<>();
        List<Integer> leafValues2 = new ArrayList<>();
        getLeafValues(root1, leafValues1);
        getLeafValues(root2, leafValues2);
        return leafValues1.equals(leafValues2);
    }

    public static void getLeafValues(TreeNode node, List<Integer> leafValues) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            leafValues.add(node.val);
        }
        getLeafValues(node.left, leafValues);
        getLeafValues(node.right, leafValues);

    }
}
