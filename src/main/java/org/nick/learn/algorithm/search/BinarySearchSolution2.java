package org.nick.learn.algorithm.search;

import lombok.extern.slf4j.Slf4j;

/**
 * 变体一：查找第一个值等于给定值的元素上一节中的二分查找是最简单的一种，
 * 即有序数据集合中不存在重复的数据，我们在其中查找值等于某个给定值的数据。
 * 如果我们将这个问题稍微修改下，有序数据集合中存在重复的数据，
 * 我们希望找到第一个值等于给定值的数据，这样之前的二分查找代码还能继续工作吗？
 * 比如下面这样一个有序数组，其中，a[5]，a[6]，a[7]的值都等于 8，是重复的数据。
 * 我们希望查找第一个等于 8 的数据，也就是下标是 5 的元素。
 */
@Slf4j
public class BinarySearchSolution2 {


    public static int binarySearch2(int[] arr, int target) {
        int startIndex = 0;
        int endIndex = arr.length - 1;

        while (startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if (target < arr[midIndex]) {
                endIndex = midIndex - 1;
            } else if (arr[midIndex] < target) {
                startIndex = midIndex + 1;
            } else {
                while (midIndex > 0) {
                    if (arr[midIndex - 1] == target) {
                        midIndex -= 1;
                    } else {
                        break;
                    }
                }
                return midIndex;

            }
        }
        return -1;
    }
}
