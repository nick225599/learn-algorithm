package org.nick.learn.algorithm.sort.relearn202411;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class InsertionSortSolutionTest {

    @Test
    public void testInsertionSort() {
        for (int i = 0; i < 10; i++) {
            int[] arr = ArrayUtils.generateIntArray(10);
            int tempCount = ArrayUtils.count(arr);
            System.out.println(Arrays.toString(arr));
            InsertionSortSolution.insertionSort(arr);
            assertTrue(ArrayUtils.arrayIsAsc(arr));
            assertEquals(tempCount, ArrayUtils.count(arr));
            System.out.println();
        }
    }
}