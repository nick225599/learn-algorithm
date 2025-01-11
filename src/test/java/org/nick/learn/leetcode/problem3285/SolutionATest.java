package org.nick.learn.leetcode.problem3285;

import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionATest {

    @Test
    void stableMountains() {
        SolutionA solution = new SolutionA();
        int[] mountains;
        List<Integer> indicesOfStableMountains;

        mountains = new int[]{1, 2, 3, 4, 5};
        indicesOfStableMountains = solution.stableMountains(mountains, 2);
        org.junit.jupiter.api.Assertions.assertEquals(2, indicesOfStableMountains.size());
        org.junit.jupiter.api.Assertions.assertTrue(indicesOfStableMountains.contains(3));
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