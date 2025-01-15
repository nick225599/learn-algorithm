package org.nick.learn.algorithm.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class QuickSortTest {

    @Test
    void sort() {
        int times = 10;

        long startTimeB = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            int[] array = ArrayUtils.generateIntArray(times);
            int[] oriArr = Arrays.copyOf(array, array.length);

            log.info("array: " + Arrays.toString(array));

            new QuickSort().sort(array);

            log.info("array: " + Arrays.toString(array));
            assertTrue(ArrayUtils.arrayIsAsc(oriArr, array));
        }
        long endTimeB = System.currentTimeMillis();
        log.info("geek time: " + (endTimeB - startTimeB) + " ms");
        log.info("-----------------------------------------------------------------------------------------");

    }
}