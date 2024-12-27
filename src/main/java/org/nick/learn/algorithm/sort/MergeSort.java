package org.nick.learn.algorithm.sort;

import org.junit.Assert;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

public class MergeSort {

    // 递推公式：
    // merge_sort(p…r) = merge(merge_sort(p…q), merge_sort(q+1…r))
    //
    // 终止条件：
    // p >= r 不用再继续分解

    public static void main(String[] args) {
        int times = 1024;

        long startTimeB = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            int[] array = ArrayUtils.generateIntArray(times);

            System.out.println("array: " + Arrays.toString(array));
            int countA = ArrayUtils.count(array);

            array = mergeSort(array);

            System.out.println("array: " + Arrays.toString(array));
            int countB = ArrayUtils.count(array);
            Assert.assertTrue("array is asc.", ArrayUtils.arrayIsAsc(array));
            Assert.assertEquals(countA, countB);
            System.out.println();
        }
        long endTimeB = System.currentTimeMillis();
        System.out.println("geek time: " + (endTimeB - startTimeB) + " ms");

        System.out.println("-----------------------------------------------------------------------------------------");

    }

    private static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        array = mergeSortSplit(array, 0, array.length - 1);
        return array;
    }

    private static int[] mergeSortSplit(int[] array, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return new int[]{array[startIndex]};
        } else if (startIndex + 1 == endIndex) {
            int[] temp = new int[2];
            if (array[startIndex] <= array[endIndex]) {
                temp[0] = array[startIndex];
                temp[1] = array[endIndex];
            } else {
                temp[1] = array[startIndex];
                temp[0] = array[endIndex];
            }
            return temp;
        } else {
            int midIndex = startIndex + ((endIndex - startIndex) >> 1);
            return mergeSortMerge(
                    mergeSortSplit(array, startIndex, midIndex),
                    mergeSortSplit(array, midIndex + 1, endIndex),
                    endIndex - startIndex + 1
            );
        }


    }

    private static int[] mergeSortMerge(int[] arr1, int[] arr2, int length) {
        int[] temp = new int[length];
        for (int i = 0, j = 0, k = 0; i < arr1.length || j < arr2.length; k++) {
            if (i >= arr1.length) {
                temp[k] = arr2[j++];
            } else if (j >= arr2.length) {
                temp[k] = arr1[i++];
            } else {
                if (arr1[i] <= arr2[j]) {
                    temp[k] = arr1[i++];
                } else {
                    temp[k] = arr2[j++];
                }
            }
        }
        return temp;
    }

}
