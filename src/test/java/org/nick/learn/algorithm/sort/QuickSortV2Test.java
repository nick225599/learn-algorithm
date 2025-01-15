package org.nick.learn.algorithm.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class QuickSortV2Test {
    @Test
    public void test() {
        int times = 10;

        long startTimeB = System.currentTimeMillis();
        int[] array = ArrayUtils.generateIntArray(times);
        int[] oriArray = Arrays.copyOf(array, array.length);

        log.info("array: " + Arrays.toString(array));

        new QuickSortV2().sort(array);

        log.info("array: " + Arrays.toString(array));
        assertTrue(ArrayUtils.arrayIsAsc(oriArray, array));
        System.out.println();
        long endTimeB = System.currentTimeMillis();
        log.info("geek time: " + (endTimeB - startTimeB) + " ms");
    }

}