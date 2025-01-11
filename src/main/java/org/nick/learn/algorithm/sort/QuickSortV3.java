package org.nick.learn.algorithm.sort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QuickSortV3 {

    public static void main(String[] args) {

    }

    // 递推公示：quickSort(arr, l, r) = quickSort(arr, l, t), quickSort(arr, t + 1, r)

    // 结束条件：l <= r + 1
    public static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int baseNum = arr[r];

        int i = l;
        int j = l;
        for (; j < r; j++) {
            if (arr[j] < baseNum) {
                int tmp = arr[i];
                arr[i++] = arr[j];
                arr[j] = tmp;
            }
        }

        arr[j] = arr[i];
        arr[i] = baseNum;

        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }


}


