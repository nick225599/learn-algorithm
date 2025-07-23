package org.nick.learn.leetcode.p153;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P153Solution1Test {
    P153Solution1 solution = new P153Solution1();

    @Test
    void findMin() {
        int ans = solution.findMin(new int[]{3, 4, 5, 1, 2});
        assertEquals(1, ans);
    }

    @Test
    void findMin2() {
        int ans = solution.findMin(new int[]{2,1});
        assertEquals(1, ans);
    }
}