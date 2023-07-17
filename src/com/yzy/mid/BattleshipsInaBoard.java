package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/15 20:00
 * @Description
 * 给你一个大小为 m x n 的矩阵 board 表示甲板，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，返回在甲板 board 上放置的 战舰 的数量。
 *
 * 战舰 只能水平或者垂直放置在 board 上。换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，其中 k 可以是任意大小。两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
 * 输出：2
 * 示例 2：
 *
 * 输入：board = [["."]]
 * 输出：0
 * @Version 1.0
 */
public class BattleshipsInaBoard {
    public int countBattleships(char[][] board) {
        // n 为 numsOfRow、 m 为 numsOfcols
        int n = board.length, m = board[0].length;
        // ans 为 返回的战舰数
        int ans = 0;
        // 遍历二位board数组：找寻战舰的头部：（这里将战舰靠近上侧、靠近左侧的的一个'X' 作为它的头）
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {

                if (board[i][j] == '.') continue;// 若遍历到的格子非'X'，则遍历下一个格子
                // 若为'X',但是非战舰头，则遍历下一个格子
                if (i > 0 && board[i - 1][j] == 'X') continue;
                if (j > 0 && board[i][j - 1] == 'X') continue;
                ans ++;
            }
        }
        return ans;
    }
}