package org.nick.learn.leetcode.p210;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P210Solution1Test {
    P210Solution1 solution = new P210Solution1();

    @Test
    void findOrder() {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{
                new int[]{0, 1} // 0 依赖 1
        };
        int[] result = solution.findOrder(numCourses, prerequisites);
        assertEquals("[1, 0]", Arrays.toString(result));
    }

    @Test
    void findOrder2() {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{
                new int[]{1, 0} // 1 依赖 0
        };
        int[] result = solution.findOrder(numCourses, prerequisites);
        assertEquals("[0, 1]", Arrays.toString(result));
    }
}