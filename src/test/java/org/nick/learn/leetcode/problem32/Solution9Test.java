package org.nick.learn.leetcode.problem32;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution9Test {
    Solution9 solution = new Solution9();

    @Test
    void longestValidParentheses() {
        String str = "(()";
        int result =  solution.longestValidParentheses(str);
        assertEquals(2, result);
    }
}