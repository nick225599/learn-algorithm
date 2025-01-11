package org.nick.learn.algorithm.sort;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

class CountingSortTest {

    @Test
    void sort() {
        int times = 6;

        long startTimeB = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            int[] array = ArrayUtils.generateIntArray10();

            System.out.println("array: " + Arrays.toString(array));
            int countA = ArrayUtils.count(array);

            CountingSort.sort(array, array.length);

            System.out.println("array: " + Arrays.toString(array));
            int countB = ArrayUtils.count(array);
            org.junit.jupiter.api.Assertions.assertTrue(ArrayUtils.arrayIsAsc(array), "array is asc.");
            org.junit.jupiter.api.Assertions.assertEquals(countA, countB);
            System.out.println();
        }
        long endTimeB = System.currentTimeMillis();
        System.out.println("geek time: " + (endTimeB - startTimeB) + " ms");
        System.out.println("-----------------------------------------------------------------------------------------");


//        int[] arr = {2, 0, 2};
//        int countA = ArrayUtils.count(arr);
//        System.out.println("array: " + Arrays.toString(arr));
//
//        sort(arr, arr.length);
//
//        int countB = ArrayUtils.count(arr);
//        System.out.println("array: " + Arrays.toString(arr));
//        org.junit.jupiter.api.Assertions.assertEquals("排序前排序后的数据元素总和一致", countA, countB);
//        org.junit.jupiter.api.Assertions.assertTrue("数组元素是升序的 ASC", ArrayUtils.arrayIsAsc(arr));

    }
}