package org.nick.learn.leetcode.p2974;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 第 3 版，手写快排
 */
@Slf4j
public class Solution3 {
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

    private void quickSort(int[] nums, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int baseValue = nums[endIndex];

        int lIndex = startIndex, rIndex = endIndex - 1;
        while (lIndex <= rIndex) {
            if (nums[lIndex] <= baseValue) {
                lIndex += 1;
            } else {
                int temp = nums[rIndex];
                nums[rIndex] = nums[lIndex];
                nums[lIndex] = temp;
                rIndex -= 1;
            }
        }
        nums[endIndex] = nums[lIndex];
        nums[lIndex] = baseValue;

        quickSort(nums, startIndex, lIndex - 1);
        quickSort(nums, rIndex + 2, endIndex);
    }


    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{5, 4, 2, 3};
        log.info("before sort: " + Arrays.toString(nums));
        new Solution3().quickSort(nums);
        log.info("after sort: " + Arrays.toString(nums));
        System.out.println();


        nums = new int[]{1, 3, 2, 5, 4};
        log.info("before sort: " + Arrays.toString(nums));
        new Solution3().quickSort(nums);
        log.info("after sort: " + Arrays.toString(nums));
        System.out.println();

        nums = new int[]{1, 3, 6, 2, 5, 4};
        log.info("before sort: " + Arrays.toString(nums));
        new Solution3().quickSort(nums);
        log.info("after sort: " + Arrays.toString(nums));
        System.out.println();


        nums = new int[]{3, 2, 5, 6, 4};
        log.info("before sort: " + Arrays.toString(nums));
        new Solution3().quickSort(nums);
        log.info("after sort: " + Arrays.toString(nums));
        System.out.println();


        nums = new int[]{5, 4, 2, 3};
        System.out.println(Arrays.toString(new Solution3().numberGame(nums)));
    }
}