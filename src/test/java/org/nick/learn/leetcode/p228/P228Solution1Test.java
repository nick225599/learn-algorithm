package org.nick.learn.leetcode.p228;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P228Solution1Test {
    P228Solution1 solution = new P228Solution1();

    @Test
    void summaryRanges() {
        int[] input = new int[]{0, 1, 2, 4, 5, 7};
        String output = "[0->2, 4->5, 7]";
        assertEquals(output, Arrays.toString(solution.summaryRanges(input).toArray()));
    }

    // [0,2,3,4,6,8,9]
    @Test
    void summaryRanges1() {
        int[] input = new int[]{0,2,3,4,6,8,9};
        String output = "[0, 2->4, 6, 8->9]";
        assertEquals(output, Arrays.toString(solution.summaryRanges(input).toArray()));
    }
}