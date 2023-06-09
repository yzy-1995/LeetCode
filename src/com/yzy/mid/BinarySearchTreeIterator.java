package com.yzy.mid;

/**
 * ClassName: BinarySearchTreeIterator
 * Description:
 *
 * @author Administrator
 * @date 2023-6-8 14:32
 */
public class BinarySearchTreeIterator {
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
    TreeNode list = null;
    public BinarySearchTreeIterator(TreeNode root) {
        parseTree(root);
    }

    private void parseTree(TreeNode node){
        if (node.right != null){
            parseTree(node.right);
        }
        node.right = list;
        list = node;
        if (node.left != null){
            parseTree(node.left);
        }
    }

    public int next() {
        int val = list.val;
        list = list.right;
        return val;
    }

    public boolean hasNext() {
        return list != null;
    }
}
