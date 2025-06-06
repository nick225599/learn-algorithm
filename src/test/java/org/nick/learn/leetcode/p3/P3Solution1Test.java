package org.nick.learn.leetcode.p3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P3Solution1Test {
    P3Solution1 solution = new P3Solution1();

    @Test
    void lengthOfLongestSubstring() {
        assertEquals(2, solution.lengthOfLongestSubstring("aab"));
    }
}