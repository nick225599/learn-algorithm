package org.nick.learn.leetcode.p2974;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class Solution6Test {

    @Test
    void numberGame() {
        Solution6 solutionInstance = new Solution6();

        int[] nums;
        for (int i = 0; i < 10000; i++) {
            nums = ArrayUtils.generateIntArray10();
            int[] oriArr = Arrays.copyOf(nums, nums.length);
            log.info("before sort: {}", Arrays.toString(nums));
            solutionInstance.insertionSort(nums);
            log.info("after sort: {}", Arrays.toString(nums));

            assertTrue(ArrayUtils.arrayIsAsc(oriArr, nums));
            log.info("");
        }

        nums = new int[]{5, 4, 2, 3};
        log.info(Arrays.toString(solutionInstance.numberGame(nums)));
    }
}