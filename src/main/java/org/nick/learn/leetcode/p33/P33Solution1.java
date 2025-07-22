package org.nick.learn.leetcode.p33;

public class P33Solution1 {

    // 0ms, 100%
    // 时间复杂度 O(n) 又如何...
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
