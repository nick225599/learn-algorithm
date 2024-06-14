package org.nick.learn.algorithm.common;

import java.util.Random;

public class ArrayUtils {

    public static int[] generateIntArray(int length) {
        int[] arr = new int[length];
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < length; i++) {
            arr[i] = r.nextInt(length);
        }
        return arr;
    }

    public static boolean arrayIsSorted(int[] array, String type) {
        if ("ASC".equals(type)) {
            for (int i = 0; i < array.length - 2; i++) {
                if (array[i] > array[i + 1]) {
                    return false;
                }
            }
            return true;
        } else if ("DESC".equals(type)) {
            for (int i = 0; i < array.length - 2; i++) {
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
}
