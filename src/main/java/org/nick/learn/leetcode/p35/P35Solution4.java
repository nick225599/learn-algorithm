package org.nick.learn.leetcode.p35;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class P35Solution4 {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left + 1) >> 1);
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
    }



}
