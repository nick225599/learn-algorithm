package org.nick.learn.algorithm.leetcode.problems2974;

import java.util.Arrays;

/**
 * 第 6 版本，按照 JDK 源码，在元素个数小于 44 时，选择使用插入排序
 */
public class Solution6 {
    public int[] numberGame(int[] nums) {
        quickSort(nums);

        for (int i = 0; i < nums.length; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
        return nums;
    }

    private void quickSort(int[] nums) {
        for (int i, k = 0; ++k < nums.length; ) {
            int ai = nums[i = k];
            if (ai < nums[i - 1]) {
                while (--i >= 0 && ai < nums[i]) {
                    nums[i + 1] = nums[i];
                }
                nums[i + 1] = ai;
            }
        }
    }


    /**
     * Sorts the specified range of the array using insertion sort.
     *
     * @param a the array to be sorted
     * @param low the index of the first element, inclusive, to be sorted
     * @param high the index of the last element, exclusive, to be sorted
     */
    private static void insertionSort(int[] a, int low, int high) {
        for (int i, k = low; ++k < high; ) {
            int ai = a[i = k];

            if (ai < a[i - 1]) {
                while (--i >= low && ai < a[i]) {
                    a[i + 1] = a[i];
                }
                a[i + 1] = ai;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{5, 4, 2, 3};
        System.out.println("before sort: " + Arrays.toString(nums));
        new Solution6().quickSort(nums);
        System.out.println("after sort: " + Arrays.toString(nums));
        System.out.println();


        nums = new int[]{1, 3, 2, 5, 4};
        System.out.println("before sort: " + Arrays.toString(nums));
        new Solution6().quickSort(nums);
        System.out.println("after sort: " + Arrays.toString(nums));
        System.out.println();

        nums = new int[]{1, 3, 6, 2, 5, 4};
        System.out.println("before sort: " + Arrays.toString(nums));
        new Solution6().quickSort(nums);
        System.out.println("after sort: " + Arrays.toString(nums));
        System.out.println();


        nums = new int[]{3, 2, 5, 6, 4};
        System.out.println("before sort: " + Arrays.toString(nums));
        new Solution6().quickSort(nums);
        System.out.println("after sort: " + Arrays.toString(nums));
        System.out.println();


        nums = new int[]{5, 4, 2, 3};
        System.out.println(Arrays.toString(new Solution6().numberGame(nums)));
    }
}