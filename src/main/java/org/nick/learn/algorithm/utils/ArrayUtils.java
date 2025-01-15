package org.nick.learn.algorithm.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class ArrayUtils {
    public static boolean arrayIsAsc(int[] oriArr, int[] sortedArr){
        boolean isSorted = arrIsAsc(sortedArr);
        boolean isConsistent = verifyElementConsistency(oriArr, sortedArr);
        return isSorted && isConsistent;
    }

    public static boolean arrayIsDesc(int[] oriArr, int[] sortedArr){
        boolean isSorted = arrayIsDesc(sortedArr);
        boolean isConsistent = verifyElementConsistency(oriArr, sortedArr);
        return isSorted && isConsistent;
    }

    private static boolean verifyElementConsistency(int[] originalArray, int[] sortedArray) {
        if (originalArray.length != sortedArray.length) {
            return false;
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // 统计原始数组中每个元素的频率
        for (int num : originalArray) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // 减去排序后数组中每个元素的频率
        for (int num : sortedArray) {
            if (!frequencyMap.containsKey(num) || frequencyMap.get(num) == 0) {
                // 如果发现不在原始数组中的元素或者数量不匹配
                return false;
            }
            frequencyMap.put(num, frequencyMap.get(num) - 1);
        }

        // 确保所有计数都归零，这意味着两个数组中的元素完全匹配
        for (int count : frequencyMap.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

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

    public static int[] generateIntArray10() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random r = new Random(System.currentTimeMillis());
        for (int times = 0; times < 1000; times++) {
            int indexA = r.nextInt(10);
            int indexB = r.nextInt(10);
            swap(arr, indexA, indexB);
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

    private static boolean arrIsAsc(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean arrayIsDesc(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}