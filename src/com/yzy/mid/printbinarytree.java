package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/21 00:04
 * @Description
 * 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩阵需要遵循以下规则：
 *
 * 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
 * 矩阵的列数 n 应该等于 2height+1 - 1 。
 * 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
 * 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2height-r-1] ，右子节点放置在 res[r+1][c+2height-r-1] 。
 * 继续这一过程，直到树中的所有节点都妥善放置。
 * 任意空单元格都应该包含空字符串 "" 。
 * 返回构造得到的矩阵 res 。
 *
 *
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2]
 * 输出：
 * [["","1",""],
 *  ["2","",""]]
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3,null,4]
 * 输出：
 * [["","","","1","","",""],
 *  ["","2","","","","3",""],
 *  ["","","4","","","",""]]
 * @Version 1.0
 */
public class printbinarytree {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    /** 树的高度(从0开始) */
    public static int HEIGHT = 0;
    public static String tree[][] = {};

    public static List<List<String>> printTree(TreeNode root) {
        HEIGHT = 0; // 因为是常量, 所以需要重置, 避免多次执行未正确进行值处理
        getHeight(root, 0); // 获取树的深度
        int n = (2 << HEIGHT) - 1;
        tree = new String[HEIGHT + 1][n]; // 初始化二维数组
        setHeight(root, 0, (n - 1) / 2); // 将树中的值放在二维数组中
        // 将二维数组转为list<list>
        List<List<String>> list = new ArrayList<List<String>>();
        for (int i = 0; i < HEIGHT + 1; i++) {
            ArrayList<String> l = new ArrayList<String>();
            for (int j = 0; j < n; j++) {
                l.add(tree[i][j] == null ? "" : tree[i][j]); // 需将null换为""
            }
            list.add(l);
        }
        return list;
    }

    /**
     * 获取树的深度
     * @param root
     * @param h 深度
     * @return
     */
    public static void getHeight(TreeNode root, int h) {
        HEIGHT = h > HEIGHT ? h : HEIGHT; // 设置树的高度
        if (root.left != null)
            getHeight(root.left, h + 1);
        if (root.right != null)
            getHeight(root.right, h + 1);
    }

    /**
     * 将root中的值设置到tree对应的位置
     * @param root
     * @param r 行数
     * @param c 列数
     */
    public static void setHeight(TreeNode root, int r, int c) {
        tree[r][c] = root.val + "";
        int k = 1 << HEIGHT - r - 1;
        if (root.left != null)
            setHeight(root.left, r + 1, c - k);
        if (root.right != null)
            setHeight(root.right, r + 1, c + k);
    }
}