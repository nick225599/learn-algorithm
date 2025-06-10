package org.nick.learn.leetcode.p71;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P71Solution2Test {
    P71Solution2 solution = new P71Solution2();

    @Test
    void simplifyPath() {
        assertEquals("/home", solution.simplifyPath("/home/"));
    }

    @Test
    void simplifyPath2() {
        assertEquals("/", solution.simplifyPath("/../"));
    }

    @Test
    void simplifyPath3() {
        assertEquals("/home/user/Pictures", solution.simplifyPath("/home/user/Documents/../Pictures"));
    }

    @Test
    void simplifyPath4() {
        assertEquals("/c", solution.simplifyPath("/a/../../b/../c//.//"));
    }
}