package org.nick.learn.leetcode.p70;

import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution9Test {
    Solution9 solution = new Solution9();

    @Test
    void testClimbStairs() {
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
    void test2() throws OperationNotSupportedException {
        for (int i = 0; i < 1000; i++) {
            Random r = new Random();
            int num1 = r.nextInt(10);
            int num2 = r.nextInt(10);
            System.out.println("num1: " + num1 + ", num2: " + num2);
            double num3 = Math.pow(num1, num2);
            assertEquals(num3, solution.fastPowBase10(num1, num2));
            assertEquals(num3, solution.fastPowBase2(num1, num2));
        }
    }


}