package org.nick.learn.leetcode.p67;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P67Solution1Test {

    P67Solution1 solution = new P67Solution1();

    @Test
    void addBinary() {
        assertEquals("1011", solution.addBinary("100", "111"));
    }
}