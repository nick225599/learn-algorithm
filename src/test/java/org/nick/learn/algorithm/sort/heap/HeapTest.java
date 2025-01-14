package org.nick.learn.algorithm.sort.heap;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

@Slf4j
class HeapTest {
    @Test
    public void testBuildHeap() {
        int[] arr = ArrayUtils.generateIntArray10();
        log.info("before build heap: {}", Arrays.toString(arr));
        Heap.buildHeap(arr, arr.length - 1);
        log.info("after build heap: {}", Arrays.toString(arr));
    }
}