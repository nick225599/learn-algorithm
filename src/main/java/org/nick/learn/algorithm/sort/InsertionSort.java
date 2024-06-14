package org.nick.learn.algorithm.sort;

import org.junit.Assert;
import org.nick.learn.algorithm.common.ArrayUtils;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int times = 2000;

//        long startTimeA = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            int[] array = ArrayUtils.generateIntArray(times);
//            System.out.println("array: " + Arrays.toString(array));
            int countA =  ArrayUtils.count(array);
            insertionSort(array);
//            System.out.println("array: " + Arrays.toString(array));
            int countB = ArrayUtils.count(array);
            Assert.assertTrue("array is asc.", ArrayUtils.arrayIsAsc(array));
            Assert.assertEquals(countA, countB);
//            System.out.println();
        }
//        long endTimeA = System.currentTimeMillis();
//        System.out.println("my time: " + (endTimeA - startTimeA) + " ms");
//
//        System.out.println("-----------------------------------------------------------------------------------------");
//        long startTimeB = System.currentTimeMillis();
//        for (int i = 0; i < times; i++) {
//            int[] array = ArrayUtils.generateIntArray(times);
////            System.out.println("array: " + Arrays.toString(array));
////            System.out.println("array count: " + ArrayUtils.count(array));
//            insertionSortFromGeekTime(array, array.length);
////            System.out.println("array: " + Arrays.toString(array));
////            System.out.println("array count: " + ArrayUtils.count(array));
////            Assert.assertTrue("array is asc.", ArrayUtils.arrayIsAsc(array));
////            System.out.println();
//        }
//        long endTimeB = System.currentTimeMillis();
//        System.out.println("geek time: " + (endTimeB - startTimeB) + " ms");


    }

    public static void insertionSort(int[] arr) {
        for( int i = 0; i < arr.length; i++){
            int curVal = arr[i];
            for(int j = i -1; j >= 0; j--){
                if (arr[j] > arr[j + 1]) {
                    arr[j + 1] = arr[j];
                    arr[j] = curVal;
                }
            }
        }
    }

    // 插入排序，a表示数组，n表示数组大小
    public static void insertionSortFromGeekTime(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = value; // 插入数据
        }
    }
}
