package com.yzy.mid;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/31 00:03
 * @Description
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 *
 *
 *
 * 示例1：
 *
 *
 *
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 示例2：
 *
 * 输入: root = [1,2,3]
 * 输出: [1,3]
 * @Version 1.0
 */
public class FindLargestValueInEachTreeRow {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int n = queue.size();
            int max = Integer.MIN_VALUE;
            while (n>0) {
                n--;
                TreeNode temp = queue.poll();
                max = Math.max(max, temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}