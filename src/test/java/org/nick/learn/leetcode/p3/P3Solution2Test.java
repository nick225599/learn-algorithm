package org.nick.learn.leetcode.p3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P3Solution2Test {
    P3Solution2  solution = new P3Solution2();

    @Test
    void lengthOfLongestSubstring() {
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    void lengthOfLongestSubstring2() {
        assertEquals(3, solution.lengthOfLongestSubstring("aabc"));
    }
}