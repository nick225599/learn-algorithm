package org.nick.learn.leetcode.p912;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P912Solution10Test {
    P912Solution10 solution = new P912Solution10();

    @Test
    void sortArray() {
        int[] arr = new int[]{1, 2, 3, 4};
        solution.sortArray(arr);
        assertEquals("[1, 2, 3, 4]", Arrays.toString(arr));
    }

    @Test
    void sortArray1() {
        int[] arr = new int[]{4, 3, 2, 1};
        solution.sortArray(arr);
        assertEquals("[1, 2, 3, 4]", Arrays.toString(arr));
    }

    @Test
    void sortArray2() {
        int[] arr = new int[]{2, 2, 2, 2};
        solution.sortArray(arr);
        assertEquals("[2, 2, 2, 2]", Arrays.toString(arr));
    }

    @Test
    void sortArray3() {
        int[] arr = new int[]{1, 2};
        solution.sortArray(arr);
        assertEquals("[1, 2]", Arrays.toString(arr));
    }
}