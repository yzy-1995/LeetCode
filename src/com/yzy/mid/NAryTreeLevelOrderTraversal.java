package com.yzy.mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/17 01:14
 * @Description
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 *
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 * @Version 1.0
 */
public class NAryTreeLevelOrderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null){
            return res;
        }

        LinkedList<Node> treeNodes = new LinkedList();
        Node cur = root;
        treeNodes.addFirst(cur);
        while (treeNodes.size() != 0){
            int num = treeNodes.size();
            List<Integer> list = new ArrayList();
            while (num > 0){
                Node node = treeNodes.removeLast();
                cur = node;
                list.add(cur.val);

                for (int i = 0; i < cur.children.size(); i++){
                    treeNodes.addFirst(cur.children.get(i));
                }

                num--;
            }
            res.add(list);
        }
        return res;
    }
}