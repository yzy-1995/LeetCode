package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: UniqueBinarySearchTreesII
 * Description:
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 *
 * @author Administrator
 * @date 2023-5-25 17:08
 */
public class UniqueBinarySearchTreesII {
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

    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    private List<TreeNode> helper(int left, int right) {
        List<TreeNode> result = new ArrayList<>();
        if (left == right) {
            result.add(new TreeNode(left));
            return result;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftResults = helper(left, i - 1);
            List<TreeNode> rightResults = helper(i + 1, right);
            if (leftResults.size() == 0) {
                for (TreeNode rightNode : rightResults) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.right = rightNode;
                    result.add(treeNode);
                }

            } else if (rightResults.size() == 0) {
                for (TreeNode leftNode : leftResults) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftNode;
                    result.add(treeNode);
                }
            } else {
                for (TreeNode leftNode : leftResults) {
                    for (TreeNode rightNode : rightResults) {
                        TreeNode treeNode = new TreeNode(i);
                        treeNode.right = rightNode;
                        treeNode.left = leftNode;
                        result.add(treeNode);
                    }

                }

            }
        }
        return result;
    }
}
