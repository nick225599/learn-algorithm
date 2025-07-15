package org.nick.learn.leetcode.p52;

import java.util.Arrays;

public class P52Solution1 {
    int result;

    // 785ms 击败6%
    public int totalNQueens(int n) {
        if (n == 1) {
            return 1;
        }
        result = 0;
        boolean[] chessboard = new boolean[n * n];
        dfs(chessboard, n, 0, 0);
        return result;
    }

    private void dfs(boolean[] chessboard, int n, int placeIndex, int count) {
        if (count == n) {
            result++;
            return;
        }

        if (placeIndex >= chessboard.length) {
            return;
        }

        // 放
        if (!chessboard[placeIndex]) {
            boolean[] newChessBoard = Arrays.copyOf(chessboard, chessboard.length);
            this.place(newChessBoard, n, placeIndex);
            dfs(newChessBoard, n, placeIndex + 1, count + 1);
        }

        // 不放
        dfs(chessboard, n, placeIndex + 1, count);
    }

    void place(boolean[] chessboard, int n, int placeIndex) {
        // 上下左右
        for (int i = 0; i < chessboard.length; i++) {
            if (i % n == placeIndex % n) {
                chessboard[i] = true;
            }
            if (i / n == placeIndex / n) {
                chessboard[i] = true;
            }
        }
        // 左上
        for (int i = placeIndex; i >= 0 && i % n <= placeIndex % n; ) {
            chessboard[i] = true;
            i -= (n + 1);
        }
        // 左下
        for (int i = placeIndex; i < chessboard.length && i % n <= placeIndex % n; ) {
            chessboard[i] = true;
            i += (n - 1);
        }
        //  右上
        for (int i = placeIndex; i >= 0 && i % n >= placeIndex % n; ) {
            chessboard[i] = true;
            i -= (n - 1);

        }
        // 右下
        for (int i = placeIndex; i < chessboard.length && i % n >= placeIndex % n; ) {
            chessboard[i] = true;
            i += (n + 1);
        }
    }
}
