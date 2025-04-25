package org.nick.learn.leetcode.p70;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1Test {

    Solution1 solution = new Solution1();

    @Test
    public void test1(){
        assertEquals(2, solution.climbStairs(2));
    }

    @Test
    public void test2(){
        assertEquals(3, solution.climbStairs(3));
    }

    @Test
    public void test21(){
        System.out.println(solution.climbStairs(44));
    }

}