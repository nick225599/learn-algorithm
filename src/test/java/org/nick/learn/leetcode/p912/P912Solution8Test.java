package org.nick.learn.leetcode.p912;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class P912Solution8Test {
    P912Solution8 solution = new P912Solution8();

    @Test
    void sortArray() {
        int[] arr = solution.sortArray(new int[]{5,2,3,1});
        solution.sortArray(arr);
        assertEquals("[1, 2, 3, 5]", Arrays.toString(arr));
    }
}