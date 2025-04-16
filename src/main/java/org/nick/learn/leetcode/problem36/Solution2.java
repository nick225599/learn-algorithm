package org.nick.learn.leetcode.problem36;

public class Solution2 {

    // 用数组代替 Set
    public boolean isValidSudoku(char[][] board) {
        int[][] rowSet = new int[9][9];
        int[][] columnSet = new int[9][9];
        int[][] cellSet = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int index = board[i][j] - '0' - 1;

                if(rowSet[i][index] > 0){
                    return false;
                }
                rowSet[i][index]++;

                if(columnSet[j][index] > 0){
                    return false;
                }
                columnSet[j][index]++;

                int cellIndex = 3 * (i / 3) + j / 3;
                if(cellSet[cellIndex][index] > 0){
                    return false;
                }
                cellSet[cellIndex][index]++;
            }
        }
        return true;
    }

}
