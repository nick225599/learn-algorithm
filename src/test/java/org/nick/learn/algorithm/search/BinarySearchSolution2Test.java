package org.nick.learn.algorithm.search;


import org.junit.jupiter.api.Test;

public class BinarySearchSolution2Test {



    @Test
    public void binarySearch2() {
        // 变体一：查找第一个值等于给定值的元素上一节中的二分查找是最简单的一种，
        // 即有序数据集合中不存在重复的数据，我们在其中查找值等于某个给定值的数据。
        // 如果我们将这个问题稍微修改下，有序数据集合中存在重复的数据，
        // 我们希望找到第一个值等于给定值的数据，这样之前的二分查找代码还能继续工作吗？
        // 比如下面这样一个有序数组，其中，a[5]，a[6]，a[7]的值都等于 8，是重复的数据。
        // 我们希望查找第一个等于 8 的数据，也就是下标是 5 的元素。
        int[] arr = new int[]{1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        org.junit.jupiter.api.Assertions.assertEquals(5, BinarySearchSolution2.binarySearch2(arr, 8));
    }
}