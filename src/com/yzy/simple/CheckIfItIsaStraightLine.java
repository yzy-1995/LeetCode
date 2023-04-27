package com.yzy.simple;

/**
 * ClassName: CheckIfItIsaStraightLine
 * Description:
 * 给定一个数组 coordinates ，其中 coordinates[i] = [x, y] ，
 * [x, y] 表示横坐标为 x、纵坐标为 y 的点。请你来判断，这些点是否在该坐标系中属于同一条直线上。
 * 示例 1：
 *
 *
 *
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 * 示例 2：
 *
 *
 *
 * 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * 输出：false
 * @author Administrator
 * @date 2023-4-27 9:05
 */
public class CheckIfItIsaStraightLine {
    public static void main(String[] args) {

    }

    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        if (n <= 2) return true;

        int dx = coordinates[1][0] - coordinates[0][0];
        int dy = coordinates[1][1] - coordinates[0][1];

        for (int i = 2; i < n; i++) {
            int currDx = coordinates[i][0] - coordinates[i - 1][0];
            int currDy = coordinates[i][1] - coordinates[i - 1][1];

            if (dy * currDx != dx * currDy) {
                return false;
            }
        }

        return true;
    }
}
