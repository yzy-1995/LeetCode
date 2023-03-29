package com.yzy.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: OpeningCeremonyFireworks
 * Description:
 * 「力扣挑战赛」开幕式开始了，空中绽放了一颗二叉树形的巨型焰火。
 * 给定一棵二叉树 root 代表焰火，节点值表示巨型焰火这一位置的颜色种类。请帮小扣计算巨型焰火有多少种不同的颜色。
 * 示例 1：
 * 输入：root = [1,3,2,1,null,2]
 * 输出：3
 * 解释：焰火中有 3 个不同的颜色，值分别为 1、2、3
 * <p>
 * 示例 2：
 * 输入：root = [3,3,3]
 * 输出：1
 * 解释：焰火中仅出现 1 个颜色，值为 3
 *
 * @author Administrator
 * @date 2023-3-27 18:49
 */
public class OpeningCeremonyFireworks {
    public static void main(String[] args) {

    }

    public int numColor(TreeNode root) {
        Set<Integer> colorSet = new HashSet<>();
        dfs(root, colorSet);
        return colorSet.size();
    }

    private void dfs(TreeNode node, Set<Integer> colorSet) {
        if (node == null) {
            return;
        }
        colorSet.add(node.val);
        dfs(node.left, colorSet);
        dfs(node.right, colorSet);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
