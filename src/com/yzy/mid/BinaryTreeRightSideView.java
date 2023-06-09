package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: BinaryTreeRightSideView
 * Description:
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * 示例 2:
 * <p>
 * 输入: [1,null,3]
 * 输出: [1,3]
 * 示例 3:
 * <p>
 * 输入: []
 * 输出: []
 *
 * @author Administrator
 * @date 2023-6-9 14:27
 */
public class BinaryTreeRightSideView {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        rightSide(list, 1, root);
        return list;
    }

    private void rightSide(List<Integer> list, int depth, TreeNode root) {
        if (root == null) return;
        if (depth == list.size() + 1) list.add(root.val);
        depth++;
        rightSide(list, depth, root.right);
        rightSide(list, depth, root.left);
    }
}
