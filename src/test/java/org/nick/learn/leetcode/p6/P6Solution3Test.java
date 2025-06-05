package org.nick.learn.leetcode.p6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P6Solution3Test {

    P6Solution3 solution = new P6Solution3();


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

    // PAYPALISHIRING, 4
    // P     I     N
    // A   L S   I G
    // Y A   H R
    // P     I
    // PIN ALSIG YAHR PI
    // PIN APSIG YAHR PI [ERROR]
    @Test
    public void test3(){
        assertEquals("PINALSIGYAHRPI", solution.convert("PAYPALISHIRING", 4));
    }

    @Test
    public void test4(){
        assertEquals("AB", solution.convert("AB", 1));
    }
}