package org.nick.learn.leetcode.p30;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P30Solution1Test {
    P30Solution1 solution = new P30Solution1();
    @Test
    void findSubstring() {
        String[] words = new String[]{"foo", "bar"};
        solution.findSubstring("barfoothefoobarman", words);
    }
}