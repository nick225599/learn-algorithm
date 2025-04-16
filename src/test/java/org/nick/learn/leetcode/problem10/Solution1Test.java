package org.nick.learn.leetcode.problem10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Solution1Test {

    Solution1 solution = new Solution1();

    @Test
    void isMatch() {
        String s = "aa";
        String p = "a";
        assertFalse(solution.isMatch(s, p));
    }

    @Test
    void isMatch2() {
        String s = "ab";
        String p = ".*";
        assertFalse(solution.isMatch(s, p));
    }

    //TODO 20250416 nick这段代码调试失败了，再看看
    @Test
    void isMatch3() {
        String s = "aa";
        String p = "a*";
        assertTrue(solution.isMatch(s, p));
    }
}