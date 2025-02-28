package org.nick.learn.leetcode.problem70;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution9Test {
    Solution9 solution = new Solution9();


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
}