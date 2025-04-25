package org.nick.learn.leetcode.p3285;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void stableMountains() {
        Solution solution = new Solution();
        int[] mountains;
        List<Integer> indicesOfStableMountains;

        mountains = new int[]{1, 2, 3, 4, 5};
        indicesOfStableMountains = solution.stableMountains(mountains, 2);
        assertEquals(2, indicesOfStableMountains.size());
        assertTrue(indicesOfStableMountains.contains(3));
        assertTrue(indicesOfStableMountains.contains(4));

        mountains = new int[]{10, 1, 10, 1, 10};
        indicesOfStableMountains = solution.stableMountains(mountains, 3);
        assertEquals(2, indicesOfStableMountains.size());
        assertTrue(indicesOfStableMountains.contains(1));
        assertTrue(indicesOfStableMountains.contains(3));

        indicesOfStableMountains = solution.stableMountains(mountains, 10);
        assertEquals(0, indicesOfStableMountains.size());

    }
}