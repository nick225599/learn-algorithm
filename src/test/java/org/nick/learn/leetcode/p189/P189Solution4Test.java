package org.nick.learn.leetcode.p189;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class P189Solution4Test {
    P189Solution4 solution = new P189Solution4();

    @Test
    void rotate() {
        int[] nums = new int[]{1,2,3,4,5};
        int k = 3;
        solution.rotate(nums, k);
        assertEquals("[3, 4, 5, 1, 2]", Arrays.toString(nums));
    }

    @Test
    void rotate2() {
        int[] nums = new int[]{-1,-100,3,99};
        int k = 2;
        solution.rotate(nums, k);
        assertEquals("[3, 99, -1, -100]", Arrays.toString(nums));
    }
}