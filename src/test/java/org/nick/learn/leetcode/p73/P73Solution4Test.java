package org.nick.learn.leetcode.p73;

import org.junit.jupiter.api.Test;

import static org.nick.learn.algorithm.utils.ArrayUtils.printMatrix;

class P73Solution4Test {
    P73Solution4 solution = new P73Solution4();

    @Test
    void setZeroes() {
        // [0,1,2,0],
        // [3,4,5,2],
        // [1,3,1,5]
        int[][] matrix = new int[][]{
                {1,1,2,3},
                {3,4,0,2},
                {1,3,1,5}
        };
        solution.setZeroes(matrix);;
        printMatrix(matrix);

    }
}