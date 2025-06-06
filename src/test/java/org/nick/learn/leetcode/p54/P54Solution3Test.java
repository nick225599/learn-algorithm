package org.nick.learn.leetcode.p54;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P54Solution3Test {
    P54Solution3 solution = new P54Solution3();


    @Test
    public void test() {
        int[][] m = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        };
        List<Integer> result = solution.spiralOrder(m);
        System.out.println(Arrays.toString(result.toArray()));
        assertEquals("[1, 2, 3, 6, 9, 8, 7, 4, 5]", Arrays.toString(result.toArray()));
    }

    @Test
    public void test2() {
        // [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        int[][] m = new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12}
        };
        List<Integer> result = solution.spiralOrder(m);
        System.out.println(Arrays.toString(result.toArray()));
        assertEquals("[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]", Arrays.toString(result.toArray()));
    }

    @Test
    public void test3() {
        int[][] m = new int[][]{
                new int[]{3},
                new int[]{2},
        };
        List<Integer> result = solution.spiralOrder(m);
        System.out.println(Arrays.toString(result.toArray()));
        assertEquals("[3, 2]", Arrays.toString(result.toArray()));
    }
}