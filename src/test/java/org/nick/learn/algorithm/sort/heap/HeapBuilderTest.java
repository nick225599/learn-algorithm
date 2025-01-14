package org.nick.learn.algorithm.sort.heap;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.utils.ArrayUtils;

class HeapBuilderTest {

    @Test
    void buildMaxHeap() {
        int[] arr = ArrayUtils.generateIntArray10();
        System.out.println("构建大顶堆之前的数组：");
        HeapPrinter.printHeap(arr);

        HeapBuilder.buildMaxHeap(arr);
        System.out.println("构建大顶堆之后：");
        HeapPrinter.printHeap(arr);
    }

    @Test
    void buildMinHeap() {
    }
}