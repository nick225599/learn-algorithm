package org.nick.learn.algorithm.sort.relearn202411;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SelectionSortSolutionTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

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