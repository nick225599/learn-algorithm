package org.nick.learn.algorithm.sort;

import lombok.extern.slf4j.Slf4j;
import org.nick.learn.algorithm.utils.ArrayUtils;

@Slf4j
public class InsertionSort {

    public static void main(String[] args) {
        int times = 1000;

        long startTimeB = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            int[] array = ArrayUtils.generateIntArray(times);

//            log.info("array: " + Arrays.toString(array));
//            int countA = ArrayUtils.count(array);

            insertionSortFromGeekTime(array, array.length);

//            log.info("array: " + Arrays.toString(array));
//            int countB = ArrayUtils.count(array);
//            org.junit.jupiter.api.Assertions.assertTrue("array is asc.", ArrayUtils.arrayIsAsc(array));
//            org.junit.jupiter.api.Assertions.assertEquals(countA, countB);
//            System.out.println();
        }
        long endTimeB = System.currentTimeMillis();
        log.info("geek time: " + (endTimeB - startTimeB) + " ms");

        log.info("-----------------------------------------------------------------------------------------");

        long startTimeA = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            int[] array = ArrayUtils.generateIntArray(times);

//            log.info("array: " + Arrays.toString(array));
//            int countA = ArrayUtils.count(array);

            insertionSortVersionB(array);

//            log.info("array: " + Arrays.toString(array));
//            int countB = ArrayUtils.count(array);
//            org.junit.jupiter.api.Assertions.assertTrue("array is asc.", ArrayUtils.arrayIsAsc(array));
//            org.junit.jupiter.api.Assertions.assertEquals(countA, countB);
//            System.out.println();
        }
        long endTimeA = System.currentTimeMillis();
        log.info("my time: " + (endTimeA - startTimeA) + " ms");


    }

    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int curVal = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    arr[j + 1] = arr[j];
                    arr[j] = curVal;
                }
            }
        }
    }

    // 优化下插入排序，把多次位置交换，替换成直接赋值
    public static void insertionSortVersionB(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int curVal = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > curVal) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = curVal;
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
