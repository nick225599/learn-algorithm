package org.nick.learn.leetcode.problem32;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1Test {
    Solution1 solution = new Solution1();
    Solution2 solution = new Solution2();
    Solution3 solution = new Solution3();
    Solution4 solution = new Solution4();
    Solution5 solution = new Solution5();
    @Test
    public void test(){
        String str = "(()";
        assertEquals(2, solution.longestValidParentheses(str));

        str = "())";
        assertEquals(2, solution.longestValidParentheses(str));

        str = "()(())";
        assertEquals(6, solution.longestValidParentheses(str));

    }

}