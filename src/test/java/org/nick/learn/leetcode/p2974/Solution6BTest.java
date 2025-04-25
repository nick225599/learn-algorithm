package org.nick.learn.leetcode.p2974;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class Solution6BTest {

    @Test
    void numberGame() {
        Solution6B solutionInstance = new Solution6B();
        int[] nums;

        for (int i = 0; i < 1000; i++) {
            nums = ArrayUtils.generateIntArray(i);
            int[] oriArr = Arrays.copyOf(nums, nums.length);
            log.info("before sort: " + Arrays.toString(nums));

            solutionInstance.insertionSort(nums);
            log.info("after sort: " + Arrays.toString(nums));

            assertTrue(ArrayUtils.arrayIsAsc(oriArr, nums));

            System.out.println();
        }

        nums = new int[]{5, 4, 2, 3};
        solutionInstance.numberGame(nums);
        org.junit.jupiter.api.Assertions.assertArrayEquals(new int[]{3, 2, 5, 4}, nums);


        nums = new int[]{2, 5};
        solutionInstance.numberGame(nums);
        org.junit.jupiter.api.Assertions.assertArrayEquals(new int[]{5, 2}, nums);

    }
}