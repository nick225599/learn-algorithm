package org.nick.learn.leetcode.problem36;

import java.util.HashSet;

public class Solution1 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rowSet = new HashSet[9];
        HashSet<Character>[] columnSet = new HashSet[9];
        HashSet<Character>[] cellSet = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>(9);
            columnSet[i] = new HashSet<>(9);
            cellSet[i] = new HashSet<>(9);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (!rowSet[i].add(board[i][j])) {
                    return false;
                }
                if (!columnSet[j].add(board[i][j])) {
                    return false;
                }
                int index = 3 * (i / 3) + j / 3;
                if (!cellSet[index].add(board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
