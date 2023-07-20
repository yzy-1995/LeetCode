package com.yzy.mid;

import java.util.HashSet;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/19 01:19
 * @Description
 * 机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：
 *
 * -2 ：向左转 90 度
 * -1 ：向右转 90 度
 * 1 <= x <= 9 ：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。
 *
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。
 *
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）
 *
 *
 * 注意：
 *
 * 北表示 +Y 方向。
 * 东表示 +X 方向。
 * 南表示 -Y 方向。
 * 西表示 -X 方向。
 *
 *
 * 示例 1：
 *
 * 输入：commands = [4,-1,3], obstacles = []
 * 输出：25
 * 解释：
 * 机器人开始位于 (0, 0)：
 * 1. 向北移动 4 个单位，到达 (0, 4)
 * 2. 右转
 * 3. 向东移动 3 个单位，到达 (3, 4)
 * 距离原点最远的是 (3, 4) ，距离为 32 + 42 = 25
 * 示例 2：
 *
 * 输入：commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出：65
 * 解释：机器人开始位于 (0, 0)：
 * 1. 向北移动 4 个单位，到达 (0, 4)
 * 2. 右转
 * 3. 向东移动 1 个单位，然后被位于 (2, 4) 的障碍物阻挡，机器人停在 (1, 4)
 * 4. 左转
 * 5. 向北走 4 个单位，到达 (1, 8)
 * 距离原点最远的是 (1, 8) ，距离为 12 + 82 = 65
 * @Version 1.0
 */
public class WalkingRobotSimulation {
    private int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private HashSet<String> set;
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] position = new int[]{0, 0};
        set = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            int[] pos = obstacles[i];
            String p = pos[0] + "_" + pos[1];
            set.add(p);
        }
        int derc = 0;
        int max = 0;
        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case -1: {
                    derc = (derc + 1 ) % 4;
                    break;
                }
                case -2: {
                    derc = (derc - 1 + 4) % 4;
                    break;
                }
                default: {
                    walk(position, derc, commands[i]);
                }
            }
            max = Math.max(position[1] * position[1] + position[0] * position[0], max);
        }
        return max;
    }
    public void walk(int[] pos, int derc, int length) {
        int[] delta = dir[derc];
        while (length > 0) {
            pos[0] += delta[0];
            pos[1] += delta[1];
            if (set.contains(pos[0] + "_" + pos[1])) {
                pos[0] -= delta[0];
                pos[1] -= delta[1];
                break;
            }
            length--;
        }
    }
}