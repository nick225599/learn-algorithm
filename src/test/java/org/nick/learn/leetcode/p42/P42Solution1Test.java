package org.nick.learn.leetcode.p42;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P42Solution1Test {
    P42Solution1 solution = new P42Solution1();
    @Test
    void trap() {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        assertEquals(6, solution.trap(height));
    }
}