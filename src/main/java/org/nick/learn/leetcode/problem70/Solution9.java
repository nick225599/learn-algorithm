package org.nick.learn.leetcode.problem70;

public class Solution9 {

    // 矩阵快速幂解法，迭代代替递归
    // 时间复杂度 O(logn)
    // 空间复杂度 O(1)
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        // [ f(n), f(n - 1) ] = [ f(2), f(1) ] * [ 1, 1 ] ^ (n - 2)
        //                                       [ 1, 0 ]
        int[][] tmp = matrixPow(new int[][]{{1, 1}, {1, 0}}, n - 2);
        int[][] result = matrixMultiply(new int[][]{{2, 1}}, tmp);
        return result[0][0];
    }

//    public int[][] matrixPow(int[][] m, int power) {
//        if(power == 1){
//            return m;
//        }
//        int[][] result;
//        if (power % 2 == 0) {
//            int[][] tmp = matrixPow(m, power / 2);
//            result = matrixMultiply(tmp, tmp);
//        } else {
//            int[][] tmp = matrixPow(m, (power - 1) / 2);
//            result = matrixMultiply(tmp, tmp);
//            result = matrixMultiply(result, m);
//        }
//        return result;
//    }

    //TODO nick 20250228 回去再说把
    public int[][] pow(int[][] a, int power) {

        int[][] ret = {{1, 0}, {0, 1}};
        int n = power;
        int[][] base = a;

        while (n > 0) {
            if ((n & 1) == 1) { // 奇数
                ret = matrixMultiply(ret, base);
            }
            n >>= 1;
            base = matrixMultiply(base, base);
        }
        return ret;
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
