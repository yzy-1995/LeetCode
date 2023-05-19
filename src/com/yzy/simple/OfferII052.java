package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: OfferII052
 * Description:
 * 给你一棵二叉搜索树，请 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 *
 * @author Administrator
 * @date 2023-5-19 15:25
 */
public class OfferII052 {

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

    List<Integer> list=new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        TreeNode r=new TreeNode(-1);
        TreeNode n=r;
        inorder(root);
        for(int val:list){
            n.right=new TreeNode(val);
            n=n.right;
        }
        return r.right;
    }

    public TreeNode inorder(TreeNode root){
        if(root==null) return null;
        TreeNode node=root;
        TreeNode left=inorder(node.left);
        list.add(node.val);
        TreeNode right=inorder(node.right);
        return node;
    }
}
