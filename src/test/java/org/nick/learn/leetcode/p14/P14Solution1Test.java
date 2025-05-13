package org.nick.learn.leetcode.p14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P14Solution1Test {
    P14Solution1 solution = new P14Solution1();


    @Test
    void longestCommonPrefix() {
        String[] strs = new String[]{
                "flower", "flower", "flower", "flower"
        };
        assertEquals("flower", solution.longestCommonPrefix(strs));
    }

    @Test
    void longestCommonPrefix1() {
        String[] strs = new String[]{
                "flower", "flow", "flight"
        };
        assertEquals("fl", solution.longestCommonPrefix(strs));
    }

}