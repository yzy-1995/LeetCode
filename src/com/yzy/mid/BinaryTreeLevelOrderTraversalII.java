package com.yzy.mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: BinaryTreeLevelOrderTraversalII
 * Description:
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 示例 1：
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[15,7],[9,20],[3]]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 *
 * 输入：root = []
 * 输出：[]
 * @author Administrator
 * @date 2023-5-26 16:51
 */
public class BinaryTreeLevelOrderTraversalII {

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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=  new LinkedList<>();
        dfs(root,0,res);
        return res;
    }

    private void dfs(TreeNode root, int depth, List<List<Integer>> res) {
        if (root==null){
            return;
        }
        if (depth==res.size()){
            res.add(0,new ArrayList<>());
        }
        res.get(res.size()-depth-1).add(root.val);
        dfs(root.left,depth+1,res);
        dfs(root.right,depth+1,res);
    }
}
