package com.yzy.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName: OfferII056
 * Description:
 * 给定一个二叉搜索树的 根节点 root 和一个整数 k , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。假设二叉搜索树中节点的值均唯一。
 *
 *
 *
 * 示例 1：
 *
 * 输入: root = [8,6,10,5,7,9,11], k = 12
 * 输出: true
 * 解释: 节点 5 和节点 7 之和等于 12
 * 示例 2：
 *
 * 输入: root = [8,6,10,5,7,9,11], k = 22
 * 输出: false
 * 解释: 不存在两个节点值之和为 22 的节点
 * @author Administrator
 * @date 2023-5-19 15:27
 */
public class OfferII056 {
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

    int k;
    boolean flag = false;
    HashMap<Integer,Integer> map;
    List<Integer> list;

    public boolean findTarget(TreeNode root, int k) {
        this.k = k;
        // map = new HashMap();
        list = new ArrayList();
        dfs(root);
        int left = 0;
        int right = list.size() -1;
        while(left < right){
            if(list.get(left) + list.get(right) == k){
                return true;
            }else if(list.get(left) + list.get(right) > k){
                right--;
            }else{
                left++;
            }
        }
        return false;
    }

    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);

    }
}
