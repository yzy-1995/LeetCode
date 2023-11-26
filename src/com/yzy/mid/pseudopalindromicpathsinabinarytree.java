package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/25 20:09
 * @Description 给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
 * <p>
 * 请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [2,3,1,3,1,null,1]
 * 输出：2
 * 解释：上图为给定的二叉树。总共有 3 条从根到叶子的路径：红色路径 [2,3,3] ，绿色路径 [2,1,1] 和路径 [2,3,1] 。
 * 在这些路径中，只有红色和绿色的路径是伪回文路径，因为红色路径 [2,3,3] 存在回文排列 [3,2,3] ，绿色路径 [2,1,1] 存在回文排列 [1,2,1] 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [2,1,1,1,3,null,null,null,null,null,1]
 * 输出：1
 * 解释：上图为给定二叉树。总共有 3 条从根到叶子的路径：绿色路径 [2,1,1] ，路径 [2,1,3,1] 和路径 [2,1] 。
 * 这些路径中只有绿色路径是伪回文路径，因为 [2,1,1] 存在回文排列 [1,2,1] 。
 * 示例 3：
 * <p>
 * 输入：root = [9]
 * 输出：1
 * @Version 1.0
 */
public class pseudopalindromicpathsinabinarytree {
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
    int path1 = 0;
    public int pseudoPalindromicPaths(TreeNode root) {
        int[] counter = new int[10];
        dfs(root, counter, 0);
        return path1;

    }
    public void dfs(TreeNode cur, int[] counter, int odd_node) {
        if (cur == null) return;
        counter[cur.val]++; // 节点出现一次计数一次
        if (counter[cur.val] % 2 != 0) {
            odd_node++; //如果计数不为偶数，则odd_node加1
        }else {
            odd_node--; //如果计数为偶数，则odd_node减1
        }
        if (cur.left == null && cur.right == null) { //如果这个节点为叶子节点则路径遍历结束，判断odd_node是否小于2
            if (odd_node < 2) {
                path1++;//小于2，则该路径为伪回文
            }
        }
        //深度优先搜索遍历剩下的节点
        dfs(cur.left, counter, odd_node);
        dfs(cur.right, counter, odd_node);
        counter[cur.val]--; //形参为引用数据类型或者为全局变量时，需要对其进行修改，让其回到上一层递归的状态
        return;
    }
}