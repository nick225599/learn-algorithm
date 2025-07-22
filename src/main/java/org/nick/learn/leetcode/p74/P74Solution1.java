package org.nick.learn.leetcode.p74;

public class P74Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[n - 1][m - 1]) {
            return false;
        }

        // 1. 先在行里找 target 在哪一行
        int i = (n - 1) >> 1;
        while (true) {
            if (matrix[i][0] < target) {
                if (matrix[i + 1][0] > target) {
                    // target 就在第 i 行
                    break;
                } else {
                    // target 在 [i, n - 1] 行
                    i = ((n - 1 - i) >> 1) + i;
                }
            } else {
                if (matrix[i][0] == target) {
                    // target 就在第 i 行
                    return true;
                } else {
                    // target 在 [0, i - 1] 行
                    i = (i - 1) >> 1;
                }
            }
        }

        System.out.println(target + " 在 m[" + i + "][] 中");


        // 2. 再在那一行的列里找 target 有没有
        int j = (m - 1) >> 1;
        while (true) {
            System.out.println("j: " + j);
            if (matrix[i][j] < target) {
                // target 在 [j + 1, m] 列
                j = ((j + 1 - m) >> 1) + (j + 1);
            } else if (matrix[i][j] > target) {
                // target 在 [0, j - 1] 列
                j = (j - 1) >> 1;
            } else {
                return true;
            }
        }

        //TODO nick 下午看下怎么退出死循环
    }
}
