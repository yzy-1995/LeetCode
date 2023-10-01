package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/01 01:59
 * @Description
 * 在 rows x cols 的网格上，你从单元格 (rStart, cStart) 面朝东面开始。网格的西北角位于第一行第一列，网格的东南角位于最后一行最后一列。
 *
 * 你需要以顺时针按螺旋状行走，访问此网格中的每个位置。每当移动到网格的边界之外时，需要继续在网格之外行走（但稍后可能会返回到网格边界）。
 *
 * 最终，我们到过网格的所有 rows x cols 个空间。
 *
 * 按照访问顺序返回表示网格位置的坐标列表。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：rows = 1, cols = 4, rStart = 0, cStart = 0
 * 输出：[[0,0],[0,1],[0,2],[0,3]]
 * 示例 2：
 *
 *
 * 输入：rows = 5, cols = 6, rStart = 1, cStart = 4
 * 输出：[[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
 * @Version 1.0
 */
public class spiralmatrixiii {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int m = rows;
        int n = cols;
        int all = m * n;
        int[][] res = new int[all][2];
        int left = cStart;
        int right = cStart;
        int up = rStart;
        int down = rStart;
        int cnt = 0;
        while (cnt < all) {
            for (int i = left; i <= right; i++) {
                if (i >= 0 && i < n && up >= 0 && up < m) {
                    res[cnt] = new int[]{up, i};
                    cnt++;
                }
            }
            right++;

            for (int i = up; i <= down; i++) {
                if (i >= 0 && i < m && right >= 0 && right < n) {
                    res[cnt] = new int[]{i, right};
                    cnt++;
                }
            }
            down++;

            for (int i = right; i >= left; i--) {
                if (i >= 0 && i < n && down >= 0 && down < m) {
                    res[cnt] = new int[]{down, i};
                    cnt++;
                }
            }
            left--;

            for (int i = down; i >= up; i--) {
                if (i >= 0 && i < m && left >= 0 && left < n) {
                    res[cnt] = new int[]{i, left};
                    cnt++;
                }
            }
            up--;
        }
        return res;
    }
}