package org.nick.learn.leetcode.problem120;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P120Solution1Test {
    P120Solution1 solution = new P120Solution1();

    @Test
    void minimumTotal() {
        List<Integer> l0 = new ArrayList<>();
        l0.add(-10);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(l0);
        assertEquals(-10, solution.minimumTotal(triangle));

    }

    @Test
    void minimumTotal2() {
        List<List<Integer>> triangle = new ArrayList<>();

        List<Integer> level;

        level = new ArrayList<>();
        level.add(2);
        triangle.add(level);

        level = new ArrayList<>();
        level.add(3);
        level.add(4);
        triangle.add(level);

        assertEquals(5, solution.minimumTotal(triangle));

    }

    @Test
    void minimumTotal3() {
        List<List<Integer>> triangle = new ArrayList<>();

        List<Integer> level;

        level = new ArrayList<>();
        level.add(2);
        triangle.add(level);

        level = new ArrayList<>();
        level.add(3);
        level.add(4);
        triangle.add(level);

        level = new ArrayList<>();
        level.add(6);
        level.add(5);
        level.add(7);
        triangle.add(level);

        level = new ArrayList<>();
        level.add(4);
        level.add(1);
        level.add(8);
        level.add(3);
        triangle.add(level);

        assertEquals(11, solution.minimumTotal(triangle));

    }
}