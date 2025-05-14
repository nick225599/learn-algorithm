package org.nick.learn.leetcode.p28;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P28Solution1Test {
    P28Solution1 solution = new P28Solution1();

    @Test
    void strStr() {
        String haystack = "leetcode";
        String needle = "leeto";
        int i = solution.strStr(haystack, needle);
        assertEquals(-1, i);
    }

    @Test
    void strStr1() {
        String haystack = "mississippi";
        String needle = "issip";
        int i = solution.strStr(haystack, needle);
        assertEquals(4, i);
    }
}