package org.nick.learn.leetcode.p137;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P137Solution5Test {
    P137Solution5 solution = new P137Solution5();

    @Test
    void testCalculateNewAi() {

        // 0 + 0 = 0, 00 + 0 = 00 => ai = 0, bi = 0, xi = 0, newAi = 0
        assertEquals(0, this.calculateNewAi(0, 0, 0));

        // 1 + 0 = 1, 01 + 0 = 01 => ai = 0, bi = 1, xi = 0, newAi = 0
        assertEquals(0, this.calculateNewAi(0, 1, 0));

        // 2 + 0 = 2, 10 + 0 = 10 => ai = 1, bi = 0, xi = 0, newAi = 1
        assertEquals(1, this.calculateNewAi(1, 0, 0));

        // 0 + 1 = 1, 00 + 1 = 01 => ai = 0, bi = 0, xi = 1, newAi = 0
        assertEquals(0, this.calculateNewAi(0, 0, 1));

        // 1 + 1 = 2, 01 + 1 = 10 => ai = 0, bi = 1, xi = 1, newAi = 1
        assertEquals(1, this.calculateNewAi(0, 1, 1));

        // 2 + 1 = 0, 10 + 1 = 00 => ai = 1, bi = 0, xi = 1, newAi = 0
        assertEquals(0, this.calculateNewAi(1, 0, 1));
    }

    @Test
    void testCalculateNewBi() {

        // 0 + 0 = 0, 00 + 0 = 00 => ai = 0, bi = 0, xi = 0, newBi = 0
        assertEquals(0, this.calculateNewBi(0, 0, 0));

        // 1 + 0 = 1, 01 + 0 = 01 => ai = 0, bi = 1, xi = 0, newBi = 1
        assertEquals(1, this.calculateNewBi(0, 1, 0));

        // 2 + 0 = 2, 10 + 0 = 10 => ai = 1, bi = 0, xi = 0, newBi = 0
        assertEquals(0, this.calculateNewBi(1, 0, 0));

        // 0 + 1 = 1, 00 + 1 = 01 => ai = 0, bi = 0, xi = 1, newBi = 1
        assertEquals(1, this.calculateNewBi(0, 0, 1));

        // 1 + 1 = 2, 01 + 1 = 10 => ai = 0, bi = 1, xi = 1, newBi = 0
        assertEquals(0, this.calculateNewBi(0, 1, 1));

        // 2 + 1 = 0, 10 + 1 = 00 => ai = 1, bi = 0, xi = 1, newBi = 0
        assertEquals(0, this.calculateNewBi(1, 0, 1));
    }

    int calculateNewAi(int ai, int bi, int xi){
        return ai & (~bi) & (~xi) | (~ai) & bi & xi;
    }

    int calculateNewBi(int ai, int bi, int xi){
        return (~ai) & bi & (~xi) | (~ai) & (~bi) & xi;
    }


}