package com.yzy.mid;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/02/21 00:06
 * @Description
 * 给你一个 m x n 的迷宫矩阵 maze （下标从 0 开始），矩阵中有空格子（用 '.' 表示）和墙（用 '+' 表示）。同时给你迷宫的入口 entrance ，用 entrance = [entrancerow, entrancecol] 表示你一开始所在格子的行和列。
 *
 * 每一步操作，你可以往 上，下，左 或者 右 移动一个格子。你不能进入墙所在的格子，你也不能离开迷宫。你的目标是找到离 entrance 最近 的出口。出口 的含义是 maze 边界 上的 空格子。entrance 格子 不算 出口。
 *
 * 请你返回从 entrance 到最近出口的最短路径的 步数 ，如果不存在这样的路径，请你返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
 * 输出：1
 * 解释：总共有 3 个出口，分别位于 (1,0)，(0,2) 和 (2,3) 。
 * 一开始，你在入口格子 (1,2) 处。
 * - 你可以往左移动 2 步到达 (1,0) 。
 * - 你可以往上移动 1 步到达 (0,2) 。
 * 从入口处没法到达 (2,3) 。
 * 所以，最近的出口是 (0,2) ，距离为 1 步。
 * 示例 2：
 *
 *
 * 输入：maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
 * 输出：2
 * 解释：迷宫中只有 1 个出口，在 (1,2) 处。
 * (1,0) 不算出口，因为它是入口格子。
 * 初始时，你在入口与格子 (1,0) 处。
 * - 你可以往右移动 2 步到达 (1,2) 处。
 * 所以，最近的出口为 (1,2) ，距离为 2 步。
 * 示例 3：
 *
 *
 * 输入：maze = [[".","+"]], entrance = [0,0]
 * 输出：-1
 * 解释：这个迷宫中没有出口。
 * @Version 1.0
 */
public class nearestexitfromentranceinmaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int rows = maze.length;
        int cols = maze[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] poll = queue.poll();
                if (level != 0 && (poll[0] == 0 || poll[1] == 0
                        || poll[0] == rows - 1 || poll[1] == cols - 1)) {
                    return level;
                }
                for (int[] dir : dirs) {
                    int x = poll[0] + dir[0];
                    int y = poll[1] + dir[1];
                    if (x < 0 || x >= rows || y < 0 || y >= cols) continue;
                    if (maze[x][y] == '+') continue;
                    queue.add(new int[]{x, y});
                    maze[x][y] = '+';
                }
            }
            level++;
        }
        return -1;
    }
}