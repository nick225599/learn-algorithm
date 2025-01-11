package org.nick.learn.algorithm.sort;

import org.junit.Assert;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

public class SelectionSort {
    private static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            int baseNum = arr[i];
            int minIndex = i;
            int j;
            for(j = i + 1; j < arr.length; j++){
                if(baseNum > arr[j]){
                    baseNum = arr[j];
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {


        int times = 8;

        long startTimeB = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            int[] array = ArrayUtils.generateIntArray(times);

            System.out.println("array: " + Arrays.toString(array));
            int countA = ArrayUtils.count(array);

            selectionSort(array);

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
}
