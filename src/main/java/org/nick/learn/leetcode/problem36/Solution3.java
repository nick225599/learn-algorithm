package org.nick.learn.leetcode.problem36;

public class Solution3 {

    // 用位运算
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;

        int[] maskCol = new int[n];
        int[] maskRow = new int[n];
        int numGrid = (n / 3) * (n /3);
        int[] maskGrid = new int[numGrid];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    int mask = 1 << num;
                    int gridIdx = (i / 3) + 3 * (j / 3);
                    if ((mask & maskCol[j]) != 0 || (mask & maskRow[i]) != 0 || (mask & maskGrid[gridIdx]) != 0) {
                        return false;
                    }
                    maskCol[j] |= mask;
                    maskRow[i] |= mask;
                    maskGrid[gridIdx] |= mask;
                }
            }
        }
        return true;
    }

}
