package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/19 00:04
 * @Description
 * 给你两个图像 img1 和 img2 ，两个图像的大小都是 n x n ，用大小相同的二进制正方形矩阵表示。二进制矩阵仅由若干 0 和若干 1 组成。
 *
 * 转换 其中一个图像，将所有的 1 向左，右，上，或下滑动任何数量的单位；然后把它放在另一个图像的上面。该转换的 重叠 是指两个图像 都 具有 1 的位置的数目。
 *
 * 请注意，转换 不包括 向任何方向旋转。越过矩阵边界的 1 都将被清除。
 *
 * 最大可能的重叠数量是多少？
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：img1 = [[1,1,0],[0,1,0],[0,1,0]], img2 = [[0,0,0],[0,1,1],[0,0,1]]
 * 输出：3
 * 解释：将 img1 向右移动 1 个单位，再向下移动 1 个单位。
 *
 * 两个图像都具有 1 的位置的数目是 3（用红色标识）。
 *
 * 示例 2：
 *
 * 输入：img1 = [[1]], img2 = [[1]]
 * 输出：1
 * 示例 3：
 *
 * 输入：img1 = [[0]], img2 = [[0]]
 * 输出：0
 * @Version 1.0
 */
public class imageoverlap {
    public static int largestOverlap(int[][] A, int[][] B) {
        Integer length = A.length;
        Integer max = 0;

        // 遍历所有偏移情况
        for (int offsetX = -A.length + 1; offsetX < length; offsetX++) {
            for (int offsetY = -A.length + 1; offsetY < length; offsetY++) {
                int count1 = 0;
                int count2 = 0;
                for (int i = 0; i + offsetX < length; i++) {
                    for (int j = 0; j + offsetY < length; j++) {
                        if (i < 0 || i >= length) continue;
                        if (j < 0 || j >= length) continue;
                        if (i + offsetX < 0 || i + offsetX >=length) continue;
                        if (j + offsetY < 0 || j + offsetY >=length) continue;
                        // 第二个矩阵B相对A向右偏移
                        if (A[i + offsetX][j + offsetY] == B[i][j] && B[i][j] == 1) count1++;

                        // 第二个矩阵B相对A向左偏移
                        // if (A[i][j] == B[i + offsetX][j + offsetY] && A[i][j] == 1) count2++;
                    }
                }
                System.out.println(count1 + " " + count2);
                max = Math.max(Math.max(count1, count2), max);
            }
        }
        return max;
    }
}