package org.nick.learn.leetcode.problem322;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem332Solution1Test {
    Problem332Solution1 solution = new Problem332Solution1();

    @Test
    void coinChange() {
        int[] coins = new int[]{1, 2147483647};
        assertEquals(2, solution.coinChange(coins, 2));
    }
}