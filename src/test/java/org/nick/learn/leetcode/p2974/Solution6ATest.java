package org.nick.learn.leetcode.p2974;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

@Slf4j
class Solution6ATest {

    @Test
    void numberGame() {
        Solution6A solutionInstance = new Solution6A();

        int[] nums;
        for (int i = 0; i < 10000; i++) {
            nums = ArrayUtils.generateIntArray10();
            int[] oriArr = Arrays.copyOf(nums, nums.length);
            log.info("before sort: {}", Arrays.toString(nums));


            // 自己实现的插入排序
            solutionInstance.insertionSort(nums);

            // JDK 源码中的插入排序
//            Solution6A.insertionSortJDKVariant(nums);

            log.info("after sort: {}", Arrays.toString(nums));
            org.junit.jupiter.api.Assertions.assertTrue(ArrayUtils.arrayIsAsc(oriArr, nums));
            log.info("");
        }

    }
}