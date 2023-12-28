package com.yzy.mid;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/28 00:13
 * @Description
 * 给你二叉树的根节点 root 和一个整数 distance 。
 *
 * 如果二叉树中两个 叶 节点之间的 最短路径长度 小于或者等于 distance ，那它们就可以构成一组 好叶子节点对 。
 *
 * 返回树中 好叶子节点对的数量 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 *
 *
 * 输入：root = [1,2,3,null,4], distance = 3
 * 输出：1
 * 解释：树的叶节点是 3 和 4 ，它们之间的最短路径的长度是 3 。这是唯一的好叶子节点对。
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,6,7], distance = 3
 * 输出：2
 * 解释：好叶子节点对为 [4,5] 和 [6,7] ，最短路径长度都是 2 。但是叶子节点对 [4,6] 不满足要求，因为它们之间的最短路径长度为 4 。
 * 示例 3：
 *
 * 输入：root = [7,1,4,6,null,5,3,null,null,null,null,null,2], distance = 3
 * 输出：1
 * 解释：唯一的好叶子节点对是 [2,5] 。
 * 示例 4：
 *
 * 输入：root = [100], distance = 1
 * 输出：0
 * 示例 5：
 *
 * 输入：root = [1,1,1], distance = 2
 * 输出：1
 * @Version 1.0
 */
public class numberofgoodleafnodespairs {
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
    public int countPairs(TreeNode root, int distance) {
        if (root == null) return 0;
        List<Integer> lefts = new LinkedList<>();
        countDepth(root.left, 0, lefts);
        List<Integer> rights = new LinkedList<>();
        countDepth(root.right, 0, rights);

        int res = 0;
        for (Integer l : lefts)
            for (Integer r : rights)
                if (l + r + 2 <= distance)
                    res++;

        res += countPairs(root.left, distance);
        res += countPairs(root.right, distance);
        return res;
    }

    void countDepth(TreeNode node, int depth, List<Integer> list) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            list.add(depth);
            return;
        }
        countDepth(node.left, depth + 1, list);
        countDepth(node.right, depth + 1, list);
    }
}