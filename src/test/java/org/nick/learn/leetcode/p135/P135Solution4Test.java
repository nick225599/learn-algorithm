package org.nick.learn.leetcode.p135;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P135Solution4Test {
    P135Solution4 solution = new P135Solution4();

    @Test
    void candy() {
        int[] ratings = new int[]{1, 3, 2, 2, 1};
        int sum = solution.candy(ratings);
        assertEquals(7, sum);
    }

    @Test
    void candy2() {
        int[] ratings = new int[]{1,2,87,87,87,2,1};
        int sum = solution.candy(ratings);
        assertEquals(13, sum);
    }

}