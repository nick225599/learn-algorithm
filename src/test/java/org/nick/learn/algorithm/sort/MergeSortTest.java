package org.nick.learn.algorithm.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class MergeSortTest {

    @Test
    void mergeSort() {
        int times = 1024;

        long startTimeB = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            int[] array = ArrayUtils.generateIntArray(times);
            int[] oriArr = Arrays.copyOf(array, array.length);

            log.info("array: " + Arrays.toString(array));

            array = MergeSort.mergeSort(array);

            log.info("array: " + Arrays.toString(array));
            assertTrue(ArrayUtils.arrayIsAsc(oriArr, array));
        }
        long endTimeB = System.currentTimeMillis();
        log.info("geek time: " + (endTimeB - startTimeB) + " ms");

        log.info("-----------------------------------------------------------------------------------------");

    }
}