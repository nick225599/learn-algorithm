package org.nick.learn.leetcode.p35;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class P35Solution3 {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target == nums[mid]) {
                return mid;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;

//        return searchInsert(nums, target, 0, nums.length - 1);
    }

    private int searchInsert(int[] nums, int target, int startIndex, int endIndex) {
        int midIndex = ((endIndex - startIndex) >> 1) + startIndex;
        if (target == nums[midIndex]) {
            return midIndex;
        }
        if (target < nums[midIndex]) {
            if (startIndex == midIndex) {
                return midIndex;
            }
            return searchInsert(nums, target, startIndex, midIndex - 1);
        } else {
            if (midIndex == endIndex) { //TODO nick 20250604 看下官方题解为啥不需要这种特殊逻辑处理
                return midIndex + 1;
            }
            return searchInsert(nums, target, midIndex + 1, endIndex);
        }
    }

}
