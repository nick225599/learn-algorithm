package org.nick.learn.leetcode.p14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P14Solution2Test {

    P14Solution2 solution = new  P14Solution2();


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

    @Test
    void longestCommonPrefix2() {
        String[] strs = new String[]{
                "babb","caa"
        };
        assertEquals("", solution.longestCommonPrefix(strs));
    }

}