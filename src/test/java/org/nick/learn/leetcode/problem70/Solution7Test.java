package org.nick.learn.leetcode.problem70;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.utils.ArrayUtils;

import static org.junit.jupiter.api.Assertions.*;

class Solution7Test {

    Solution7 solution = new Solution7();


    @Test
    void testClimbStairs(){
        assertEquals(1, solution.climbStairs(1));
        assertEquals(2, solution.climbStairs(2));
        assertEquals(3, solution.climbStairs(3));
        assertEquals(5, solution.climbStairs(4));
        assertEquals(8, solution.climbStairs(5));
        assertEquals(13, solution.climbStairs(6));
        assertEquals(21, solution.climbStairs(7));
        assertEquals(34, solution.climbStairs(8));
        assertEquals(55, solution.climbStairs(9));
        assertEquals(89, solution.climbStairs(10));

    }

    @Test
    void testMatrixMultiply(){
        int[][] a = new int[][]{
                {1,2,3},
                {4,5,6}
        };
        System.out.println("matrix a: ");
        ArrayUtils.printMatrix(a);
        System.out.println();

        int[][] b = new int[][]{
                {7,8},
                {9,10},
                {11,12}
        };
        System.out.println("matrix b: ");
        ArrayUtils.printMatrix(b);
        System.out.println();

        int[][] result = solution.matrixMultiply(a, b);
        System.out.println("matrix a * b: ");
        ArrayUtils.printMatrix(result);
        System.out.println();

    }

}