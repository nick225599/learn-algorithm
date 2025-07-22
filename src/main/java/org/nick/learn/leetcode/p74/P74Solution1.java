package org.nick.learn.leetcode.p74;

public class P74Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rowNum = matrix.length;
        int columnNum = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[rowNum - 1][columnNum - 1]) {
            return false;
        }

        // 1. 先在行里找 target 在哪一行
        int midRow = rowNum >> 1;
        int targetRow = -1;
        while (true) {
            if (matrix[midRow][0] < target) {
                // target 在 [midRow, rowN - 1] 行
                if (matrix[midRow + 1][0] > target) {
                    targetRow = midRow;
                    break;
                } else {
                    midRow = ((rowNum - 1 - midRow) >> 1) + midRow;
                }
            } else if (matrix[midRow][0] > target) {
                // target 在 [0, midRow - 1] 行
                if (matrix[midRow - 1][0] <= target) {
                    targetRow = midRow - 1;
                    break;
                } else {
                    midRow = (midRow - 1) >> 1;
                }
            } else {
                return true;
            }
        }
        System.out.println("target 在第 " + targetRow + " 行");


        // 2. 再在那一行的列里找 target 有没有
        int midColumn = columnNum >> 1;
        boolean exist = false;
        while (true) {
            if (matrix[targetRow][midColumn] < target) {
                // target 在 [midColumn + 1, columnNum - 1] 列
                int tmpColumn = (columnNum - 1 - midColumn - 1) >> 1;
                if (tmpColumn == midColumn + 1) {
                    return false;
                } else {
                    midColumn = tmpColumn;
                }
            } else if (matrix[targetRow][midColumn] > target) {
                // target 在 [0, midColumn - 1] 列
                int tmpColumn = (midColumn - 1) >> 1;
                if (tmpColumn == 0) {
                    return false;
                } else {
                    midColumn = tmpColumn;
                }
            } else {
                return true;
            }
        }
    }
}
