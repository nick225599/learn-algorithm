package org.nick.learn.leetcode.p169;

public class P169Solution2 {
    /**
     * 重温 Boyer-Moore 投票算法
     *
     * 时间复杂度 O(n)
     */
    public int majorityElement(int[] nums) {
        if (nums.length < 1) {
            throw new IllegalArgumentException();
        }
        if (nums.length == 1) {
            return nums[0];
        }
        Integer i = null;
        int count = 0;
        for (int num : nums) {
            if (i == null) {
                i = num;
            }
            if (i == num) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                i = num;
                count = 1;
            }
        }
        return i;
    }
}
