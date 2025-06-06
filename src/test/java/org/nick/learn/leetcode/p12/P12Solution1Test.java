package org.nick.learn.leetcode.p12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P12Solution1Test {

    P12Solution1 solution = new P12Solution1();

    @Test
    public void test() {
        assertEquals("LVIII", solution.intToRoman(58));
    }
}