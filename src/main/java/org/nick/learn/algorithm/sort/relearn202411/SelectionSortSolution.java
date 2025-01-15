package org.nick.learn.algorithm.sort.relearn202411;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SelectionSortSolution {

    // 稳定排序、原地排序，最坏时间复杂度 O(n^2)，平均时间复杂度呢？跟冒泡类似应该也是O(n^2)
    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            if (i != minIdx) {
                int tmp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = tmp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            System.out.println(i << 1);
            log.info("----------------------");

        }
    }
}
