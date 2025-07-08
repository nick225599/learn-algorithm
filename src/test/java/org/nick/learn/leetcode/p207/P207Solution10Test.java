package org.nick.learn.leetcode.p207;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class P207Solution10Test {
    P207Solution10 solution = new P207Solution10();

    @Test
    void canFinish() {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{
                new int[]{1, 0}
        };

        assertTrue(solution.canFinish(numCourses, prerequisites));
    }
}