package org.nick.learn.algorithm.sort;

import org.junit.Assert;
import org.nick.learn.algorithm.common.ArrayUtils;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            int[] array = ArrayUtils.generateIntArray(10);
            System.out.println("array: " + Arrays.toString(array));
            insertionSort(array, array.length);
            System.out.println("array: " + Arrays.toString(array));
            Assert.assertTrue("array is asc.", ArrayUtils.arrayIsAsc(array));
            System.out.println();
        }

        for (int i = 0; i < 50; i++) {
            int[] array = ArrayUtils.generateIntArray(10);
            System.out.println("array: " + Arrays.toString(array));
            insertionSortFromGeekTime(array, array.length);
            System.out.println("array: " + Arrays.toString(array));
            Assert.assertTrue("array is asc.", ArrayUtils.arrayIsAsc(array));
            System.out.println();
        }
    }

    public static void insertionSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            // arr[i] 前面的数都是有序的
            // arr[i] 要和它前面所有的数依次进行比较，
            // 一旦某个数比它大，就说明 arr[i] 需要插入到这个数前面去
            // 也就是这个数要依次往后挪一位，空出一个位置给arr[i]
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    for (int k = i; k > j; k--) {
                        arr[k] = arr[k - 1];
                    }
                    arr[j] = temp;
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
                    a[j+1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j+1] = value; // 插入数据
        }
    }
}
