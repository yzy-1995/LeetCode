package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Offer54
 * Description:
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 * 限制：
 * 1 ≤ k ≤ 二叉搜索树元素个数
 *
 * @author Administrator
 * @date 2023-5-17 16:46
 */
public class Offer54 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthLargest(TreeNode root, int k) {
        List<Integer> resList = new ArrayList<>();
        inOrder(root, resList);

        return resList.get(resList.size() - k);
    }

    private void inOrder(TreeNode root, List<Integer> resList){
        if (root == null) {
            return;
        }
        inOrder(root.left, resList);
        resList.add(root.val);
        inOrder(root.right, resList);
    }
}
