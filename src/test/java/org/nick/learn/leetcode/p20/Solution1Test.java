package org.nick.learn.leetcode.p20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Solution1Test {
    Solution1 solution = new Solution1();
    @Test
    public void test() {
        String str = "()";
        assertTrue(solution.isValid(str));
    }
}