package com.yzy.simple;

/**
 * Description: le
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * <p>
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 *
 * @author yzy15
 * @date 2023/05/20 09:37
 **/
public class MinimumHeightTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        return arrayToBST(nums, 0, nums.length);
    }

    private TreeNode arrayToBST(int[] nums, int l, int r){
        if (l == r) {
            return null;
        }

        int mid = l + (r - l) / 2;
        // 中间节点mid不参与处理过程
        TreeNode root = new TreeNode(nums[mid]);
        root.left = arrayToBST(nums, l, mid);
        root.right = arrayToBST(nums, mid + 1, r);

        return root;
    }
}
