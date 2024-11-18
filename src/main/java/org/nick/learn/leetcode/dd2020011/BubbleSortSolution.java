package org.nick.learn.leetcode.dd2020011;

public class BubbleSortSolution {

    // 稳定排序、原地排序，但是最坏时间复杂度 O(n^2)， 平均时间复杂度呢？
    // 需要概率论定量分析，可以采用王争的不严谨做法（https://time.geekbang.org/column/article/41802）
    public static int[] bubbleSort(int[] arr) {
        for (int endIdx = arr.length - 1; endIdx > 0; endIdx--) {
            for (int i = 0; i < endIdx; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
        }
        return arr;
    }


}
