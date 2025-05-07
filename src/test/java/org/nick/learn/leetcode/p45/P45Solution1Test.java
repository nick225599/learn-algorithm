package org.nick.learn.leetcode.p45;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P45Solution1Test {
    P45Solution1 solution = new P45Solution1();

    @Test
    void jump() {
        int[] nums = new int[]{2,3,1,1,4};
        int times = solution.jump(nums);
        assertEquals(2, times);
    }
}