package com.yzy.mid;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/07 00:05
 * @Description
 * 完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
 *
 * 设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。
 *
 * 实现 CBTInserter 类:
 *
 * CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v)  向树中插入一个值为 Node.val == val的新节点 TreeNode。使树保持完全二叉树的状态，并返回插入节点 TreeNode 的父节点的值；
 * CBTInserter.get_root() 将返回树的头节点。
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入
 * ["CBTInserter", "insert", "insert", "get_root"]
 * [[[1, 2]], [3], [4], []]
 * 输出
 * [null, 1, 2, [1, 2, 3, 4]]
 *
 * 解释
 * CBTInserter cBTInserter = new CBTInserter([1, 2]);
 * cBTInserter.insert(3);  // 返回 1
 * cBTInserter.insert(4);  // 返回 2
 * cBTInserter.get_root(); // 返回 [1, 2, 3, 4]
 * @Version 1.0
 */
public class completebinarytreeinserter {
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
    TreeNode tree;

    public completebinarytreeinserter(TreeNode root) {
        tree = root;

    }

    public int insert(int val) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                //满二叉树
                if(temp.left == null && temp.right == null){
                    //插左边
                    temp.left = new TreeNode(val);
                    result = temp.val;
                    //找到结束所有循环
                    while(! queue.isEmpty()){
                        queue.poll();
                    }
                    break;
                }
                //完全二叉树
                if(temp.right == null){
                    //插右边
                    temp.right = new TreeNode(val);
                    result =  temp.val;
                    //找到结束所有循环
                    while(! queue.isEmpty()){
                        queue.poll();
                    }
                    break;
                }
                //左子树不为空
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                //右子树不为空
                if(temp.right != null){
                    queue.offer(temp.right);
                }

            }
        }
        return result;
    }

    public TreeNode get_root() {
        return tree;

    }

}