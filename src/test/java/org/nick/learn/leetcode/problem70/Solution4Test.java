package org.nick.learn.leetcode.problem70;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution4Test {

    Solution4 solution = new Solution4();

    @Test
    public void test1() {
        assertEquals(2, solution.climbStairs(2));
    }

    @Test
    public void test2() {
        assertEquals(3, solution.climbStairs(3));
    }

    @Test
    public void test21() {
        // 1134903170
        // 701408733
        // 1402817465
        System.out.println(solution.climbStairs(44));

        // 1134903170
        // 701408733
        // 1402817465
    }


}