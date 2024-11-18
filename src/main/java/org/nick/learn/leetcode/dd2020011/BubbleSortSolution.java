package org.nick.learn.leetcode.dd2020011;

public class BubbleSortSolution {

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


}
