package org.nick.learn.algorithm.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class CountingSortTest {

    @Test
    void sort() {
        int times = 6;

        long startTimeB = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            int[] array = ArrayUtils.generateIntArray10();
            int[] oriArr = Arrays.copyOf(array, array.length);
            log.info("array: " + Arrays.toString(array));

            CountingSort.sort(array, array.length);

            log.info("array: " + Arrays.toString(array));
            assertTrue(ArrayUtils.arrayIsAsc(oriArr, array));
        }
        long endTimeB = System.currentTimeMillis();
        log.info("geek time: " + (endTimeB - startTimeB) + " ms");
        log.info("-----------------------------------------------------------------------------------------");


//        int[] arr = {2, 0, 2};
//        int countA = ArrayUtils.count(arr);
//        log.info("array: " + Arrays.toString(arr));
//
//        sort(arr, arr.length);
//
//        int countB = ArrayUtils.count(arr);
//        log.info("array: " + Arrays.toString(arr));
//        org.junit.jupiter.api.Assertions.assertEquals("排序前排序后的数据元素总和一致", countA, countB);
//        org.junit.jupiter.api.Assertions.assertTrue("数组元素是升序的 ASC", ArrayUtils.arrayIsAsc(oriArr, nums));

    }
}