package org.nick.learn.leetcode.p32;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution7Test {
    Solution7 solution = new Solution7();

    @Test
    void longestValidParentheses() {
        String str = "(()";
        assertEquals(2, solution.longestValidParentheses(str));

        str = "())";
        assertEquals(2, solution.longestValidParentheses(str));

        str = "()(()";
        assertEquals(2, solution.longestValidParentheses(str));

        str = "()(())";
        assertEquals(6, solution.longestValidParentheses(str));
    }
}