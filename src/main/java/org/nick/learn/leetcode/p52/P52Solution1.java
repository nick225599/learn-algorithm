package org.nick.learn.leetcode.p52;

import java.util.Arrays;

public class P52Solution1 {
    int result;

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

        // 不放
        boolean[] newChessBoard1 = Arrays.copyOf(chessboard, chessboard.length);
        dfs(newChessBoard1, n, placeIndex + 1, count);

        // 放
        if (chessboard[placeIndex]) { // 已经被限制了，不能再放了
            return;
        }
        boolean[] newChessBoard2 = Arrays.copyOf(chessboard, chessboard.length);
        this.place(newChessBoard2, n, placeIndex);
        dfs(newChessBoard2, n, placeIndex + 1, count + 1);
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

    //    public static void main(String[] args) {
    //        int n = 5;
    //
    //        for(int i = 0; i < n * n; i++){
    //            boolean[] chessboard = new boolean[n * n];
    //            boolean[] newChessBoard = new P52Solution1().place(chessboard, n, i);
    //            printChessBoard(newChessBoard, n);
    //            System.out.println();
    //        }
    //
    //    }

    //    public static void printChessBoard(boolean[] chessBoard, int width) {
    //        StringBuilder sb = new StringBuilder();
    //        for (int i = 0; i < chessBoard.length; i++) {
    //            if (i % width == 0) {
    //                sb.append("\r\n");
    //            }
    //            sb.append(chessBoard[i] ? 1 : 0);
    //            sb.append(" ");
    //        }
    //        System.out.println(sb);
    //    }


}
