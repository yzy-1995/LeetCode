package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/04 13:03
 * @Description
 * 给你一个下标从 0 开始、大小为 m x n 的二进制矩阵 matrix ；另给你一个整数 numSelect，表示你必须从 matrix 中选择的 不同 列的数量。
 *
 * 如果一行中所有的 1 都被你选中的列所覆盖，则认为这一行被 覆盖 了。
 *
 * 形式上，假设 s = {c1, c2, ...., cnumSelect} 是你选择的列的集合。对于矩阵中的某一行 row ，如果满足下述条件，则认为这一行被集合 s 覆盖：
 *
 * 对于满足 matrix[row][col] == 1 的每个单元格 matrix[row][col]（0 <= col <= n - 1），col 均存在于 s 中，或者
 * row 中 不存在 值为 1 的单元格。
 * 你需要从矩阵中选出 numSelect 个列，使集合覆盖的行数最大化。
 *
 * 返回一个整数，表示可以由 numSelect 列构成的集合 覆盖 的 最大行数 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：matrix = [[0,0,0],[1,0,1],[0,1,1],[0,0,1]], numSelect = 2
 * 输出：3
 * 解释：
 * 图示中显示了一种覆盖 3 行的可行办法。
 * 选择 s = {0, 2} 。
 * - 第 0 行被覆盖，因为其中没有出现 1 。
 * - 第 1 行被覆盖，因为值为 1 的两列（即 0 和 2）均存在于 s 中。
 * - 第 2 行未被覆盖，因为 matrix[2][1] == 1 但是 1 未存在于 s 中。
 * - 第 3 行被覆盖，因为 matrix[2][2] == 1 且 2 存在于 s 中。
 * 因此，可以覆盖 3 行。
 * 另外 s = {1, 2} 也可以覆盖 3 行，但可以证明无法覆盖更多行。
 * 示例 2：
 *
 *
 *
 * 输入：matrix = [[1],[0]], numSelect = 1
 * 输出：2
 * 解释：
 * 选择唯一的一列，两行都被覆盖了，因为整个矩阵都被覆盖了。
 * 所以我们返回 2 。
 * @Version 1.0
 */
public class maximumrowscoveredbycolumns {
    private int numSelect;
    int m;
    int n;

    private int ans;

    private int[] state;


    /**
     * 回溯&位运算
     *
     * @param matrix
     * @param numSelect
     * @return
     */
    public int maximumRows(int[][] matrix, int numSelect) {
        this.numSelect = numSelect;
        this.m = matrix.length;
        this.n = matrix[0].length;
        state = new int[m];
        // 记录每一行中哪些列为1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                state[i] = state[i] | (matrix[i][j] << j);
            }
        }
        dfs(0, 0, 0);
        return ans;
    }

    private void dfs(int colSelect, int col, int cnt) {
        // 到达递归边界了
        if (cnt == numSelect) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                // 如果这行中没有1,则合法
                if (state[i] == 0) {
                    sum++;
                } else if ((state[i] & colSelect) == state[i] && (state[i] | colSelect) == colSelect) {
                    // 如果这一行中的1的列在已经选择的列中,那么也合法
                    // 例如示例1的最后一行,状态为4(二进制:100),如果选择的列为0,2(二进制状态为:100),只要保证是列的状态的子集就可以
                    sum++;
                    continue;
                }
            }
            ans = Math.max(ans, sum);
            return;
        }
        // 枚举选哪一列
        for (int j = col; j < n; j++) {
            // colSelect | (1 << i):选择当前列
            dfs(colSelect | (1 << j), j + 1, cnt + 1);
        }
    }

}