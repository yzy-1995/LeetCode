package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/24 00:01
 * @Description
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。
 *
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,0,2], low = 1, high = 2
 * 输出：[1,null,2]
 * 示例 2：
 *
 *
 * 输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
 * 输出：[3,2,null,1]
 * @Version 1.0
 */
public class trimabinarysearchtree {
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null) return null;
        root.left=trimBST(root.left,low,high);
        root.right=trimBST(root.right,low,high);
        if(root.val<low||root.val>high){
            if(root.left==null&&root.right==null){
                return null;
            }
            else if(root.left!=null&&root.right==null){
                return root.left;
            }
            else if(root.right!=null &&root.left==null){
                return root.right;
            }
            else{
                TreeNode cur=root.right;
                while(cur.left!=null){
                    cur=cur.left;
                }
                cur.left=root.left;
                return root.right;
            }
        }
        return root;
    }

}