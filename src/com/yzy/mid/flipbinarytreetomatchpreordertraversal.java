package com.yzy.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/17 16:08
 * @Description 给你一棵二叉树的根节点 root ，树中有 n 个节点，每个节点都有一个不同于其他节点且处于 1 到 n 之间的值。
 * <p>
 * 另给你一个由 n 个值组成的行程序列 voyage ，表示 预期 的二叉树 先序遍历 结果。
 * <p>
 * 通过交换节点的左右子树，可以 翻转 该二叉树中的任意节点。例，翻转节点 1 的效果如下：
 * <p>
 * <p>
 * 请翻转 最少 的树中节点，使二叉树的 先序遍历 与预期的遍历行程 voyage 相匹配 。
 * <p>
 * 如果可以，则返回 翻转的 所有节点的值的列表。你可以按任何顺序返回答案。如果不能，则返回列表 [-1]。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2], voyage = [2,1]
 * 输出：[-1]
 * 解释：翻转节点无法令先序遍历匹配预期行程。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3], voyage = [1,3,2]
 * 输出：[1]
 * 解释：交换节点 2 和 3 来翻转节点 1 ，先序遍历可以匹配预期行程。
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [1,2,3], voyage = [1,2,3]
 * 输出：[]
 * 解释：先序遍历已经匹配预期行程，所以不需要翻转节点。
 * @Version 1.0
 */
public class flipbinarytreetomatchpreordertraversal {
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
    int[] voyage;
    int idx;
    List<Integer> flipped = new ArrayList<>();

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage = voyage;
        this.idx = 0;

        return dfs(root) ? flipped : Arrays.asList(-1);
    }

    boolean dfs(TreeNode root) {
        if (root == null) return true;

        // 当前节点验证失败
        if (root.val != voyage[idx]) return false;

        idx++;
        // 如果left存在，且与预期的下一个值不等
        //  则认为是需要调换的
        if (root.left != null && root.left.val != voyage[idx]) {
            flipped.add(root.val);
            // 尝试以调换后的顺序来继续验证
            return dfs(root.right) && dfs(root.left);
        } else {
            // 尝试以原来的顺序继续验证
            return dfs(root.left) && dfs(root.right);
        }
    }


}