package org.nick.learn.leetcode.p33;

public class P33Solution4 {


    public int search(int[] nums, int target) {
        int n = nums.length;

        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            int mid = nums[m];

            if (target < mid) {
                if (nums[l] <= nums[m] && nums[l] <= target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (mid < target) {
                if (nums[m] < nums[r] && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                return m;
            }


        }
        return -1;
    }


}
