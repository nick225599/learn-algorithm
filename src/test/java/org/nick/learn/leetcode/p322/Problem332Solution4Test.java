package org.nick.learn.leetcode.p322;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem332Solution4Test {
    Problem332Solution4 solution = new Problem332Solution4();

    @Test
    void coinChange1() {
        int[] coins = new int[]{2};
        int amount = 3;
        assertEquals(-1, solution.coinChange(coins, amount));
    }

    @Test
    void coinChange2() {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        assertEquals(3, solution.coinChange(coins, amount));
    }
}