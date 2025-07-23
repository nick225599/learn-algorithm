package org.nick.learn.leetcode.p34;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class P34Solution2 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return new int[]{-1, -1};
        }
        if (n == 1) {
            return nums[0] == target ? new int[]{0, 0} : new int[]{-1, -1};
        }


        //nick 放弃了，不知道怎么二分，并处理边界值
        int l = 0;
        int r = n - 1;
        while (l + 1 < r) {
            int midIndex = (r + l) / 2;
            int midNum = nums[midIndex];
            if (target < midNum) {
                r = midIndex;
            } else if (midNum < target) {
                l = midIndex;
            } else {
                return new int[]{midIndex, midIndex};
            }
        }
        return new int[]{-1, -1};
    }
}
