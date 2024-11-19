package org.nick.learn.algorithm.sort.relearn202411;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.nick.learn.algorithm.common.ArrayUtils;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class BubbleSortSolutionTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void bubbleSort() {
        for (int i = 0; i < 10; i++) {
            int[] arr = ArrayUtils.generateIntArray(10000);
            System.out.println(Arrays.toString(arr));
            BubbleSortSolution.bubbleSort(arr);
            assertTrue(ArrayUtils.arrayIsAsc(arr));
            System.out.println();
        }
    }
}