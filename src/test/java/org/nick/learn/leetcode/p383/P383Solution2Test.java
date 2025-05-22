package org.nick.learn.leetcode.p383;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P383Solution2Test {
    P383Solution2 solution = new P383Solution2();

    @Test
    void canConstruct() {
        String ransomNote = "aabcd";
        String magazine = "aabbcc";
        System.out.println(solution.canConstruct(ransomNote, magazine));
    }
}