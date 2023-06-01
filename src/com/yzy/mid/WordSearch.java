package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: WordSearch
 * Description:
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 *
 * @author Administrator
 * @date 2023-5-24 15:24
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, visited, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, boolean[][] visited, int row, int col, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;
        boolean found = search(board, visited, row + 1, col, word, index + 1)
                || search(board, visited, row - 1, col, word, index + 1)
                || search(board, visited, row, col + 1, word, index + 1)
                || search(board, visited, row, col - 1, word, index + 1);
        visited[row][col] = false;

        return found;
    }
}
