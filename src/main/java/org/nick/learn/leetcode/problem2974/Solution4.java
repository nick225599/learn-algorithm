package org.nick.learn.leetcode.problem2974;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 第 3 版，手写快排，使用极客时间上的单向指针便利方案
 */
@Slf4j
public class Solution4 {
    public int[] numberGame(int[] nums) {
        this.quickSort(nums);
//        Arrays.parallelSort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
        return nums;
    }

    private void quickSort(int[] nums) {
        this.quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int pivot = arr[r];

        int i = l, j = l;
        for (; j < r; j++) {
            if (arr[j] <= pivot) {
                // swap arr[i] <-> arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
            }
        }
        arr[r] = arr[i];
        arr[i] = pivot;

        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }


    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{5, 4, 2, 3};
        log.info("before sort: " + Arrays.toString(nums));
        new Solution4().quickSort(nums);
        log.info("after sort: " + Arrays.toString(nums));
        System.out.println();


        nums = new int[]{1, 3, 2, 5, 4};
        log.info("before sort: " + Arrays.toString(nums));
        new Solution4().quickSort(nums);
        log.info("after sort: " + Arrays.toString(nums));
        System.out.println();

        nums = new int[]{1, 3, 6, 2, 5, 4};
        log.info("before sort: " + Arrays.toString(nums));
        new Solution4().quickSort(nums);
        log.info("after sort: " + Arrays.toString(nums));
        System.out.println();


        nums = new int[]{3, 2, 5, 6, 4};
        log.info("before sort: " + Arrays.toString(nums));
        new Solution4().quickSort(nums);
        log.info("after sort: " + Arrays.toString(nums));
        System.out.println();


        nums = new int[]{5, 4, 2, 3};
        System.out.println(Arrays.toString(new Solution4().numberGame(nums)));
    }
}