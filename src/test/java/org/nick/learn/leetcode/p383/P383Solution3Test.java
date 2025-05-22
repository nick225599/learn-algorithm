package org.nick.learn.leetcode.p383;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class P383Solution3Test {
    P383Solution3 solution = new P383Solution3();

    @Test
    void canConstruct() {
        String str1 = "aa";
        String str2 = "aab";
        assertTrue(solution.canConstruct(str1, str2));
        ;
    }
}