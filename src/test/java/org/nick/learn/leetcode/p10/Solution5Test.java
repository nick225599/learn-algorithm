package org.nick.learn.leetcode.p10;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class Solution5Test {

    Solution5 solution = new Solution5();

    @Test
    void isMatch1() {
        String s = "aa";
        String p = "a";
        assertEquals(Pattern.matches(p, s), solution.isMatch(s, p));
    }

    @Test
    void isMatch2() {
        String s = "ab";
        String p = ".*";
        assertEquals(Pattern.matches(p, s), solution.isMatch(s, p));
    }

    @Test
    void isMatch3() {
        String s = "aa";
        String p = "a*";
        assertEquals(Pattern.matches(p, s), solution.isMatch(s, p));
    }

    @Test
    void isMatch4() {
        String s = "aab";
        String p = "c*a*b";
        assertEquals(Pattern.matches(p, s), solution.isMatch(s, p));
    }

    @Test
    void isMatch5() {
        String s = "ab";
        String p = ".*c";
        assertEquals(Pattern.matches(p, s), solution.isMatch(s, p));
    }

    // nick 20250417 自己穷举的写法无法处理这种需要回溯处理的情况
    @Test
    void isMatch6() {
        String s = "aaa";
        String p = "a*a";
        assertEquals(Pattern.matches(p, s), solution.isMatch(s, p));
    }
}