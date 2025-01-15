package org.nick.learn.leetcode.problem169;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionBTest {
    private static SolutionB instance = new SolutionB();

    @Test
    void majorityElement() {
        int[] nums = new int[]{3, 2, 3};
        int majority = instance.majorityElement(nums);
        assertEquals(3, majority);

    }

    @Test
    void majorityElement2() {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        int majority = instance.majorityElement(nums);
        assertEquals(2, majority);
    }

    @Test
    void heapSort() {
        int[] oriArr = ArrayUtils.generateIntArray(4096);
        int[] newArr = Arrays.copyOf(oriArr, oriArr.length);
        instance.heapSort(newArr);
        ArrayUtils.arrayIsAsc(oriArr, newArr);
    }
}