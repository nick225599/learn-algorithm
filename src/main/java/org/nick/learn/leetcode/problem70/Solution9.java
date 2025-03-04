package org.nick.learn.leetcode.problem70;

import javax.naming.OperationNotSupportedException;

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

    // 矩阵快速幂
    public int[][] matrixPow(int[][] a, int power) {
        int[][] result = new int[][]{{1, 0}, {0, 1}};
        while (true) {
            if (power % 2 != 0) {
                result = matrixMultiply(result, a);
            }
            power >>= 1;
            if (power <= 0) {
                break;
            }
            a = matrixMultiply(a, a);
        }
        return result;
    }

    // 矩阵乘法
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

    /**
     * a^b = a ^ (k0 * 10^0 + k1 * 10^1 + k2 * 10^2 + .... kn * 10^n)
     *
     * @return a^b
     */
    public int fastPowBase10(int a, int b) throws OperationNotSupportedException {
        if (0 > b) {
            throw new OperationNotSupportedException();
        }
        if (0 == b) {
            return 1;
        }

        int numA = a;
        int numB = b;

        int result = 1;
        int base = numA;
        while (numB > 0) {
            int tmp = numB % 10;
            switch (tmp) {
                case 0 -> {
                    result *= (1);
                }
                case 1 -> {
                    result *= (base);
                }
                case 2 -> {
                    result *= (base * base);
                }
                case 3 -> {
                    result *= (base * base * base);
                }
                case 4 -> {
                    result *= (base * base * base * base);
                }
                case 5 -> {
                    result *= (base * base * base * base * base);
                }
                case 6 -> {
                    result *= (base * base * base * base * base * base);
                }
                case 7 -> {
                    result *= (base * base * base * base * base * base * base);
                }
                case 8 -> {
                    result *= (base * base * base * base * base * base * base * base);
                }
                case 9 -> {
                    result *= (base * base * base * base * base * base * base * base * base);
                }
            }

            base = base * base * base * base * base * base * base * base * base * base;
            numB = numB / 10;
        }

        return result;
    }

    public int fastPowBase2(int a, int b) throws OperationNotSupportedException {
        if (0 > b) {
            throw new OperationNotSupportedException();
        }
        if (0 == b) {
            return 1;
        }
        int result = 1;
        while (true) {
            if (b % 2 != 0) {
                result *= a;
            }
            b >>= 1;
            if (b <= 0) {
                break;
            }
            a *= a;
        }
        return result;
    }

}
