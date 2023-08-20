package com.yzy.mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/20 20:19
 * @Description
 * 给你一棵二叉树的根节点 root ，返回所有 重复的子树 。
 *
 * 对于同一类的重复子树，你只需要返回其中任意 一棵 的根结点即可。
 *
 * 如果两棵树具有 相同的结构 和 相同的结点值 ，则认为二者是 重复 的。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,2,3,4,null,2,4,null,null,4]
 * 输出：[[2,4],[4]]
 * 示例 2：
 *
 *
 *
 * 输入：root = [2,1,1]
 * 输出：[[1]]
 * 示例 3：
 *
 *
 *
 * 输入：root = [2,2,2,3,null,3,null]
 * 输出：[[2,3],[3]]
 * @Version 1.0
 */
public class findduplicatesubtrees {
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

    HashMap<String,Integer> hashMap = new HashMap<>();
    ArrayList<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }
    //输入一个节点，返回以该节点为根节点的子树的结构的字符串形式
    String dfs(TreeNode root){
        if (root == null) {
            return "#";
        }
        //左子树结构
        String left = dfs(root.left);
        //右子树结构
        String right = dfs(root.right);
        //当前子树结构 = 左子树结构+右子树结构+根节点
        String str = left+","+right+","+root.val;
        //判断当前子树结构是否重复
        Integer n = hashMap.getOrDefault(str, 0);
        if (n == 1) {
            res.add(root);
        }
        hashMap.put(str,n+1);
        //返回子树结构的字符串形式
        return str;
    }
}