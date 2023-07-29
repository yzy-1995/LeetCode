package com.yzy.mid;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/30 00:22
 * @Description 给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 * <p>
 * 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入: root = [5,2,-3]
 * 输出: [2,-3,4]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入: root = [5,2,-5]
 * 输出: [2]
 * @Version 1.0
 */
public class MostFrequentSubtreeSum {
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

    private int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[0];
        Map<Integer,Integer> map = new HashMap<>();
        helper(root,map);
        //然后求出map中value最大值对应的Key
        List<Integer> res = new LinkedList<>();
        for(Integer i : map.keySet()){
            if(map.get(i) == max)
                res.add(i);
        }
        int[] resArr = new int[res.size()];
        for(int i = 0;i < res.size();i++){
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    private int helper(TreeNode root,Map<Integer,Integer> map){
        if(root == null) return 0;
        //求出当前节点为根的元素和
        int left = helper(root.left,map);
        int right = helper(root.right,map);
        int val = left+right+root.val;
        map.put(val,map.getOrDefault(val,0)+1);
        max = Math.max(max,map.get(val));
        return val;
    }
}