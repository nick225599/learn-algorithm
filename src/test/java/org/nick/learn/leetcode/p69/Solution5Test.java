package org.nick.learn.leetcode.p69;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution5Test {
    Solution5 solution = new Solution5();

    @Test
    void test1(){
        int i = 0;

        assertEquals(1, solution.mySqrt(1));
        System.out.println("ok" + ++i);

        assertEquals(2, solution.mySqrt(4));
        System.out.println("ok" + ++i);

        assertEquals(3, solution.mySqrt(9));
        System.out.println("ok" + ++i);

        assertEquals(4, solution.mySqrt(16));
        System.out.println("ok" + ++i);

        assertEquals(5, solution.mySqrt(25));
        System.out.println("ok" + ++i);

        assertEquals(6, solution.mySqrt(36));
        System.out.println("ok" + ++i);

        assertEquals(7, solution.mySqrt(49));
        System.out.println("ok" + ++i);

        assertEquals(8, solution.mySqrt(64));
        System.out.println("ok" + ++i);

        assertEquals(9, solution.mySqrt(81));
        System.out.println("ok" + ++i);

        assertEquals(10, solution.mySqrt(100));
        System.out.println("ok" + ++i);

        assertEquals(11, solution.mySqrt(121));
        System.out.println("ok" + ++i);

        assertEquals(12, solution.mySqrt(144));
        System.out.println("ok" + ++i);

        assertEquals(13, solution.mySqrt(169));
        System.out.println("ok" + ++i);
    }

}