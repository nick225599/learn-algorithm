package org.nick.learn.algorithm.sort.relearn202411;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class SelectionSortSolutionTest {


    @Test
    public void testSelectionSort() {
        for (int i = 0; i < 10; i++) {
            int[] arr = ArrayUtils.generateIntArray(10000);
            System.out.println(Arrays.toString(arr));
            SelectionSortSolution.selectionSort(arr);
            assertTrue(ArrayUtils.arrayIsAsc(arr));
            System.out.println();
        }
    }
}