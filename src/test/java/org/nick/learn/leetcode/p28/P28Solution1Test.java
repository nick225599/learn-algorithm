package org.nick.learn.leetcode.p28;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P28Solution1Test {
    P28Solution1 solution = new P28Solution1();

    @Test
    void removeDuplicates() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        assertEquals(5, solution.removeDuplicates(nums));
        assertEquals("[1, 1, 2, 2, 3, 3]", Arrays.toString(nums));
    }

    @Test
    void removeDuplicates1() {
        int[] nums = new int[]{1, 2};
        assertEquals(2, solution.removeDuplicates(nums));
        assertEquals("[1, 2]", Arrays.toString(nums));
    }
}