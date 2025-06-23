package org.nick.learn.leetcode.p130;

public class P130Solution2 {
    int times;

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            dfs(board, n, m, i, 0); // 左边界
            dfs(board, n, m, i, m - 1); // 右边界
        }

        for (int j = 0; j < m; j++) {
            dfs(board, n, m, 0, j); // 上边界
            dfs(board, n, m, n - 1, j); // 下边界
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }


    }

    private void dfs(char[][] board, int n, int m, int i, int j) {
        times++;
        if (board[i][j] == 'O') {
            board[i][j] = 'A';
            if (i >= 1) {
                dfs(board, n, m, i - 1, j);
            }
            if (i <= n - 2) {
                dfs(board, n, m, i + 1, j);
            }
            if (j >= 1) {
                dfs(board, n, m, i, j - 1);
            }
            if (j <= m - 2) {
                dfs(board, n, m, i, j + 1);
            }
        }
    }

}
