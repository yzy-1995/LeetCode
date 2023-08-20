package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/16 00:07
 * @Description
 * 给定一个二叉树的根 root 和两个整数 val 和 depth ，在给定的深度 depth 处添加一个值为 val 的节点行。
 *
 * 注意，根节点 root 位于深度 1 。
 *
 * 加法规则如下:
 *
 * 给定整数 depth，对于深度为 depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
 * cur 原来的左子树应该是新的左子树根的左子树。
 * cur 原来的右子树应该是新的右子树根的右子树。
 * 如果 depth == 1 意味着 depth - 1 根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入: root = [4,2,6,3,1,5], val = 1, depth = 2
 * 输出: [4,1,1,2,null,null,6,3,1,5]
 * 示例 2:
 *
 *
 *
 * 输入: root = [4,2,null,3,1], val = 1, depth = 3
 * 输出:  [4,2,null,1,1,3,null,null,1]
 * @Version 1.0
 */
public class AddOneRowToTree {
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

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 0 || d == 1) {
            TreeNode t = new TreeNode(v);
            if (d == 1) t.left = root;
            else t.right = root;
            return t;
        }
        if (root != null && d > 1) {
            root.left = addOneRow(root.left, v, d > 2 ? d - 1 : 1);
            root.right = addOneRow(root.right, v, d > 2 ? d - 1 : 0);
        }
        return root;
    }
}