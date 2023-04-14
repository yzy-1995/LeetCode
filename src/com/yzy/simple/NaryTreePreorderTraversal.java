package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: NaryTreePreorderTraversal
 * Description:
 * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,3,5,6,2,4]
 * 示例 2：
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 * @author Administrator
 * @date 2023-4-14 15:04
 */
public class NaryTreePreorderTraversal {
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
    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        helper(root, result);
        return result;
    }

    private void helper(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }

        result.add(node.val);
        for (Node child : node.children) {
            helper(child, result);
        }
    }
}
