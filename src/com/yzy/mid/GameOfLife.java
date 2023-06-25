package com.yzy.mid;

/**
 * ClassName: GameOfLife
 * Description:
 * 根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：
 * 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 *
 * 示例 1：
 *
 * 输入：board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 * 输出：[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 * 示例 2：
 *
 * 输入：board = [[1,1],[1,0]]
 * 输出：[[1,1],[1,1]]
 * @author Administrator
 * @date 2023-6-21 10:16
 */
public class GameOfLife {

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                changeLife(board,i,j,res,m,n);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]=res[i][j];
            }
        }
    }

    private void changeLife(int[][] board, int i, int j, int[][] res, int m, int n) {
        int life = 0 ;
        //上方
        if(i>0 && board[i-1][j]==1) life++;
        //下方
        if(i<m-1 && board[i+1][j]==1) life++;
        //左上方
        if(i>0&&j>0 && board[i-1][j-1]==1) life++;
        //右上方
        if(i>0 && j<n-1 && board[i-1][j+1]==1) life++;
        //左下方
        if(i<m-1 && j>0 && board[i+1][j-1]==1) life++;
        //右下方
        if(i<m-1 && j<n-1&& board[i+1][j+1]==1) life++;
        //左方
        if(j>0 && board[i][j-1]==1) life++;
        //右方
        if(j<n-1 && board[i][j+1]==1) life++;

        if (life<2) res[i][j]=0;
        else if (life==2) res[i][j]=board[i][j];
        else if (life==3) res[i][j]=1;
        else if (life>3) res[i][j]=0;
    }


}
