package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/27 00:04
 * @Description
 * 给定一个根为 root 的二叉树，每个节点的深度是 该节点到根的最短距离 。
 *
 * 返回包含原始树中所有 最深节点 的 最小子树 。
 *
 * 如果一个节点在 整个树 的任意节点之间具有最大的深度，则该节点是 最深的 。
 *
 * 一个节点的 子树 是该节点加上它的所有后代的集合。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4]
 * 输出：[2,7,4]
 * 解释：
 * 我们返回值为 2 的节点，在图中用黄色标记。
 * 在图中用蓝色标记的是树的最深的节点。
 * 注意，节点 5、3 和 2 包含树中最深的节点，但节点 2 的子树最小，因此我们返回它。
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 解释：根节点是树中最深的节点。
 * 示例 3：
 *
 * 输入：root = [0,1,3,null,2]
 * 输出：[2]
 * 解释：树中最深的节点为 2 ，有效子树为节点 2、1 和 0 的子树，但节点 2 的子树最小。
 * @Version 1.0
 */
public class smallestsubtreewithallthedeepestnodes {
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
    TreeNode node;
    int h;
    int cnt = 0;
    boolean t = false;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // 先找到树的最大深度，统计树的最大深度的结点个数
        // 找到最大深度的点，自底向上返回，如果某个点的值等于结点个数，则为答案
        h = dfs(root);
        dfs2(root,1);
        dfs3(root,1);
        return node;
    }

    int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(dfs(root.left) + 1,dfs(root.right) + 1);
    }

    void dfs2(TreeNode root,int h1){
        if (root == null){
            return;
        }
        if (h1 == h){
            cnt++;
        }
        dfs2(root.left,h1 + 1);
        dfs2(root.right,h1 + 1);
    }

    int dfs3(TreeNode root,int h1){
        if (root == null){
            return 0;
        }
        int ans = dfs3(root.left,h1 + 1) + dfs3(root.right,h1 + 1) + (h1 == h ? 1 : 0);
        if (ans == cnt && !t){
            node = root;
            t = true;
        }
        return ans;
    }

}