package org.nick.learn.leetcode.problem32;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution4Test {
    Solution4 solution = new Solution4();

    @Test
    void longestValidParentheses() {
        String str = "(()";
        assertEquals(2, solution.longestValidParentheses(str));

        str = "())";
        assertEquals(2, solution.longestValidParentheses(str));

        str = "()(())";
        assertEquals(6, solution.longestValidParentheses(str));

    }
}