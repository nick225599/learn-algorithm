package org.nick.learn.algorithm.search;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.nick.learn.algorithm.common.ArrayUtils;
import org.nick.learn.algorithm.search.aaa_binary_search.BinarySearchUtils;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Slf4j
public class BinarySearchSolutionTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void binarySearch() {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        log.info("arr: {}", Arrays.toString(arr));
        arr = Arrays.stream(arr).sorted().toArray();
        assertTrue(ArrayUtils.arrayIsAsc(arr));

        assertEquals(-1, BinarySearchSolution.binarySearch(arr, 1024));
        assertEquals(-1, BinarySearchUtils.binarySearchLeftIncludeRightInclude(arr, 1024));
        assertEquals(2, BinarySearchSolution.binarySearch(arr, 3));
        assertEquals(2, BinarySearchUtils.binarySearchLeftIncludeRightInclude(arr, 3));

    }
}