package org.nick.learn.leetcode.p45;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P45Solution2Test {
    P45Solution2 solution = new P45Solution2();

    @Test
    void jump() {
        int[] nums = new int[]{2,3,1,1,4};
        int times = solution.jump(nums);
        assertEquals(2, times);
    }
}