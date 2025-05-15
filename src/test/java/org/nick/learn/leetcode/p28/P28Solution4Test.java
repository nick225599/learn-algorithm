package org.nick.learn.leetcode.p28;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class P28Solution4Test {

    P28Solution4 solution = new P28Solution4();

    @Test
    void strStr() {
        String haystack = "aaacaaaa";
        String needle = "aaaa";
        Assertions.assertEquals(4, solution.strStr(haystack, needle));
    }

    @Test
    void strStr2() {
        String haystack = "acab";
        String needle = "ab";
        Assertions.assertEquals(2, solution.strStr(haystack, needle));
    }


    @Test
    void strStr3() {
        String haystack = "aaaaaaaaaaaaaaaa";
        String needle = "baaa";
        Assertions.assertEquals(-1, solution.strStr(haystack, needle));
    }

    @Test
    void strStr4() {
        String haystack = "ababbbbaaabbbaaa";
        String needle = "baaa";
        Assertions.assertEquals(6, solution.strStr(haystack, needle));
    }

    @Test
    void strStr5() {
        String haystack = "aabc";
        String needle = "abc";
        Assertions.assertEquals(1, solution.strStr(haystack, needle));
    }

    @Test
    void strStr6() {
        String haystack = "ababbbbaaabbbaaa";
        String needle = "bbbb";
        Assertions.assertEquals(3, solution.strStr(haystack, needle));
    }

    @Test
    void strStr7() {
        String haystack = "aaabaaa";
        String needle = "baaa";
        Assertions.assertEquals(3, solution.strStr(haystack, needle));
    }

}