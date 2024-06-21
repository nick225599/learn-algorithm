package org.nick.learn.algorithm.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.nick.learn.algorithm.common.ArrayUtils;

import java.util.Arrays;
import java.util.Random;

@Slf4j
public class QuickSort {

    public static Random r = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        int times = 4;

        long startTimeB = System.currentTimeMillis();
//        for (int i = 0; i < times; i++) {
            int[] array = ArrayUtils.generateIntArray(times);

            System.out.println("array: " + Arrays.toString(array));
            int countA = ArrayUtils.count(array);

            new QuickSort().sort(array);

            System.out.println("array: " + Arrays.toString(array));
            int countB = ArrayUtils.count(array);
            Assert.assertTrue("array is asc.", ArrayUtils.arrayIsAsc(array));
            Assert.assertEquals(countA, countB);
            System.out.println();
//        }
        long endTimeB = System.currentTimeMillis();
        System.out.println("geek time: " + (endTimeB - startTimeB) + " ms");

//        System.out.println("-----------------------------------------------------------------------------------------");

    }

    // 递推公示：quickSort(arr, l, r) = quickSort(arr, l, t), quickSort(arr, t + 1, r)

    // 结束条件：l <= r + 1
    private void sort(int[] array) {
        //TODO sunchuansheng 20240619 自己写一下递推公式，自己实现一下快排
        this.quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] arr, int l, int r) {
        if(l>=r){
            return;
        }

        int baseIdx = l;
        int baseNum = arr[baseIdx];

        int[] arrL = new int[arr.length];
        int idxL = 0;

        int[] arrR = new int[arr.length];
        int idxR = 0;

        int splitIdx = 0;

        for (int i = l + 1; i <= r; i++) {
            if (arr[i] <= baseNum) {
                arrL[idxL++] = arr[i];
            } else {
                arrR[idxR++] = arr[i];
            }
        }


        splitIdx = idxL;


        int[] result = new int[arr.length];
        int resultIdx = 0;
        for (int i = 0; i < idxL; i++) {
            result[resultIdx++] = arrL[i];
        }
        result[resultIdx++] = baseNum;
        for (int i = resultIdx; i < idxR; i++) {
            result[resultIdx++] = arrR[i];
        }

        arr = result;



        quickSort(arr, l, splitIdx);
        quickSort(arr, splitIdx + 1, r);
    }


}


