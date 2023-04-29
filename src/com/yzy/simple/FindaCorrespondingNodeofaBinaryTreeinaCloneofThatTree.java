package com.yzy.simple;

/**
 * Description: leetcode1379
 * 给你两棵二叉树，原始树 original 和克隆树 cloned，以及一个位于原始树 original 中的目标节点 target。
 *
 * 其中，克隆树 cloned 是原始树 original 的一个 副本 。
 *
 * 请找出在树 cloned 中，与 target 相同 的节点，并返回对该节点的引用（在 C/C++ 等有指针的语言中返回 节点指针，其他语言返回节点本身）。
 *
 *
 *
 * 注意：你 不能 对两棵二叉树，以及 target 节点进行更改。只能 返回对克隆树 cloned 中已有的节点的引用。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入: tree = [7,4,3,null,null,6,19], target = 3
 * 输出: 3
 * 解释: 上图画出了树 original 和 cloned。target 节点在树 original 中，用绿色标记。答案是树 cloned 中的黄颜色的节点（其他示例类似）。
 * 示例 2:
 *
 *
 *
 * 输入: tree = [7], target =  7
 * 输出: 7
 * 示例 3:
 *
 *
 *
 * 输入: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
 * 输出: 4
 * @author yzy15
 * @date 2023/04/29 12:56
 **/
public class FindaCorrespondingNodeofaBinaryTreeinaCloneofThatTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }

        if (original == target) {
            return cloned;
        }

        TreeNode leftResult = getTargetCopy(original.left, cloned.left, target);
        if (leftResult != null) {
            return leftResult;
        }

        TreeNode rightResult = getTargetCopy(original.right, cloned.right, target);
        if (rightResult != null) {
            return rightResult;
        }

        return null;
    }
}
