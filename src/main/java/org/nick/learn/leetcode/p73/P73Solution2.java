package org.nick.learn.leetcode.p73;

public class P73Solution2 {

    // an in-place solution
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;


        // 第 0 行是否需要全设置为 0
        boolean b1 = false;
        for (int j = 0; !b1 && j < m; j++) {
            b1 = matrix[0][j] == 0;
        }

        // 第 0 列是否需要全设置为 0
        boolean b2 = false;
        for (int i = 0; !b2 && i < n; i++) {
            b2 = matrix[i][0] == 0;
        }

        // 将第 0 行和第 0 列作为标记，处理第 1~n 行 1~m 列
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 最后处理第 0 行和第 0 列
        if (b1) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
        if (b2) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
