package org.nick.learn.leetcode.p202;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class P202Solution1Test {

    P202Solution1 solution = new P202Solution1();

    @Test
    void isHappy() {
        assertTrue(solution.isHappy(19));
    }
    @Test
    void isHappy1() {
        assertFalse(solution.isHappy(3));
    }
}