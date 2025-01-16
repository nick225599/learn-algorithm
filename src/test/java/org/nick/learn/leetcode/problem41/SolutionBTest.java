package org.nick.learn.leetcode.problem41;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionBTest {
    SolutionB solution = new SolutionB();

    @Test
    void case1() {
        int[] nums = new int[]{1, 2, 0};
        assertEquals(3, solution.firstMissingPositive(nums));
    }

    @Test
    void case2() {
        int[] nums = new int[]{3, 4, -1, 1};
        assertEquals(2, solution.firstMissingPositive(nums));
    }

    @Test
    void case3() {
        int[] nums = new int[]{7, 8, 9, 11, 12};
        assertEquals(1, solution.firstMissingPositive(nums));
    }

    @Test
    void case8() {
        int[] nums = new int[]{2147483647};
        assertEquals(1, solution.firstMissingPositive(nums));
    }

    @Test
    void case9() {
        int[] nums = new int[]{2,2,2,3,3,3};
        assertEquals(1, solution.firstMissingPositive(nums));
    }

    @Test
    void case10() {
        int[] nums = new int[]{9,1,2,3,4,5,6,7,8};
        assertEquals(10, solution.firstMissingPositive(nums));
    }
}