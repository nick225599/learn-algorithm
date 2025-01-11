package org.nick.learn.algorithm.sort;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

class QuickSortV3Test {

    @Test
    void sort() {
        int times = 30;

        long startTimeB = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            int[] array = ArrayUtils.generateIntArray(times);

            System.out.println("array: " + Arrays.toString(array));
            int countA = ArrayUtils.count(array);

            QuickSortV3.sort(array);

            System.out.println("array: " + Arrays.toString(array));
            int countB = ArrayUtils.count(array);
            org.junit.jupiter.api.Assertions.assertTrue( ArrayUtils.arrayIsAsc(array),"array is asc.");
            org.junit.jupiter.api.Assertions.assertEquals(countA, countB);
            System.out.println();
        }
        long endTimeB = System.currentTimeMillis();
        System.out.println("geek time: " + (endTimeB - startTimeB) + " ms");
        System.out.println("-----------------------------------------------------------------------------------------");
//
//
//        int[] arr = new int[]{2, 1, 2};
//        int countA = ArrayUtils.count(arr);
//        System.out.println("array: " + Arrays.toString(arr));
//
//        sort(arr);
//
//        int countB = ArrayUtils.count(arr);
//        System.out.println("array: " + Arrays.toString(arr));
//        org.junit.jupiter.api.Assertions.assertEquals("排序前排序后的数据元素总和一致", countA, countB);
//        org.junit.jupiter.api.Assertions.assertTrue("数组元素是升序的 ASC", ArrayUtils.arrayIsAsc(arr));

    }
}