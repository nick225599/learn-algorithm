package org.nick.learn.leetcode.problem70;

public class Solution7 {

    // 矩阵乘法
    // 时间复杂度 O(n)
    // 空间复杂度 O(1)
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        // [ f(n), f(n - 1) ] = [ f(1), f(2) ] * [ 1, 1 ] ^ (n - 1)
        //                                       [ 1, 0 ]
        int[][] result = new int[][]{{1, 0}, {0, 1}};
        int[][] tmpArr = new int[][]{{1, 1}, {1, 0}};
        for (int i = 1; i <= n - 2; i++) {
            result = matrixMultiply(result, tmpArr);
        }
        result = matrixMultiply(new int[][]{{2, 1}}, result);

        return result[0][0];
    }

    public int[][] matrixMultiply(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int columnsA = matrixA[0].length;

        int rowsB = matrixB.length;
        int columnsB = matrixB[0].length;

        if (columnsA != rowsB) {
            throw new IllegalArgumentException();
        }

        int[][] result = new int[rowsA][columnsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < columnsB; j++) {
                result[i][j] = 0;
                for (int k = 0; k < columnsA; k++) {
                    result[i][j] += (matrixA[i][k] * matrixB[k][j]);
                }
            }
        }

        return result;
    }
    //TODO 看看怎么通过分块矩阵乘法实现
    //TODO AI 查一下矩阵幂等怎么更快速地求解
    //TODO 再看看官方题解怎么写的
}
