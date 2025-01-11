package org.nick.learn.leetcode.problem3285;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionBTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void stableMountains() {
        SolutionB solution = new SolutionB();
        int[] mountains;
        List<Integer> indicesOfStableMountains;

        mountains = new int[]{1, 2, 3, 4, 5};
        indicesOfStableMountains = solution.stableMountains(mountains, 2);
        assertEquals(2, indicesOfStableMountains.size());
        assertTrue(indicesOfStableMountains.contains(3));
        org.junit.jupiter.api.Assertions.assertTrue(indicesOfStableMountains.contains(4));

        mountains = new int[]{10, 1, 10, 1, 10};
        indicesOfStableMountains = solution.stableMountains(mountains, 3);
        org.junit.jupiter.api.Assertions.assertEquals(2, indicesOfStableMountains.size());
        org.junit.jupiter.api.Assertions.assertTrue(indicesOfStableMountains.contains(1));
        org.junit.jupiter.api.Assertions.assertTrue(indicesOfStableMountains.contains(3));

        indicesOfStableMountains = solution.stableMountains(mountains, 10);
        org.junit.jupiter.api.Assertions.assertEquals(0, indicesOfStableMountains.size());
    }
}