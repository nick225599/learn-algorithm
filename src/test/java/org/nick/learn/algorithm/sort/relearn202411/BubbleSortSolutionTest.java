package org.nick.learn.algorithm.sort.relearn202411;


import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class BubbleSortSolutionTest {


    @Test
    public void bubbleSort() {
        for (int i = 0; i < 10; i++) {
            int[] arr = ArrayUtils.generateIntArray(10000);
            int[] oriArr = Arrays.copyOf(arr,arr.length);
            System.out.println(Arrays.toString(arr));
            BubbleSortSolution.bubbleSort(arr);
            assertTrue(ArrayUtils.arrayIsAsc(oriArr, arr));
            System.out.println();
        }
    }
}