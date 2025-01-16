package org.nick.learn.leetcode.problem169;


import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * 随机 3 次 + 分治
 * 时间复杂度 O(nlogn)
 * 空间复杂度 O(logn)，分治的栈空间
 */
@Slf4j
public class SolutionE {
    public int majorityElement(int[] nums) {
        // 随机 3 次
//        for (int times = 1; times <= 3; times++) {
//            int randomIndex = new Random().nextInt(nums.length);
//            int candidate = nums[randomIndex];
//            int count = 0;
//            for (int num : nums) {
//                if (num == candidate) {
//                    count++;
//                }
//            }
//            if (count > nums.length / 2) {
//                return candidate;
//            }
//        }

        // 分治法
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private int majorityElementRec(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }
        int midIndex = (high - low) / 2 + low;
        int meL = majorityElementRec(nums, low, midIndex);
        int meR = majorityElementRec(nums, midIndex + 1, high);
        if (meL == meR) {
            return meL;
        } else {
            int count = 0;
            for (int i = low; i <= high; i++) {
                if (nums[i] == meL) {
                    count++;
                }
            }
            int size = high - low + 1;
            if (count > size / 2) {
                return meL;
            } else {
                return meR;
            }
        }
    }
}
