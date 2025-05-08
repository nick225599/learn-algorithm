package org.nick.learn.leetcode.p134;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P134Solution2Test {

    P134Solution2 solution = new P134Solution2();

    @Test
    void canCompleteCircuit() {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        int startIndex = solution.canCompleteCircuit(gas, cost);
        assertEquals(3, startIndex);
    }
}