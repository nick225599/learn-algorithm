package org.nick.learn.leetcode.p130;

import java.util.Calendar;

public class P130Solution1 {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;


        char[][] up = new char[n][m]; // 上边界
        char[][] down = new char[n][m]; // 下边界
        char[][] left = new char[n][m]; // 左边界
        char[][] right = new char[n][m]; // 右边界
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = board[i][j];

                if (c == 'X') {
                    up[i][j] = down[i][j] = left[i][j] = right[i][j] = 'X';
                }
                if (c == 'O') {
                    up[i][j] = down[i - 1][j];
                    left[i][j] = right[i][j - 1];
                }


            }
        }

    }

}
