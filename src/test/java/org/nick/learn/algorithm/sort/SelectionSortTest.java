package org.nick.learn.algorithm.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class SelectionSortTest {

    @Test
    void selectionSort() {

        int times = 8;

        long startTimeB = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            int[] array = ArrayUtils.generateIntArray(times);
            int[] newArr = Arrays.copyOf(array, array.length);

            log.info("array: " + Arrays.toString(array));

            new SelectionSort().selectionSort(array);

            log.info("array: " + Arrays.toString(array));
            assertTrue(ArrayUtils.arrayIsAsc(newArr, array));
            System.out.println();
        }


        long endTimeB = System.currentTimeMillis();
        log.info("geek time: " + (endTimeB - startTimeB) + " ms");

        log.info("-----------------------------------------------------------------------------------------");

    }
}