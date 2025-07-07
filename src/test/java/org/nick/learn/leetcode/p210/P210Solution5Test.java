package org.nick.learn.leetcode.p210;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class P210Solution5Test {
    P210Solution5 solution = new P210Solution5();

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

    @Test
    void findOrder3() {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{
                new int[]{1, 0},
                new int[]{0, 1}
        };
        int[] result = solution.findOrder(numCourses, prerequisites);
        assertEquals("[]", Arrays.toString(result));
    }


    @Test
    void findOrder4() {
        int numCourses = 3;
        int[][] prerequisites = new int[][]{
                // [[1,0],[1,2],[0,1]]
                new int[]{1, 0},
                new int[]{1, 2},
                new int[]{0, 1}
        };
        int[] result = solution.findOrder(numCourses, prerequisites);
        assertEquals("[]", Arrays.toString(result));
    }


}