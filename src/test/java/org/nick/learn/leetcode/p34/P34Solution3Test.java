package org.nick.learn.leetcode.p34;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class P34Solution3Test {

    P34Solution3 solution = new P34Solution3();

    @Test
    void searchRange() {
        int[] arr = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        assertEquals("[3, 4]", Arrays.toString(arr));
    }

    @Test
    void searchRange2() {
        int[] arr = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        assertEquals("[-1, -1]", Arrays.toString(arr));
    }

    @Test
    void searchRange3() {
        int[] arr = solution.searchRange(new int[]{5, 7, 7, 9, 9, 10}, 3);
        assertEquals("[-1, -1]", Arrays.toString(arr));
    }

    @Test
    void searchRange4() {
        int[] arr = solution.searchRange(new int[]{5, 7, 7, 9, 9, 10}, 11);
        assertEquals("[-1, -1]", Arrays.toString(arr));
    }
}