package org.nick.learn.algorithm.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class ArrayUtils {
    public static void print(boolean[][] booleans) {
        for (boolean[] bs : booleans) {
            StringBuilder rowStr = new StringBuilder("[ ");
            String columnSpilt = ", ";
            for (boolean b : bs) {
                rowStr.append(b ).append(columnSpilt);
            }
            rowStr.delete(rowStr.length() - columnSpilt.length(), rowStr.length());
            rowStr.append(" ]");
            log.info(rowStr.toString());
        }
    }

    public static void print(int[][] grid) {
        for (int[] ints : grid) {
            StringBuilder rowStr = new StringBuilder("[ ");
            String columnSpilt = ", ";
            for (int anInt : ints) {
                if (Integer.toString(anInt).length() < 2) {
                    rowStr.append(" ");
                }
                rowStr.append(anInt).append(columnSpilt);
            }
            rowStr.delete(rowStr.length() - columnSpilt.length(), rowStr.length());
            rowStr.append(" ]");
            log.info(rowStr.toString());
        }
    }

    public static int count(int[] arr) {
        int count = 0;
        for (int i : arr) {
            count += i;
        }
        return count;
    }

    public static int[] generateIntArray10() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random r = new Random(System.currentTimeMillis());
        for (int times = 0; times < 1000; times++) {
            int indexA = r.nextInt(10);
            int indexB = r.nextInt(10);
            int temp = arr[indexA];
            arr[indexA] = arr[indexB];
            arr[indexB] = temp;
        }
        return arr;
    }

    public static int[] generateIntArray(int length) {
        List<Integer> list = new ArrayList<>();
        Random r = new Random(System.currentTimeMillis());
        while (list.size() < length) {
            int tmpI = r.nextInt();
            list.add(tmpI);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static boolean arrayIsSorted(int[] array, String type) {
        if ("ASC".equals(type)) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    return false;
                }
            }
            return true;
        } else if ("DESC".equals(type)) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalArgumentException("Illegal Type: " + type);
        }
    }

    public static boolean arrayIsAsc(int[] array) {
        return arrayIsSorted(array, "ASC");
    }

    public static boolean arrayIsDesc(int[] array) {
        return arrayIsSorted(array, "DESC");
    }

    public static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}