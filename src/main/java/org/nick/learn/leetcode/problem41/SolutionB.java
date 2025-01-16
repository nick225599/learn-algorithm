package org.nick.learn.leetcode.problem41;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 力扣官方题解
 */
@Slf4j
public class SolutionB {
    public int firstMissingPositive(int[] nums) {
        log.info("before swap: {}", Arrays.toString(nums));
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
//                int temp = nums[nums[i] - 1];
//                nums[nums[i] - 1] = nums[i];
//                nums[i] = temp;
                swap(nums, nums[i] - 1, i);
                log.info("after swap: {}", Arrays.toString(nums));
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }


    private void swap(int[] arr, int l, int r) {
        log.info("swap happens");
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}
