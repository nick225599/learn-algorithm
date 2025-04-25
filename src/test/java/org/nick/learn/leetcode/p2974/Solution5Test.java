package org.nick.learn.leetcode.p2974;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class Solution5Test {

    @Test
    void numberGame() {
        int[] nums;

        for (int i = 0; i < 10000; i++) {
            nums = ArrayUtils.generateIntArray10();
            int[] oriArr = Arrays.copyOf(nums, nums.length);
            log.info("before sort: " + Arrays.toString(nums));
            new Solution5().dualPivotQuickSort(nums);
            log.info("after sort: " + Arrays.toString(nums));
            assertTrue(ArrayUtils.arrayIsAsc(oriArr, nums));
            System.out.println();
        }

        nums = new int[]{5, 4, 2, 3};
        System.out.println(Arrays.toString(new Solution5().numberGame(nums)));
    }
}