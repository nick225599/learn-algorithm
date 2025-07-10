package org.nick.learn.leetcode.p17;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P17Solution1Test {
    P17Solution1 solution = new P17Solution1();

    @Test
    void letterCombinations() {
        String digits = "23";
        List<String> result = solution.letterCombinations(digits);
        // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        assertEquals(9, result.size());
    }
}