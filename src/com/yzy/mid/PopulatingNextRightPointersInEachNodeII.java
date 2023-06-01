package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: PopulatingNextRightPointersInEachNodeII
 * Description:
 * 给定一个二叉树：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 *
 * @author Administrator
 * @date 2023-5-30 10:13
 */
public class PopulatingNextRightPointersInEachNodeII {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
    List<Node> list = new ArrayList<>();

    public Node connect(Node root) {
        dfs(root, 0);
        return root;
    }

    public void dfs(Node root, int deep) {
        if (root == null) {
            return;
        }
        deep++;
        if (list.size() < deep) {
            list.add(null);
        }

        dfs(root.right, deep);
        dfs(root.left, deep);

        root.next = list.get(deep - 1);
        list.set(deep - 1, root);

    }
}
