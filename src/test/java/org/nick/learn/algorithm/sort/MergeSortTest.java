package org.nick.learn.algorithm.sort;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

class MergeSortTest {

    @Test
    void mergeSort() {
        int times = 1024;

        long startTimeB = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            int[] array = ArrayUtils.generateIntArray(times);

            System.out.println("array: " + Arrays.toString(array));
            int countA = ArrayUtils.count(array);

            array = MergeSort.mergeSort(array);

            System.out.println("array: " + Arrays.toString(array));
            int countB = ArrayUtils.count(array);
            org.junit.jupiter.api.Assertions.assertTrue(ArrayUtils.arrayIsAsc(array),"array is asc.");
            org.junit.jupiter.api.Assertions.assertEquals(countA, countB);
            System.out.println();
        }
        long endTimeB = System.currentTimeMillis();
        System.out.println("geek time: " + (endTimeB - startTimeB) + " ms");

        System.out.println("-----------------------------------------------------------------------------------------");

    }
}