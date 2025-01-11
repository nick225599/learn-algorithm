package org.nick.learn.leetcode.problem2974;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

class Solution5Test {

    @Test
    void numberGame() {
        int[] nums;

        for (int i = 0; i < 10000; i++) {
            nums = ArrayUtils.generateIntArray10();
            System.out.println("before sort: " + Arrays.toString(nums));
            new Solution5().dualPivotQuickSort(nums);
            System.out.println("after sort: " + Arrays.toString(nums));
            org.junit.jupiter.api.Assertions.assertTrue(ArrayUtils.arrayIsAsc(nums));
            System.out.println();
        }

        nums = new int[]{5, 4, 2, 3};
        System.out.println(Arrays.toString(new Solution5().numberGame(nums)));
    }
}