package org.nick.learn.algorithm.common;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class ArrayUtils {

    public static int count(int[] arr) {
        int count = 0;
        for (int i : arr) {
            count += i;
        }
        return count;
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

    public static void main(String[] args) {
        int[] arr = {2, 2, 1};
        System.out.println(arrayIsAsc(arr));

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
}
