package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/03 16:39
 * @Description
 * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
 *
 * 选择二叉树中 任意 节点和一个方向（左或者右）。
 * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
 * 改变前进方向：左变右或者右变左。
 * 重复第二步和第三步，直到你在树中无法继续移动。
 * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
 *
 * 请你返回给定树中最长 交错路径 的长度。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
 * 输出：3
 * 解释：蓝色节点为树中最长交错路径（右 -> 左 -> 右）。
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,1,1,null,1,null,null,1,1,null,1]
 * 输出：4
 * 解释：蓝色节点为树中最长交错路径（左 -> 右 -> 左 -> 右）。
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：0
 * @Version 1.0
 */
public class longestzigzagpathinabinarytree {
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
    public int longestZigZag(TreeNode root) {
        return Math.max(dfs(root.left, 1, true), dfs(root.right, 1, false)) - 1;
    }
    /**
     * 返回经过root的最长的zigzag路径节点数
     * @param root 当前节点
     * @param num 已经遍历的节点数
     * @param left 是否是左孩子
     * @return
     */
    public int dfs(TreeNode root, int num, boolean left) {
        if (root == null)
            return num;
        if (left) {
            return Math.max(dfs(root.left, 1, true), dfs(root.right, num + 1, false));
        } else {
            return Math.max(dfs(root.left, num + 1, true), dfs(root.right, 1, false));
        }
    }
}