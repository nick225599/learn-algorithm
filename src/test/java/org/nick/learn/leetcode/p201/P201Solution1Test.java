package org.nick.learn.leetcode.p201;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P201Solution1Test {

    P201Solution1 solution = new P201Solution1();

    // Example 1:
    //Input: left = 5, right = 7
    //Output: 4
    @Test
    void rangeBitwiseAnd() {
     assertEquals(4, solution.rangeBitwiseAnd(5, 7));
    }


    //Example 2:
    //Input: left = 0, right = 0
    //Output: 0
    @Test
    void rangeBitwiseAnd2() {
        assertEquals(0, solution.rangeBitwiseAnd(0, 0));
    }
    //Example 3:
    //Input: left = 1, right = 2147483647
    //Output: 0
    @Test
    void rangeBitwiseAnd3() {
        int right = 2147483647;
        System.out.println(Integer.toBinaryString(right));
        assertEquals(0, solution.rangeBitwiseAnd(1, right));
    }

    @Test
    void rangeBitwiseAnd4() {
        assertEquals(0, solution.rangeBitwiseAnd(9, 16));
    }


}