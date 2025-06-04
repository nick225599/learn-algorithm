package org.nick.learn.leetcode.p35;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class P35Solution1 {

    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length - 1);
    }

    private int searchInsert(int[] nums, int target, int startIndex, int endIndex) {
        int midIndex = ((endIndex - startIndex) >> 1) + startIndex;
        if (target == nums[midIndex]) {
            return midIndex;
        }
        if (target < nums[midIndex]) {
            if(startIndex  == midIndex){
                return midIndex;
            }
            return searchInsert(nums, target, startIndex, midIndex - 1);
        } else {
            if(midIndex == endIndex){
                return midIndex + 1;
            }
            return searchInsert(nums, target, midIndex + 1, endIndex);
        }
    }

}
