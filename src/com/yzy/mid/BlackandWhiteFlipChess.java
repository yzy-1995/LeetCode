package com.yzy.mid;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: BlackandWhiteFlipChess
 * Description:
 * 在 n*m 大小的棋盘中，有黑白两种棋子，黑棋记作字母 "X", 白棋记作字母 "O"，空余位置记作 "."。
 * 当落下的棋子与其他相同颜色的棋子在行、列或对角线完全包围（中间不存在空白位置）另一种颜色的棋子，则可以翻转这些棋子的颜色。
 * <p>
 * 「力扣挑战赛」黑白翻转棋项目中，将提供给选手一个未形成可翻转棋子的棋盘残局，其状态记作 chessboard。若下一步可放置一枚黑棋，请问选手最多能翻转多少枚白棋。
 * <p>
 * 注意：
 * <p>
 * 若翻转白棋成黑棋后，棋盘上仍存在可以翻转的白棋，将可以 继续 翻转白棋
 * 输入数据保证初始棋盘状态无可以翻转的棋子且存在空余位置
 * 示例 1：
 * <p>
 * 输入：chessboard = ["....X.","....X.","XOOO..","......","......"]
 * <p>
 * 输出：3
 * <p>
 * 解释： 可以选择下在 [2,4] 处，能够翻转白方三枚棋子。
 * <p>
 * 示例 2：
 * <p>
 * 输入：chessboard = [".X.",".O.","XO."]
 * <p>
 * 输出：2
 * <p>
 * 解释： 可以选择下在 [2,2] 处，能够翻转白方两枚棋子。
 * <p>
 * 示例 3：
 * <p>
 * 输入：chessboard = [".......",".......",".......","X......",".O.....","..O....","....OOX"]
 * <p>
 * 输出：4
 * <p>
 * 解释： 可以选择下在 [6,3] 处，能够翻转白方四枚棋子。
 *
 * @author Administrator
 * @date 2023-6-21 11:10
 */
public class BlackandWhiteFlipChess {

    private int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    private int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public int flipChess(String[] chessboard) {
        int m = chessboard.length, n = chessboard[0].length();
        int res = 0;
        char[][] temp = new char[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                temp[i][j] = chessboard[i].charAt(j);
            }
        }
        char[][] copy = new char[m][n];
        for (int i = 0; i < m; ++i) {
            copy[i] = Arrays.copyOf(temp[i], temp[i].length);
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (chessboard[i].charAt(j) == '.') {
                    res = Math.max(res, bfs(i, j, copy));
                }
                for (int k = 0; k < m; ++k) {
                    copy[k] = Arrays.copyOf(temp[k], temp[k].length);
                }
            }
        }
        return res;
    }

    public int bfs(int ix, int jy, char[][] chessboard) {
        Queue<int[]> q = new LinkedList<>();
        int m = chessboard.length, n = chessboard[0].length;
        int[] count = new int[8];
        q.offer(new int[]{ix, jy});
        int res = 0;
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int px = pos[0], py = pos[1];
            for (int i = 0; i < 8; ++i) {
                int cx = px + dx[i], cy = py + dy[i];
                int tcount = 0;
                while (cx >= 0 && cy >= 0 && cx < m && cy < n && chessboard[cx][cy] == 'O') {
                    tcount++;
                    cx += dx[i];
                    cy += dy[i];
                }
                if (cx < 0 || cy < 0 || cx >= m || cy >= n || chessboard[cx][cy] == '.') {
                    continue;
                }
                res += tcount;
                int tempx = px + dx[i], tempy = py + dy[i];
                while (tcount > 0) {
                    chessboard[tempx][tempy] = 'X';
                    q.add(new int[]{tempx, tempy});
                    tempx += dx[i];
                    tempy += dy[i];
                    tcount--;
                }
            }
        }
        return res;
    }
}
