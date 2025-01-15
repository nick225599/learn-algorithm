package org.nick.learn.algorithm.sort.heap;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

    @Test
    void heapSort() {
        int[] oriArr = ArrayUtils.generateIntArray10();
        int[] newArr = Arrays.copyOf(oriArr, oriArr.length);
        HeapSort.heapSort(newArr);
        assertTrue(ArrayUtils.arrayIsAsc(oriArr, newArr));
    }
}