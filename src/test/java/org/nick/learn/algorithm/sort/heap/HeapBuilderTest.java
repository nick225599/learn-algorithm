package org.nick.learn.algorithm.sort.heap;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.utils.ArrayUtils;
import org.nick.learn.algorithm.utils.CommonUtils;

@Slf4j
class HeapBuilderTest {

    @Test
    void buildMaxHeap() {
        CommonUtils.printLine();
        int[] arr = ArrayUtils.generateIntArray10();
        log.info("构建大顶堆之前的数组：");
        HeapPrinter.printHeap(arr);
        CommonUtils.printLine();

        HeapBuilder.buildMaxHeap(arr);

        log.info("构建大顶堆之后：");
        HeapPrinter.printHeap(arr);
    }

    @Test
    void buildMinHeap() {
    }
}