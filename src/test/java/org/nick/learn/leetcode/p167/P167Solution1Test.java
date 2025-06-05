package org.nick.learn.leetcode.p167;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P167Solution1Test {
    P167Solution1 solution = new P167Solution1();

    @Test
    void twoSum() {
        assertEquals(
                Arrays.toString(new int[]{3, 5}),
                Arrays.toString(solution.twoSum(new int[]{-10, -8, -2, 1, 2, 5, 6}, 0))
        );
    }
}