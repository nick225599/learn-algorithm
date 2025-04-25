package org.nick.learn.leetcode.p70;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution6Test {

    Solution6 solution = new Solution6();

    @Test
    public void test2(){
        assertEquals(2, solution.climbStairs(2));
    }


    @Test
    public void test3(){
        assertEquals(3, solution.climbStairs(3));
    }

    @Test
    public void test4(){
        assertEquals(5, solution.climbStairs(4));
    }

    @Test
    public void test6(){
        assertEquals(13, solution.climbStairs(6));
    }


}