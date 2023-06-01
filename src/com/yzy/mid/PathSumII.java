package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;


/**
 * ClassName: PathSumII
 * Description:
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 *
 * @author Administrator
 * @date 2023-5-29 17:22
 */
public class PathSumII {
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

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, 0, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int num, int sum) {
        if (root == null) return;
        num += root.val;
        list.add(root.val);
        if (num == sum && root.left == null && root.right == null) res.add(new ArrayList<>(list));
        dfs(root.left, num, sum);
        dfs(root.right, num, sum);
        list.remove(list.size() - 1);
    }
}
