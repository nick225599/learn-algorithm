package org.nick.learn.leetcode.p130;

public class P130Solution1 {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;


        // 上 从上往下看
        int upX = 0b1000;
        int upO = 0b0000;
        // 下 从下往上看
        int downX = 0b0100;
        int downO = 0b0000;
        // 左 从左往右看
        int leftX = 0b0010;
        int leftO = 0b0000;
        // 右 从右往左看
        int rightX = 0b0001;
        int rightO = 0b0000;

        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = board[i][j];

                tmp[i][j] = 0;

                if (c == 'X') {
                    tmp[i][j] = upX | downX | leftX | rightX;
                }
                if (c == 'O') {
                    tmp[i][j] = -1;
                    //TODO nick 写到这儿
                }


            }
        }

    }
}
