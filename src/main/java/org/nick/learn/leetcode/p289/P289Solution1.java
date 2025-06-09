package org.nick.learn.leetcode.p289;

public class P289Solution1 {
    // 时间复杂度 O(mn)
    // 空间复杂度 O(mn)
    //有空间复杂度更低的方案，或者时间复杂度更低的方案吗？？
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] newBoard = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int liveNum = 0;
                if (i - 1 >= 0 && j - 1 >= 0) {
                    liveNum += (board[i - 1][j - 1] == 1) ? 1 : 0; // ↖
                }
                if (i - 1 >= 0) {
                    liveNum += (board[i - 1][j] == 1) ? 1 : 0;     // ↑
                }
                if (i - 1 >= 0 && j + 1 < m) {
                    liveNum += (board[i - 1][j + 1] == 1) ? 1 : 0; // ↗
                }
                if (j + 1 < m) {
                    liveNum += (board[i][j + 1] == 1) ? 1 : 0;     // →
                }
                if (i + 1 < n && j + 1 < m) {
                    liveNum += (board[i + 1][j + 1] == 1) ? 1 : 0; // ↘
                }
                if (i + 1 < n) {
                    liveNum += (board[i + 1][j] == 1) ? 1 : 0;     // ↓
                }
                if (i + 1 < n && j - 1 >= 0) {
                    liveNum += (board[i + 1][j - 1] == 1) ? 1 : 0; // ↙
                }
                if (j - 1 >= 0) {
                    liveNum += (board[i][j - 1] == 1) ? 1 : 0;     // ←
                }
                if (board[i][j] == 1) {
                    if (liveNum < 2) {
                        newBoard[i][j] = 0;
                    } else if (liveNum <= 3) {
                        newBoard[i][j] = 1;
                    } else {
                        newBoard[i][j] = 0;
                    }
                } else {
                    if (liveNum == 3) {
                        newBoard[i][j] = 1;
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] = newBoard[i][j];
            }
        }
    }
}
