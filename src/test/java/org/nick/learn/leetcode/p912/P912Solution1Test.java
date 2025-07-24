package org.nick.learn.leetcode.p912;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P912Solution1Test {

    P912Solution1 solution = new P912Solution1();

    @Test
    void sortArray() {
        int[] arr = solution.sortArray(new int[]{5, 1, 1, 2, 0, 0});
        assertEquals("[0, 0, 1, 1, 2, 5]", Arrays.toString(arr));
    }
}