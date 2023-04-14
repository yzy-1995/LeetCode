package com.yzy.simple;

/**
 * ClassName: RangeAdditionII
 * Description:
 * 给你一个 m x n 的矩阵 M ，初始化时所有的 0 和一个操作数组 op ，
 * 其中 ops[i] = [ai, bi] 意味着当所有的 0 <= x < ai 和 0 <= y < bi 时， M[x][y] 应该加 1。
 * 在 执行完所有操作后 ，计算并返回 矩阵中最大整数的个数 。
 * 示例 1:
 * 输入: m = 3, n = 3，ops = [[2,2],[3,3]]
 * 输出: 4
 * 解释: M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。
 * 示例 2:
 * 输入: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
 * 输出: 4
 * 示例 3:
 * 输入: m = 3, n = 3, ops = []
 * 输出: 9
 * @author Administrator
 * @date 2023-4-14 16:00
 */
public class RangeAdditionII {

    public static void main(String[] args) {
        RangeAdditionII mc = new RangeAdditionII();

        int[][] ops1 = {{2, 2}, {3, 3}};
        int[][] ops2 = {{2, 2}, {3, 3}, {3, 3}, {3, 3}, {2, 2}, {3, 3}, {3, 3}, {3, 3}, {2, 2}, {3, 3}, {3, 3}, {3, 3}};
        int[][] ops3 = {};

        System.out.println(mc.maxCount(3, 3, ops1));
        System.out.println(mc.maxCount(3, 3, ops2));
        System.out.println(mc.maxCount(3, 3, ops3));
    }

    public int maxCount(int m, int n, int[][] ops) {
        int minRow = m;
        int minCol = n;

        for (int[] op : ops) {
            minRow = Math.min(minRow, op[0]);
            minCol = Math.min(minCol, op[1]);
        }

        return minRow * minCol;
    }
}
