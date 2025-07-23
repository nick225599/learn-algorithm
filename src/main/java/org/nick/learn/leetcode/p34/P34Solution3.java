package org.nick.learn.leetcode.p34;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class P34Solution3 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        if (n == 0) {
            return new int[]{-1, -1};
        }
        if (n == 1) {
            return nums[0] == target ? new int[]{0, 0} : new int[]{-1, -1};
        }

        // 查找左边界
        int startingPosition = binarySearch(nums, n, target, true);

        if (startingPosition == -1) {
            return new int[]{-1, -1};
        }

        // 查找右边界
        int endingPosition = binarySearch(nums, n, target, false);

        return new int[]{startingPosition, endingPosition};
    }

    /**
     * @param searchStartingPosition true: search the starting position of a given target value;
     *                               false: search the ending position of a given target value
     */
    private int binarySearch(int[] nums, int n, int target, boolean searchStartingPosition) {
        int l = 0;
        int r = n - 1;
        int position = -1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (target < nums[m]) {
                r = m - 1;
            } else if (target > nums[m]) {
                l = m + 1;
            } else {
                if (searchStartingPosition) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
                position = m;
            }
        }
        return position;
    }
}
