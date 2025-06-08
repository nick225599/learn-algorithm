package org.nick.learn.leetcode.p73;

public class P73Solution4 {
    // 尝试单变量方案
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean b = false;
        for (int i = 0; i < n; i++) {
            b = b || matrix[i][0] == 0;
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        //TODO nick 第一行还是处理不好，咋整？
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (b) {
                matrix[i][0] = 0;
            }
        }
    }

}
