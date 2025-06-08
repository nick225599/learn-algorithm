package org.nick.learn.leetcode.p73;

public class P73Solution5 {
    // 单变量方案， 网友的好理解版本，好理解多了......
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        // 用一个 boolean 值单独记录第 0 列是否有 0
        boolean col0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0 = true;
            }
        }

        // 用 [0,0] 来单独记录第 0 行是否有 0
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                matrix[0][0] = 0;
            }
        }

        // 用第 0 行和第 0 列标记并处理其余的行跟列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 先处理第 0 行
        if (matrix[0][0] == 0) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        // 再处理第 0 列，顺序不能乱
        if (col0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
