package com.yzy.mid;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/02/07 15:41
 * @Description 给你一棵二叉树的根 root ，请你将每个节点的值替换成该节点的所有 堂兄弟节点值的和 。
 * <p>
 * 如果两个节点在树中有相同的深度且它们的父节点不同，那么它们互为 堂兄弟 。
 * <p>
 * 请你返回修改值之后，树的根 root 。
 * <p>
 * 注意，一个节点的深度指的是从树根节点到这个节点经过的边数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,4,9,1,10,null,7]
 * 输出：[0,0,0,7,7,null,11]
 * 解释：上图展示了初始的二叉树和修改每个节点的值之后的二叉树。
 * - 值为 5 的节点没有堂兄弟，所以值修改为 0 。
 * - 值为 4 的节点没有堂兄弟，所以值修改为 0 。
 * - 值为 9 的节点没有堂兄弟，所以值修改为 0 。
 * - 值为 1 的节点有一个堂兄弟，值为 7 ，所以值修改为 7 。
 * - 值为 10 的节点有一个堂兄弟，值为 7 ，所以值修改为 7 。
 * - 值为 7 的节点有两个堂兄弟，值分别为 1 和 10 ，所以值修改为 11 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [3,1,2]
 * 输出：[0,0,0]
 * 解释：上图展示了初始的二叉树和修改每个节点的值之后的二叉树。
 * - 值为 3 的节点没有堂兄弟，所以值修改为 0 。
 * - 值为 1 的节点没有堂兄弟，所以值修改为 0 。
 * - 值为 2 的节点没有堂兄弟，所以值修改为 0 。
 * @Version 1.0
 */
public class cousinsinbinarytreeii {
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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> temp = new LinkedList<>();
        Queue<TreeNode> temp1 = new LinkedList<>();
        if(root != null) {
            queue.add(root);
            root.val = 0;
        }
        while(!queue.isEmpty()) {
            int sum = 0;
            while(!queue.isEmpty()) {
                TreeNode node = queue.remove();
                int val = (node.left != null ? node.left.val : 0) + (node.right != null ? node.right.val : 0);
                temp.add(val);
                temp1.add(node);
                sum += val;
            }
            while(!temp.isEmpty()) {
                int val = temp.remove();
                TreeNode node = temp1.remove();
                if(node.left != null) {
                    node.left.val = sum - val;
                    queue.add(node.left);
                }
                if(node.right != null) {
                    node.right.val = sum - val;
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}