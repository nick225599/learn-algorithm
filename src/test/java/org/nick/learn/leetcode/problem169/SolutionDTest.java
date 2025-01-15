package org.nick.learn.leetcode.problem169;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class SolutionDTest {
    SolutionD solution = new SolutionD();
    @Test
    void heapSort() {
        int[] arr = ArrayUtils.generateIntArray10();
        int[] oriArr = Arrays.copyOf(arr, arr.length);
        solution.heapSort(arr, arr.length);
        log.info("after heap sort: {}", Arrays.toString(arr));
        assertTrue(ArrayUtils.arrayIsAsc(oriArr, arr));
    }
}