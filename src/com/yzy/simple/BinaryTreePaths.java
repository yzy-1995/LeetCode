package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: BinaryTreePaths
 * Description:
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * 输入：root = [1]
 * 输出：["1"]
 * @author Administrator
 * @date 2023-3-29 15:26
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root,"",list);
        return list;
    }

    private void dfs(TreeNode root,String path ,List<String> list){
        if (root==null){
            return;
        }
        path += root.val;
        if (root.left == null && root.right == null){
            list.add(path);
            return;
        }
        path += "->";
        dfs(root.left,path,list);
        dfs(root.right,path,list);
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
