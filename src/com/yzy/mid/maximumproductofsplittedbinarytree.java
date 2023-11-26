package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/26 18:25
 * @Description
 * 给你一棵二叉树，它的根为 root 。请你删除 1 条边，使二叉树分裂成两棵子树，且它们子树和的乘积尽可能大。
 *
 * 由于答案可能会很大，请你将结果对 10^9 + 7 取模后再返回。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,6]
 * 输出：110
 * 解释：删除红色的边，得到 2 棵子树，和分别为 11 和 10 。它们的乘积是 110 （11*10）
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,null,2,3,4,null,null,5,6]
 * 输出：90
 * 解释：移除红色的边，得到 2 棵子树，和分别是 15 和 6 。它们的乘积为 90 （15*6）
 * 示例 3：
 *
 * 输入：root = [2,3,9,10,7,8,6,5,4,11,1]
 * 输出：1025
 * 示例 4：
 *
 * 输入：root = [1,1]
 * 输出：1
 * @Version 1.0
 */
public class maximumproductofsplittedbinarytree {
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
    int mod=(int)1e9+7;
    public int maxProduct(TreeNode root) {
        findSum(root);
        return (int)(findPro(root,root.val)%mod);
    }
    long findPro(TreeNode t,int sum){
        if(t==null){return 0;}
        return Math.max(Math.max(findPro(t.left,sum),findPro(t.right,sum)),(long)t.val*(sum-t.val));
    }
    void findSum(TreeNode t){
        if(t==null){return;}
        findSum(t.left);
        findSum(t.right);
        t.val+=(t.left==null?0:t.left.val)+(t.right==null?0:t.right.val);
    }
}