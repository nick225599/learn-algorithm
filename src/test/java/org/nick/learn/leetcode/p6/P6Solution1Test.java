package org.nick.learn.leetcode.p6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P6Solution1Test {
    P6Solution1 solution = new P6Solution1();


    @Test
    public void test(){
        assertEquals("A", solution.convert("A", 1));
    }

    // PAYPALISHIRING

    // P   A   H   N
    // A P L S I I G
    // Y   I   R

    // PAHN APLSIIG YIR
    @Test
    public void test2(){
        assertEquals("PAHNAPLSIIGYIR", solution.convert("PAYPALISHIRING", 3));
    }

}