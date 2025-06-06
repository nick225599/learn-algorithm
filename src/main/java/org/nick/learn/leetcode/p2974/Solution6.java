package org.nick.learn.leetcode.p2974;

import lombok.extern.slf4j.Slf4j;

/**
 * 第 6 版本，按照 JDK 源码，在元素个数小于 44 时，选择使用插入排序
 */
@Slf4j
public class Solution6 {
    public int[] numberGame(int[] nums) {
        this.insertionSort(nums);

        for (int i = 0; i < nums.length; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
        return nums;
    }

    public void insertionSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (nums[j] > val) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = val;
        }
    }

//    /**
//     * Sorts the specified range of the array using insertion sort.
//     *
//     * @param a the array to be sorted
//     * @param low the index of the first element, inclusive, to be sorted
//     * @param high the index of the last element, exclusive, to be sorted
//     */
//    private static void insertionSort(int[] a, int low, int high) {
//        for (int i, k = low; ++k < high; ) {
//            int ai = a[i = k];
//
//            if (ai < a[i - 1]) {
//                while (--i >= low && ai < a[i]) {
//                    a[i + 1] = a[i];
//                }
//                a[i + 1] = ai;
//            }
//        }
//    }


}