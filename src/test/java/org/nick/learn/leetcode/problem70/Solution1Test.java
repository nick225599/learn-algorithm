package org.nick.learn.leetcode.problem70;

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
        System.out.println(solution.climbStairs(1));
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs(4));
        System.out.println(solution.climbStairs(5));
        System.out.println(solution.climbStairs(6));
        System.out.println();

        System.out.println(solution.climbStairs(44));
    }

}