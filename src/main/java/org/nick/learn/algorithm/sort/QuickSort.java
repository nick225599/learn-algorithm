package org.nick.learn.algorithm.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class QuickSort {

    public static Random r = new Random(System.currentTimeMillis());

    public static void main(String[] args) {

    }

    // 递推公示：quickSort(arr, l, r) = quickSort(arr, l, t), quickSort(arr, t + 1, r)

    // 结束条件：l <= r + 1
    public void sort(int[] array) {
        this.quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }


        int baseNum = arr[l];

        int idxL = 0;
        int[] arrL = new int[arr.length];
        int idxR = 0;
        int[] arrR = new int[arr.length];
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] <= baseNum) {
                arrL[idxL++] = arr[i];
            } else {
                arrR[idxR++] = arr[i];
            }
        }

        int j = l;
        for (int i = 0; i < idxL; i++) {
            arr[j++] = arrL[i];
        }
        int splitIdx = j;
        arr[j++] = baseNum;
        for (int i = 0; i < idxR; i++) {
            arr[j++] = arrR[i];
        }

        quickSort(arr, l, splitIdx - 1);
        quickSort(arr, splitIdx + 1, r);
    }


}


