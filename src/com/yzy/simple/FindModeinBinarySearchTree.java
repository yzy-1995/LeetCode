package com.yzy.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: FindModeinBinarySearchTree
 * Description:
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 *
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 *
 * 假定 BST 满足如下定义：
 *
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 * 输入：root = [1,null,2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：root = [0]
 * 输出：[0]
 * @author Administrator
 * @date 2023-4-12 14:48
 */
public class FindModeinBinarySearchTree {

    public static void main(String[] args) {

    }
    Map<Integer,Integer> map = new HashMap<>();
    int maxCount=0;
    public int[] findMode(TreeNode root) {
        inorderTraversal(root);
        List<Integer> modeList = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
                modeList.add(entry.getKey());
            }
        }

        int[] modes = new int[modeList.size()];
        for (int i = 0; i < modeList.size(); i++) {
            modes[i] = modeList.get(i);
        }
        return modes;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);

        int count = map.getOrDefault(node.val, 0) + 1;
        map.put(node.val, count);
        maxCount = Math.max(maxCount, count);

        inorderTraversal(node.right);
    }
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
}
