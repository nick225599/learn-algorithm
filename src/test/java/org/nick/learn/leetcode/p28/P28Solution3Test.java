package org.nick.learn.leetcode.p28;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P28Solution3Test {

    P28Solution3 solution = new P28Solution3();

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

    @Test
    void strStr2() {
        String haystack = "ababcaababcaabc";
        String needle = "ababcaabc";
        int i = solution.strStr(haystack, needle);
        assertEquals(6, i);
    }

    @Test
    void strStr3() {
        String haystack = "abaababcaabc";
        String needle = "ababcaabc";
        int i = solution.strStr(haystack, needle);
        assertEquals(3, i);
    }
}