package org.nick.learn.leetcode.p289;

public class P289Solution2 {
    // 时间复杂度 O(mn)
    // 空间复杂度 O(1)
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int liveNum = 0;
                if (i - 1 >= 0 && j - 1 >= 0) {
                    liveNum += (this.isLive(board, i - 1, j - 1)) ? 1 : 0; // ↖
                }
                if (i - 1 >= 0) {
                    liveNum += (this.isLive(board, i - 1, j)) ? 1 : 0;     // ↑
                }
                if (i - 1 >= 0 && j + 1 < m) {
                    liveNum += (this.isLive(board, i - 1, j + 1)) ? 1 : 0; // ↗
                }
                if (j + 1 < m) {
                    liveNum += (this.isLive(board, i, j + 1)) ? 1 : 0;     // →
                }
                if (i + 1 < n && j + 1 < m) {
                    liveNum += (this.isLive(board, i + 1, j + 1)) ? 1 : 0; // ↘
                }
                if (i + 1 < n) {
                    liveNum += (this.isLive(board, i + 1, j)) ? 1 : 0;     // ↓
                }
                if (i + 1 < n && j - 1 >= 0) {
                    liveNum += (this.isLive(board, i + 1, j - 1)) ? 1 : 0; // ↙
                }
                if (j - 1 >= 0) {
                    liveNum += (this.isLive(board, i, j - 1)) ? 1 : 0;     // ←
                }
                if (board[i][j] == 1) {
                    if (liveNum < 2) {
                        board[i][j] =  board[i][j];
                    } else if (liveNum <= 3) {
                        board[i][j] = 0b10 | board[i][j];
                    } else {
                        board[i][j] =  board[i][j];
                    }
                } else {
                    if (liveNum == 3) {
                        board[i][j] =  0b10  | board[i][j];
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] = board[i][j] >> 1;
            }
        }
    }

    public boolean isLive(int[][] board, int i, int j) {
        return (board[i][j] ^ (board[i][j] >> 1 << 1)) == 1;
    }

}
