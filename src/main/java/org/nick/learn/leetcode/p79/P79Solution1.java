package org.nick.learn.leetcode.p79;

public class P79Solution1 {

    public boolean exist(char[][] board, String word) {
        int rowNum = board.length;
        int columnNum = board[0].length;
        for (int row = 0; row < rowNum; row++) {
            for (int column = 0; column < columnNum; column++) {
                if (dfs(board, word, row, column, 0, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int column, int wordIndex, int used) {
        if (row < 0 || row >= board.length) {
            return false;
        }
        if (column < 0 || column >= board[0].length) {
            return false;
        }
        if (this.isUsed(used, row, column, board.length)) {
            return false;
        }
        if (board[row][column] != word.charAt(wordIndex)) {
            return false;
        }
        if (wordIndex == word.length() - 1) {
            return true;
        }
        int newUsed = this.markUsed(used, row, column, board.length);
        return dfs(board, word, row - 1, column, wordIndex + 1, newUsed)
                || dfs(board, word, row + 1, column, wordIndex + 1, newUsed)
                || dfs(board, word, row, column - 1, wordIndex + 1, newUsed)
                || dfs(board, word, row, column + 1, wordIndex + 1, newUsed);
    }

    private boolean isUsed(int used, int row, int column, int width) {
        int bitIndex = row * width + column;
        int mask = 1 << bitIndex;
        return (used & mask) == 1;
    }

    private int markUsed(int used, int row, int column, int width) {
        int bitIndex = row * width + column;
        int mask = 1 << bitIndex;
        return used | mask;
    }
}
