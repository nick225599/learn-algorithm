package org.nick.learn.leetcode.problem2974;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

@Slf4j
class Solution6BTest {

    @Test
    void numberGame() {
        Solution6B solutionInstance = new Solution6B();
        int[] nums;

        for (int i = 0; i < 1000; i++) {
            nums = ArrayUtils.generateIntArray(i);
            log.info("before sort: " + Arrays.toString(nums));
            int countBeforeSort = ArrayUtils.count(nums);

            solutionInstance.insertionSort(nums);
            log.info("after sort: " + Arrays.toString(nums));
            int countAfterSort = ArrayUtils.count(nums);

            org.junit.jupiter.api.Assertions.assertTrue(ArrayUtils.arrayIsAsc(nums),"array is asc" );
            org.junit.jupiter.api.Assertions.assertEquals(countBeforeSort, countAfterSort);

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