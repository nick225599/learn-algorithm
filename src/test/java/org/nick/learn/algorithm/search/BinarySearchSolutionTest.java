package org.nick.learn.algorithm.search;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.search.aaa_binary_search.BinarySearchUtils;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@Slf4j
public class BinarySearchSolutionTest {


    @Test
    public void binarySearch() {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        int[] oriArr = Arrays.copyOf(arr,arr.length);

        log.info("arr: {}", Arrays.toString(arr));
        arr = Arrays.stream(arr).sorted().toArray();
        assertTrue(ArrayUtils.arrayIsAsc(oriArr, arr));

        assertEquals(-1, BinarySearchSolution.binarySearch(arr, 1024));
        assertEquals(-1, BinarySearchUtils.binarySearchLeftIncludeRightInclude(arr, 1024));
        assertEquals(2, BinarySearchSolution.binarySearch(arr, 3));
        assertEquals(2, BinarySearchUtils.binarySearchLeftIncludeRightInclude(arr, 3));

    }
}