package org.nick.learn.leetcode.p134;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P134Solution5Test {


    P134Solution5 solution = new P134Solution5();

    @Test
    void canCompleteCircuit() {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        int startIndex = solution.canCompleteCircuit(gas, cost);
        assertEquals(3, startIndex);
    }

    @Test
    void canCompleteCircuit2() {
        int[] gas = new int[]{5, 1, 2, 3, 4};
        int[] cost = new int[]{4, 4, 1, 5, 1};
        int startIndex = solution.canCompleteCircuit(gas, cost);
        assertEquals(4, startIndex);
    }

    @Test
    void canCompleteCircuit3() {
        int[] gas = new int[]{2, 3, 4};
        int[] cost = new int[]{3, 4, 3};
        int startIndex = solution.canCompleteCircuit(gas, cost);
        assertEquals(-1, startIndex);
    }
}