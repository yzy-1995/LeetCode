package com.yzy.simple;

/**
 * ClassName: UAVSquareArray
 * Description:
 * 在 「力扣挑战赛」 开幕式的压轴节目 「无人机方阵」中，每一架无人机展示一种灯光颜色。 无人机方阵通过两种操作进行颜色图案变换：
 * <p>
 * 调整无人机的位置布局
 * 切换无人机展示的灯光颜色
 * 给定两个大小均为 N*M 的二维数组 source 和 target 表示无人机方阵表演的两种颜色图案，由于无人机切换灯光颜色的耗能很大，
 * 请返回从 source 到 target 最少需要多少架无人机切换灯光颜色。
 * <p>
 * 注意： 调整无人机的位置布局时无人机的位置可以随意变动。
 * <p>
 * 示例 1：
 * <p>
 * 输入：source = [[1,3],[5,4]], target = [[3,1],[6,5]]
 * <p>
 * 输出：1
 * <p>
 * 解释： 最佳方案为 将 [0,1] 处的无人机移动至 [0,0] 处； 将 [0,0] 处的无人机移动至 [0,1] 处；
 * 将 [1,0] 处的无人机移动至 [1,1] 处； 将 [1,1] 处的无人机移动至 [1,0] 处，其灯光颜色切换为颜色编号为 6 的灯光；
 * 因此从source 到 target 所需要的最少灯光切换次数为 1。
 *
 * @author Administrator
 * @date 2023-3-27 17:18
 */
public class UAVSquareArray {
    public static void main(String[] args) {

    }

    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        int m = source.length;
        int n = source[0].length;
        int[] cnt = new int[10001];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ++cnt[source[i][j]];
            }
        }
        int num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cnt[target[i][j]]-- > 0) {
                    ++num;
                }
            }
        }
        return m * n - num;
    }
}
