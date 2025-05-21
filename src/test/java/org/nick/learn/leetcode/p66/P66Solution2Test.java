package org.nick.learn.leetcode.p66;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class P66Solution2Test {
    P66Solution2 solution = new P66Solution2();

    @Test
    void plusOne() {
        int[] arr = new int[]{1,2,3};
        System.out.println(Arrays.toString(solution.plusOne(arr)));
    }
    @Test
    void plusOne2() {
        int[] arr = new int[]{9,9,9};
        System.out.println(Arrays.toString(solution.plusOne(arr)));
    }
}