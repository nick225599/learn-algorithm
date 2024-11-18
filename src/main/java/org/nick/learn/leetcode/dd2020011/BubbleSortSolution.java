package org.nick.learn.leetcode.dd2020011;

import org.nick.learn.algorithm.common.ArrayUtils;

import java.util.Arrays;

public class BubbleSortSolution {
    private BubbleSortSolution() {

    }

    public static int[] bubbleSort(int[] arr) {
        for (int endIdx = arr.length - 1; endIdx > 0; endIdx--) {
            for (int i = 0; i < endIdx; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtils.generateIntArray(10);

        System.out.println("before sort: ");
        System.out.println(Arrays.toString(arr));
        System.out.println();

        bubbleSort(arr);

        System.out.println("after sort: ");
        System.out.println(Arrays.toString(arr));
        System.out.println();

        System.out.println("arr is asc? " + ArrayUtils.arrayIsAsc(arr));
    }
}
