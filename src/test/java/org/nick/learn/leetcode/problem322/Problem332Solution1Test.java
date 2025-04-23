package org.nick.learn.leetcode.problem322;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem332Solution1Test {
    Problem332Solution1 solution = new Problem332Solution1();

    @Test
    void coinChange1() {
        int[] coins = new int[]{1, 2147483647};
        assertEquals(2, solution.coinChange(coins, 2));
    }

    @Test
    void coinChange2() {
        int[] coins = new int[]{1, 2, 5};
        assertEquals(20, solution.coinChange(coins, 100));
    }

    @Test
    void coinChange3() {
        int[] coins = new int[]{411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422};
        assertEquals(24, solution.coinChange(coins, 9864));
        assertEquals(24, new Problem332Solution2().coinChange(coins, 9864));
        assertEquals(24, new Problem332Solution3().coinChange(coins, 9864));
    }
}