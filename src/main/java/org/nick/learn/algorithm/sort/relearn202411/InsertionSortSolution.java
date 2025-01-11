package org.nick.learn.algorithm.sort.relearn202411;

public class InsertionSortSolution {

    // 空间复杂度 O(1)，原地排序
    // 最坏时间复杂度 O(n^2)
    // 平均时间复杂度 O(n^2)
    // 非稳定排序
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
        return arr;
    }
}
